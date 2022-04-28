package com.furnapp.model;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Furniture {
    private String name;
    private Category category;
    private String roomType;
    private String material;
    private Integer furnitureId;
    private Style style;
    private String brand;
    private double price;
    private boolean storageAvailable;

    public Furniture(String name, Category category, String roomType, String material, Style style, String brand, double price, boolean storageAvailable) {
        this.name = name;
        this.category = category;
        this.roomType = roomType;
        this.material = material;
        this.style = style;
        this.brand = brand;
        this.price = price;
        this.storageAvailable = storageAvailable;
    }
}