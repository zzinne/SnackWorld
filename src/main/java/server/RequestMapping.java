package server;

import controller.AddProductController;
import controller.Controller;

import java.util.HashMap;
import java.util.Map;

public class RequestMapping {
    private static Map<String, Controller> controllers = new HashMap<String, Controller>();

    static {
        controllers.put("product/regForm", new AddProductController());
    }

    public static Controller getController(String requestUrl){
        return controllers.get(requestUrl);
    }
}
