package com.restaurantapp.model;

import lombok.*;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Item {
    @Id
    @GeneratedValue(generator = "item_gen",strategy = GenerationType.AUTO)
    @SequenceGenerator(name = "item_gen",sequenceName = "item_seq",initialValue = 10,allocationSize = 10)
    private Integer itemId;
    @Column(length = 20)
    private String name;
    @Column(length = 20)
    @Enumerated(EnumType.STRING)
    private Category category;//starter,maincourse,dessert,beverages
    @Enumerated(EnumType.STRING)
    @Column(length = 20)
    private Type itemType;
    @Column(length = 20)
    @Enumerated(EnumType.STRING)
    private Cuisine cuisine; //SI, NI, CHINESE, ITALIAN
    private double price;

    public Item(String name, Category category, Type itemType, Cuisine cuisine, double price) {
        this.name = name;
        this.category = category;
        this.itemType = itemType;
        this.cuisine = cuisine;
        this.price = price;
    }
}
