package server;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.net.Socket;
import java.nio.file.Files;
import java.nio.file.Path;

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
            BufferedReader br = new BufferedReader(new InputStreamReader(in));
            String line = br.readLine();
            log.debug("request line :  {}",line);

            if(line == null){
                return;
            }
            String[] tokens = line.split(" ");
            while(!"".equals(line)){
                line = br.readLine();
                log.debug("header : {}", line);
            }
            DataOutputStream dos = new DataOutputStream(out);
            if("/product/regForm.html".equals(tokens[1])){
                // 상품 폼 페이지
                byte[] body = Files.readAllBytes(new File("./src/webapp/"+tokens[1]).toPath());
                response200Header(dos, body.length);
                responseBody(dos,body);
            }
            if("/product".equals(tokens[1])){

                // 상품등록
            }


            //TODO 사용자 요청에 대한 처리는 이곳에서 구현하면 된다.

            //String path = "src/webapp/index.html";
            //byte[] body = Files.readAllBytes(Path.of(path));
            byte[] body = Files.readAllBytes(new File("./src/webapp/"+tokens[1]).toPath());
            response200Header(dos, body.length);
            responseBody(dos,body);

        }catch (IOException e){
            log.error(e.getMessage());

        }

    }

    private void response200Header(DataOutputStream dos, int lengthOfBodyContent){
        try{
            dos.writeBytes("HTTP/1.1 200 OK \r\n");
            dos.writeBytes("Content-Type: text/html; charset=utf-8 \r\n");
            dos.writeBytes("Content-Length:"+lengthOfBodyContent+"\r\n");
            dos.writeBytes("\r\n");

        }catch (IOException e){
            log.error(e.getMessage());
        }

    }

    private void responseBody(DataOutputStream dos, byte[] body){
        try{
            dos.write(body,0,body.length);
            dos.writeBytes("\r\n");
            dos.flush();
        }catch (IOException e){
            log.error(e.getMessage());
        }
    }


}
