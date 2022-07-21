package http;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import util.HttpRequestUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.HashMap;

public class RequestParams {
    private static final Logger log = LoggerFactory.getLogger(RequestParams.class);
    public HashMap<String,String> requestParam = new HashMap<>();

    public void addQueryString(String queryString){
        putParams(queryString);
    }
    private void putParams(String data){
        log.debug("data : {}",data);

        if(data == null || data.isEmpty()){
            return;
        }
        requestParam.putAll(HttpRequestUtils.parseQueryString(data));
        log.debug("params : {}",requestParam);
    }

    public void addBody(String body){
        putParams(body);
    }

    public String getParameter(String name){
        return requestParam.get(name);
    }

}
