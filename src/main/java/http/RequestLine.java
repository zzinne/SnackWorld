package http;

import lombok.Getter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@Getter
public class RequestLine {
    private static final Logger log =  LoggerFactory.getLogger(RequestLine.class);

    private HttpMethod httpMethod;

    private String path;

    private  String queryString ;

    public RequestLine(String requestLine){
        log.debug("request line : {}",requestLine);

        String[] tokens = requestLine.split(" ");
        this.httpMethod = HttpMethod.valueOf(tokens[0]);
        String[] url = tokens[1].split("\\?");
        log.debug("url : {}",url);
        log.debug("httpMethod : {}",httpMethod);
        this.path = url[0];

        if(url.length == 2){
            this.queryString = url[1];
        }
    }

    public HttpMethod getMethod(){
        return httpMethod;
    }
    public String getPath(){
        return path;
    }
    public String getQueryString(){
        return queryString;
    }

}
