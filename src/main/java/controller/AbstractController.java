package controller;

import http.HttpMethod;
import http.HttpRequest;
import http.HttpResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class AbstractController implements Controller {

    @Override
    public void service(HttpRequest request, HttpResponse response) {
        HttpMethod httpMethod = request.getMethod();

        if (httpMethod.isPost()) {
            doPost(request, response);
        } else {
            doGet(request, response);
        }
    }

    protected void doPost(HttpRequest request, HttpResponse response) {

    }

    protected void doGet(HttpRequest request, HttpResponse response) {

    }
}