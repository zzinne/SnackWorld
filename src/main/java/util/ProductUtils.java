package util;

import snack.Products;

import java.util.Map;

public class ProductUtils {

    public static String productRegist(Map<String,String> requestMap){
       Products products = new Products();
        String name = "";
        int amount = 0;
        for(Map.Entry<String,String> values:requestMap.entrySet()){
            if("name".equals(values.getKey())){
                name = values.getValue();
            }
            if("amount".equals(values.getKey())){
                amount = Integer.parseInt(values.getValue());
            }
        }
        products.addItem(name,amount);
        return "Location: /product/list \r\n";
    }

}
