package http;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.DataOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

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

    public void forward(String url){
        try {
            byte[] body = Files.readAllBytes(new File("./src/webapp"+ url).toPath());
            header.put("Content-Type", "text/html;charset=utf-8");
            header.put("Content-Length", String.valueOf(body.length));
            response200Header(body.length);
            responseBody(body);
        }catch (IOException e){

        }
    }

    public void forwardBody(String body){
        byte[] contents = body.getBytes();
        header.put("Content-Type", "text/html;charset=utf-8");
        header.put("Content-Length", contents.length+"");
        response200Header(contents.length);
        responseBody(contents);
    }

    public void response200Header(int lengthOfBodyContent){
        try{
            dos.writeBytes("HTTP/1.1 200 OK \r\n");
            processHeaders();
            dos.writeBytes("\r\n");

        }catch (IOException e){
            log.error(e.getMessage());
        }

    }
    public void response302Header(int lengthOfBodyContent){
        try{
            dos.writeBytes("HTTP/1.1 302 Redirect \r\n");
            dos.writeBytes("Location: /index.html \r\n");
            // 로그인 성공시 dos.writeBytes("Set-Cookie: loggined=true; Path=/");
            dos.writeBytes("\r\n");

        }catch (IOException e){
            log.error(e.getMessage());
        }

    }


    public void sendRedirect(String redirectUrl){
        try {
            dos.writeBytes("HTTP/1.1 302 Found \r\n");
            processHeaders();
            dos.writeBytes("Location: "+redirectUrl+"\r\n");
            dos.writeBytes("\r\n");
        } catch (IOException e){
            log.error(e.getMessage());
        }
    }
    private void processHeaders(){
        try {
            Set<String> keys = header.keySet();
            for (String key : keys){
                dos.writeBytes(key + ": " + header.get(key) + " \r\n");
            }
        } catch (IOException e) {
            log.error(e.getMessage());
        }
    }

    private void responseBody(byte[] body){
        try {
            dos.write(body, 0, body.length);
            dos.writeBytes("\r\n");
            dos.flush();
        } catch (IOException e) {
            log.error(e.getMessage());
        }
    }



}
