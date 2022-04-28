package com.productapp.model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "newproduct")
@NamedQuery(name = "findByBrandExpiry",query = "from Product p where p.brand=?1 and p.expiryDate<=?2")
@NamedQueries(value = {
        @NamedQuery(name = "findByCatBrand", query="from Product p where p.brand=?1 and p.category=?2"),
        @NamedQuery(name = "findByBrandName", query="from Product p where p.brand=?1 and p.name=?2")
})
public class Product {
    @Column(length = 20)
    private String name;
    @Id
    @GeneratedValue(generator = "product_gen",strategy = GenerationType.AUTO)
    @SequenceGenerator(name = "product_gen",sequenceName = "product_sequence",initialValue = 100,allocationSize = 1)
    private Integer productId;
    @Column(name = "cost")
    private double price;
    @Column(length = 20)
    //this will store enum as String
//    @Enumerated(EnumType.STRING)
    private Category category;
    private String brand;
    private LocalDate expiryDate;

    public Product(String name, double price, Category category, String brand, LocalDate expiryDate) {
        this.name = name;
        this.price = price;
        this.category = category;
        this.brand = brand;
        this.expiryDate = expiryDate;
    }
}
