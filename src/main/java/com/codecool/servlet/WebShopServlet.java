package com.codecool.servlet;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

@WebServlet(name = "webShopServlet", urlPatterns = {"/webshop"})
public class WebShopServlet extends HttpServlet {
    private Item[] itemsAvailable;

    @Override
    public void init() {
        itemsAvailable = new Item[]{ new Item(1,"Asus Laptop", 1600.0),
                new Item(2,"Harry Potter Ebook", 50.0),
                new Item(3,"World of Warcraft Chronicle", 40.0),
                new Item(4,"Marvel Comics", 25.0),
                new Item(5,"Jamie Oliver Cookbook", 100.0)};
    }


}
