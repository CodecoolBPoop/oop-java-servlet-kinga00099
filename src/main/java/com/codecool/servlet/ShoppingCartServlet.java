package com.codecool.servlet;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "shoppingCartServlet", urlPatterns = {"/cart"})
public class ShoppingCartServlet extends HttpServlet {
    private double price;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        List<Item> items = ItemStore.getItems();
        StringBuilder cart = new StringBuilder();


        cart.append("<table>");

        for (Item item : items) {
            cart.append("<tr><td>");
            cart.append(item.getId());
            cart.append("</td>");

            cart.append("<td>");
            cart.append(item.getName());
            cart.append("</td>");

            cart.append("<td>");
            cart.append(item.getPrice());
            cart.append("</td></tr>");
            price = price + item.getPrice();

        }

        cart.append("<tr><td><b>Sum of Price:</b></td>");
        cart.append("<td><b>");
        cart.append(price);
        cart.append("</b></td>");
        cart.append("</table>");


        PrintWriter out = response.getWriter();

        out.println(
                "<html>\n" +
                        "<head><title>WebShop</title></head>\n" +
                        "<body>\n" +
                        "<h1 align = \"center\">WebShop</h1>\n" +
                        cart.toString() +
                        "</body></html>"
        );
    }

}
