package com.restaurantapp.model;

import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Restaurant {
    @Id
    @GeneratedValue(generator = "rest_gen",strategy = GenerationType.AUTO)
    @SequenceGenerator(name = "rest_gen",sequenceName = "rest_seq",allocationSize = 1,initialValue = 1)
    private Integer restaurantId;
    @Column(length = 20)
    private String name;
    @Enumerated(EnumType.STRING)
    @Column(length = 20)
    private Type itemType;
    @Column(length = 20)
    private String city;
    private double rating;
    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    //for fetching the data from the item table and show it together with the Restaurant
    @JoinColumn(name = "restaurant_id")
    private Set<Item> items;

    public Restaurant(String name, Type itemType, String city, double rating, Set<Item> items) {
        this.name = name;
        this.itemType = itemType;
        this.city = city;
        this.rating = rating;
        this.items = items;
    }
}
