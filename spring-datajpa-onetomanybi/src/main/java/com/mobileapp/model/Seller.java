package com.mobileapp.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.Set;
@Entity
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Seller {

    @Column(length = 20)
    private String sellerName;

    @Id
    @GeneratedValue(generator = "seller_gen",strategy = GenerationType.AUTO)
    @SequenceGenerator(name = "seller_gen",sequenceName = "seller_seq",allocationSize = 50,initialValue = 1)
    private Integer sellerId;

    @Column(length = 20)
    private String city;
    private double rating;
    @OneToMany(cascade=CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinColumn(name = "seller_id") // seller id will be added as a F.K.
    private Set<Mobile> mobiles;

    public Seller(String sellerName, String city, double rating, Set<Mobile> mobiles) {
        this.sellerName = sellerName;
        this.city = city;
        this.rating = rating;
        this.mobiles = mobiles;
    }
}
