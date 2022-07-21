package controller;

import http.HttpRequest;
import http.HttpResponse;

public class ProductController extends AbstractController{
    @Override
    protected void doPost(HttpRequest httpRequest, HttpResponse httpResponse){
        httpResponse.sendRedirect("/product/regForm.html");
    }
}
