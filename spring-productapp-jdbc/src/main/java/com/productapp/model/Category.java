package com.productapp.model;

public enum Category {
    HOME("HOME FURNISHING"),
    ELECTRONICS("ELECTRONICS"),
    APPARELS("APPARELS"),
    COSMETICS("COSMETICS"),
    TOYS("TOYS AND GAMES");

    public String type;
    Category(String value) {
        this.type = value;
    }
}
