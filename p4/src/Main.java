import entity.Product;
import parser.ProductParser;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<Product> productList = getProductListFromOddo();
        saveProductsInDataBase(productList);
    }

    private static List<Product> getProductListFromOddo() {
        ServiceManager serviceManager = new ServiceManager();
        ProductParser productParser = new ProductParser();
        try {
            List<Object> objectList = serviceManager.getProductsFromOdoo();
            return productParser.parserProducts(objectList);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private static void saveProductsInDataBase(List<Product> productList) {
        MysqlManager mysqlManager = new MysqlManager();
        try {
            mysqlManager.openConnection();
            mysqlManager.inst(productList);
//            mysqlManager.testInsert();
            mysqlManager.closeConecction();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
