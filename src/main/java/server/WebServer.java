package server;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class WebServer {
    private static final Logger log =  LoggerFactory.getLogger(WebServer.class);
    private static final int DEFALT_PORT = 8080;

    public static void main(String[] args) {
        int port = 0;
        if(args == null||args.length==0){
            port = DEFALT_PORT;
        } else {
            port = Integer.parseInt(args[0]);
        }

        try(ServerSocket listenSocket = new ServerSocket(port)){
            log.info("Web Application Server started {} port",port);
            Socket connection;
            while ((connection = listenSocket.accept()) != null){
                RequestHandler requestHandler = new RequestHandler(connection);
                requestHandler.start();
            }
        } catch (IOException e){
            throw new RuntimeException(e);
        }

    }
}
