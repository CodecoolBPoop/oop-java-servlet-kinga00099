package com.codecool.servlet;

import java.util.ArrayList;
import java.util.List;

public class ItemStore {
    private static List<Item> items = new ArrayList<>();

    static void add(Item item) {
        items.add(item);
    }

    static void remove(Item item) {
        items.remove(item);
    }

    static List<Item> getItems() {
        return items;
    }

    static Item getItemByIndex(int index) {
        return items.get(index);
    }
}
