package http;

import lombok.Getter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import server.RequestHandler;
import util.IOUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;


public class HttpRequest {
    private static final Logger log = LoggerFactory.getLogger(RequestHandler.class);

    private RequestLine requestLine;
    private HttpHeaders httpHeaders;
    private RequestParams requestParams = new RequestParams();


    public HttpRequest(InputStream is) {
        try{
            BufferedReader br = new BufferedReader(new InputStreamReader(is,"UTF-8"));
            requestLine = new RequestLine(createRequestLine(br));
            requestParams.addQueryString(requestLine.getQueryString());
            httpHeaders = processHeaders(br);
            requestParams.addBody(IOUtils.readData(br, httpHeaders.getContentLength()));

        } catch (IOException e){
            log.error(e.getMessage());
        }
    }

    private String createRequestLine(BufferedReader br) throws IOException{
        String line = br.readLine();
        if(line == null){
            throw new IllegalStateException();
        }
        return line;
    }

    private HttpHeaders processHeaders(BufferedReader br) throws IOException{
        HttpHeaders headers = new HttpHeaders();
        String line;
        while (!(line = br.readLine()).equals("")){
            headers.add(line);
        }
        return headers;
    }


    public HttpMethod getMethod(){
        return requestLine.getMethod();
    }

    public String getPath(){
        return requestLine.getPath();
    }

    public String getHeader(String name){
        return httpHeaders.getHeader(name);
    }
    public String getParameter(String name){
        return requestParams.getParameter(name);
    }
}
