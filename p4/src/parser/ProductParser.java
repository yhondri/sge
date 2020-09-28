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
                    if((((Map) object).get("default_code")) instanceof Boolean){
                        product.setDefaultCode("no_default_code");
                    }else{
                        product.setDefaultCode((String)((Map) object).get("default_code"));
                    }

                    product.setActive((boolean)((Map) object).get("active"));
                    if (safeCast(((Map) object).get("barcode"), String.class)  != null)
                    product.setBarcode((String)((Map) object).get("barcode"));
                    product.setVolume((double)((Map) object).get("volume"));
                    product.setWeight((double)((Map) object).get("weight"));
                    product.setName((String)((Map) object).get("name"));
                    product.setList_price((double)((Map) object).get("list_price"));
                    productList.add(product);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            return productList;
        }
        return  productList;
    }

    public static <T> T safeCast(Object o, Class<T> clazz) {
        return clazz != null && clazz.isInstance(o) ? clazz.cast(o) : null;
    }
}
