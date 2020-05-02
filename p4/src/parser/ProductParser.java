package parser;

import entity.Product;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class ProductParser {
    public List<Product> parserProducts(List<Object> objectList) {
        List<Product> productList = new ArrayList<>();
        try {
            for (Object object : objectList) {
                if (object instanceof Map) {
                    Product product = new Product();
                    product.setId((int) ((Map) object).get("id"));
                    product.setDefaultCode((String)((Map) object).get("default_code"));
                    product.setActive((boolean)((Map) object).get("active"));
                    product.setProductTmplId((int)((Map) object).get("product_tmpl_id"));
                    product.setBarcode((String)((Map) object).get("barcode"));
                    product.setVolume((int)((Map) object).get("volume"));
                    product.setWeight((int)((Map) object).get("weight"));
                    product.setMessageLastPost((Date)((Map) object).get("message_last_post"));
                    product.setActivityDateDeadline((Date)((Map) object).get("activity_date_deadline"));
                    product.setCreateUID((int)((Map) object).get("create_uid"));
                    product.setCreateDate((Date)((Map) object).get("create_date"));
                    product.setWriteUID((int)((Map) object).get("write_uid"));
                    product.setWriteDate((Date)((Map) object).get("write_date"));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            return productList;
        }
        return  productList;
    }
}