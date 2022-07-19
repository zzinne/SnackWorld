package http;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;


public class HttpHeaders {
    private static final String CONTENT_LENGTH = "Content-Length";

    private static final Logger log = LoggerFactory.getLogger(HttpHeaders.class);
    private Map<String, String> headers = new HashMap<>();

    void add(String header){
        log.debug("header : {}", header);
        String[] splitHeaders = header.split(":");
        headers.put(splitHeaders[0],splitHeaders[1].trim());
    }

    String getHeader(String name){
        return headers.get(name);
    }

    int getIntHeader(String name){
        String header = getHeader(name);
        return header == null ? 0: Integer.parseInt(header);
    }

    int getContentLength(){
        return getIntHeader(CONTENT_LENGTH);
    }

}
