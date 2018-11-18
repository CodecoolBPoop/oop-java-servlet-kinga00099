package com.codecool.servlet;

public class Item {
    private int id = 0;
    private String name;
    private double price;

    Item(String name, double price) {
        this.id = id++;
        this.name = name;
        this.price = price;
    }
}
