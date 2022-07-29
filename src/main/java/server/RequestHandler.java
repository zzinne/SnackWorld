package server;

import controller.Controller;
import db.Users;
import http.HttpRequest;
import http.HttpResponse;
import netscape.javascript.JSObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import snack.Item;
import snack.Products;
import snack.User;
import util.HttpRequestUtils;
import util.IOUtils;
import util.ProductUtils;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.Socket;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class RequestHandler extends Thread{
    private static final Logger log =  LoggerFactory.getLogger(RequestHandler.class);
    private Socket connection;

    public RequestHandler(Socket socket){
        this.connection = socket;

    }

    @Override
    public void run(){
        log.debug("New Client Connect Connect IP: {}, Port : {}", connection.getInetAddress(), connection.getPort());

        try(InputStream in = connection.getInputStream();
            OutputStream out = connection.getOutputStream()){

            HttpRequest httpRequest = new HttpRequest(in)  ;
            HttpResponse httpResponse = new HttpResponse(out);

            Controller controller = RequestMapping.getController(httpRequest.getPath());
            if(controller == null ){
                String path = getDefaultPath(httpRequest.getPath());
                httpResponse.forward(path);
            } else {
                controller.service(httpRequest,httpResponse);
//            if("/product/regForm.html".equals(tokens[1]))
            }
//                // 상품 폼 페이지
//                byte[] body = Files.readAllBytes(new File("./src/webapp/"+tokens[1]).toPath());
//                httpResponse.response200Header(dos, body.length);
//                httpResponse.responseBody(dos,body);
//            }
//            if("/product".equals(tokens[1])){
//                Map<String,String> params = HttpRequestUtils.parseQueryString(data);
//                String location = ProductUtils.productRegist(params);
//                response302Header(dos,location);
//
//            }
//            if("/product/list".equals(tokens[1])){
//                String body = ProductUtils.selectProductList();
//                response200Header(dos, body.length());
//                responseBody(dos,body.getBytes());
//            }
//            if("/user/create".equals(tokens[1])){
//                String body = IOUtils.readData(br,getContentLength(dataLenth));
//                Map<String,String> params = HttpRequestUtils.parseQueryString(body);
//                User user = new User();
//
//                ;
//
//                //response302Header(dos,getContentLength(dataLenth));
//
//            }


            //http세션 쿠키 키 jssionid
            //       쿠키값 확인


            //TODO 사용자 요청에 대한 처리는 이곳에서 구현하면 된다.

            //String path = "src/webapp/index.html";
            //byte[] body = Files.readAllBytes(Path.of(path));
//            byte[] body = Files.readAllBytes(new File("./src/webapp/"+tokens[1]).toPath());
//            response200Header(dos, body.length);
//            responseBody(dos,body);

        }catch (IOException e){
            log.error(e.getMessage());

        }

    }

    private String getDefaultPath(String path){
        if(path.equals("/")){
            return "/index.html";
        }
        return path;
    }
//    public static String requestData(BufferedReader br, int contentLength) throws IOException{
//        char[] body = new char[contentLength];
//        br.read(body,0,contentLength);
//        return String.copyValueOf(body);
//    }
//
//    private static int getContentLength(String read){
//        String[] split = read.replaceAll(" ","").split(":");
//        return Integer.parseInt(split[1]);
//    }



}