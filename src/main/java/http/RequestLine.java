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
        log.debug("");

        String[] tokens = requestLine.split(" ");
        this.httpMethod = HttpMethod.valueOf(tokens[0]);
        String[] url = tokens[1].split("\\?");

        this.path = url[0];

        if(url.length == 2){
            this.queryString = url[1];
        }


    }
}
