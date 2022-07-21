package util;

import snack.Item;
import snack.Products;

import java.util.Map;

public class ProductUtils {
    public static Products products = new Products();
    public static String productRegist(Map<String, String> requestMap){

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
       // products.addItem(name,amount);
        return "Location: /product/list \r\n";
    }
    public static String selectProductList(){

        String body = "<!DOCTYPE html>"
                +"<head> 스낵월드 상품목록 </head>"
                +"<body>";

//        for (Map.Entry<String, Item> value: products.getItemHashMap().entrySet()){
//            body = body + "상품명 : "+value.getValue().name+" 가격 : "+value.getValue().amount+"</br>";
//        }
        body = body+"</body>"
                +"</html>";
        return body;
    }

}
