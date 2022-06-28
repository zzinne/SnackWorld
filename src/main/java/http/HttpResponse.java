package http;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.DataOutputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;

public class HttpResponse {
    private static final Logger log = LoggerFactory.getLogger(HttpResponse.class);

    private DataOutputStream dos = null;

    private Map<String, String> header = new HashMap<String,String>();

    public HttpResponse(OutputStream out){
        dos = new DataOutputStream(out);
    }

    public void addHeader (String key, String value){
        header.put(key,value);
    }
}
