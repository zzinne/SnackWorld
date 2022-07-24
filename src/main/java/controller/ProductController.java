package controller;

import http.HttpRequest;
import http.HttpResponse;

public class ProductController extends AbstractController{
    @Override
    protected void doGet(HttpRequest httpRequest, HttpResponse httpResponse){
        httpResponse.forward("/product/regForm.html");
    }
}
