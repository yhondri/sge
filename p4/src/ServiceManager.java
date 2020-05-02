import org.apache.xmlrpc.XmlRpcException;
import org.apache.xmlrpc.client.XmlRpcClient;
import org.apache.xmlrpc.client.XmlRpcClientConfigImpl;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import static java.util.Arrays.asList;
import static java.util.Collections.emptyList;
import static java.util.Collections.emptyMap;

public class ServiceManager {
    final XmlRpcClient client = new XmlRpcClient();
    final XmlRpcClientConfigImpl start_config = new XmlRpcClientConfigImpl();

    private URL getServerURL() throws MalformedURLException {
        return new URL("https://demo.odoo.com/start");
    }

    public List<Object> getProductsFromOdoo() throws XmlRpcException, MalformedURLException {
        URL serverURL = getServerURL();
        start_config.setServerURL(serverURL);
        final Map<String, String> info = (Map<String, String>) client.execute(start_config, "start", emptyList());

        final String url = info.get("host"),
                db = info.get("database"),
                username = info.get("user"),
                password = info.get("password");

        final XmlRpcClientConfigImpl common_config = new XmlRpcClientConfigImpl();
        common_config.setServerURL(new URL(String.format("%s/xmlrpc/2/common", url)));

        client.execute(common_config, "version", emptyList());

        int uid = (int)client.execute(
                common_config, "authenticate", asList(
                        db, username, password, emptyMap()));
        System.out.println("UID " +uid);

        final XmlRpcClient models = new XmlRpcClient() {{
            setConfig(new XmlRpcClientConfigImpl() {{
                setServerURL(new URL(String.format("%s/xmlrpc/2/object", url)));
            }});
        }};

        final List ids = asList((Object[])models.execute(
                "execute_kw", asList(
                        db, uid, password,
                        "res.product_product", "search")));

        // TODO: Es probable que tengamos que listar los campos que queremos.
        final List<Object> record = asList((Object[])models.execute(
                "execute_kw", asList(
                        db, uid, password,
                        "res.product_product", "read",
                        asList(ids)
                )
        ));

        return record;
    }

    public void setupConnection() throws MalformedURLException, XmlRpcException {
        URL serverURL = getServerURL();
        start_config.setServerURL(serverURL);
        final Map<String, String> info = (Map<String, String>) client.execute(start_config, "start", emptyList());

        final String url = info.get("host"),
                db = info.get("database"),
                username = info.get("user"),
                password = info.get("password");
    }

    public void checkConnection() throws XmlRpcException, MalformedURLException {
        URL serverURL = getServerURL();
        start_config.setServerURL(serverURL);
        final Map<String, String> info = (Map<String, String>) client.execute(start_config, "start", emptyList());

        final String url = info.get("host"),
                db = info.get("database"),
                username = info.get("user"),
                password = info.get("password");

        final XmlRpcClientConfigImpl common_config = new XmlRpcClientConfigImpl();
        common_config.setServerURL(new URL(String.format("%s/xmlrpc/2/common", url)));

        client.execute(common_config, "version", emptyList());

        int uid = (int)client.execute(
                common_config, "authenticate", asList(
                        db, username, password, emptyMap()));
        System.out.println("UID " +uid);


        final XmlRpcClient models = new XmlRpcClient() {{
            setConfig(new XmlRpcClientConfigImpl() {{
                setServerURL(new URL(String.format("%s/xmlrpc/2/object", url)));
            }});
        }};
        Object result = models.execute("execute_kw", asList(
                db, uid, password,
                "res.partner", "check_access_rights",
                asList("read"),
                new HashMap() {{ put("raise_exception", false); }}
        ));


        System.out.println("Result "+result);

        final List ids = asList((Object[])models.execute(
                "execute_kw", asList(
                        db, uid, password,
                        "res.partner", "search",
                        asList(asList(
                                asList("is_company", "=", true))),
                        new HashMap() {{ put("limit", 1); }})));

        final List<Object> record = asList((Object[])models.execute(
                "execute_kw", asList(
                        db, uid, password,
                        "res.partner", "read",
                        asList(ids)
                )
        ));

        Object record1 = record.get(0);
        if (record1 instanceof  Map) {
            System.out.println("record1 is a Map "+record1);
        }


        result = asList((Object[])models.execute("execute_kw", asList(
                db, uid, password,
                "res.partner", "read",
                asList(ids),
                new HashMap() {{
                    put("fields", asList("name", "country_id", "comment"));
                }}
        )));

        System.out.println("Result "+asList(result));

    }
}
