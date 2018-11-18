package com.codecool.servlet;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "webShopServlet", urlPatterns = {"/webshop"})
public class WebShopServlet extends HttpServlet {
    private Item[] itemsAvailable;
    private String items;

    @Override
    public void init() {
        itemsAvailable = new Item[]{ new Item(1,"Asus Laptop", 1600.0),
                new Item(2,"Harry Potter Ebook", 50.0),
                new Item(3,"World of Warcraft Chronicle", 40.0),
                new Item(4,"Marvel Comics", 25.0),
                new Item(5,"Jamie Oliver Cookbook", 100.0)};
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        StringBuilder sb = new StringBuilder();
        for (Item item : itemsAvailable) {
            sb.append("<div>");
            sb.append("<table>");

            sb.append("<tr>");

            sb.append("<td>");
            sb.append(item.getId());
            sb.append("</td>");

            sb.append("<td>");
            sb.append(item.getName());
            sb.append("</td>");

            sb.append("<td>");
            sb.append(item.getPrice());
            sb.append("</td>");

            sb.append("<td>");
            sb.append("<button><a href=\"/webshop?item=");
            sb.append(item.getId());
            sb.append("&remove=false\">Buy</a></button>");
            sb.append("</td>");

            sb.append("<td>");
            sb.append("<button><a href=\"/webshop?item=");
            sb.append(item.getId());
            sb.append("&remove=true\">Remove</a></button>");
            sb.append("</td>");

            sb.append("</tr>");
            sb.append("</table>");
            sb.append("</div>");
        }
        items = sb.toString();

        PrintWriter out = response.getWriter();

        String item = request.getParameter("item");
        if (item != null) {
            if (request.getParameter("remove").equals("true")) {
                ItemStore.remove(itemsAvailable[Integer.parseInt(item) - 1]);
            } else ItemStore.add(itemsAvailable[Integer.parseInt(item) - 1]);
        }

        out.println(
                "<html>\n" +
                        "<head><title>WebShop</title></head>\n" +
                        "<body>\n" +
                        "<h1 align = \"center\">WebShop</h1>\n" +
                        items +
                        "</body></html>"
        );
    }

}
