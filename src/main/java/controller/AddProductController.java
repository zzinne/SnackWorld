package controller;

import http.HttpRequest;
import http.HttpResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import snack.Item;
import snack.Products;

public class AddProductController extends AbstractController{
    private static final Logger log = LoggerFactory.getLogger(AddProductController.class);

    @Override
    protected void doPost(HttpRequest httpRequest, HttpResponse httpResponse){
        Item item = new Item(httpRequest.getParameter("name"),Integer.parseInt(httpRequest.getParameter("amount")));
        log.debug("item : {}",item);
        Products.addItem(item);
        httpResponse.sendRedirect("/index.html");

    }
}
