package com.mobileapp.model;

import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Mobile { // One OLX Seller selling many mobiles
    @Id
    @GeneratedValue(generator = "mobile_gen",strategy = GenerationType.AUTO)
    @SequenceGenerator(name = "mobile_gen",sequenceName = "mobile_seq",allocationSize = 100,initialValue = 1)
    private Integer mobileId;

    @Column(length = 20)
    private String model;

    @Column(length = 20)
    private String brand;

    private double price;

    @Enumerated(EnumType.STRING)
    @Column(length = 20)
    private Processor processor; //snapdragon,A15Bionic,Mediatek

    @Column(length = 40)
    private String memory; //2gb,4gb,6gb,8gb,12gb

    @Column(length = 20)
    private String storage; //32gb,64gb,128b,256gb

    @Column(length = 40)
    private String cameraType; //front, rear

    @Column(length = 20)
    private String operatingSystem; //Android,ios,windows

//    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
//    @JoinColumn(name = "feature_id")
//    private Set<Features> features;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "seller_id")
    private Seller sellers;

    public Mobile(String model, String brand, double price, Processor processor, String memory, String storage, String cameraType, String operatingSystem) {
        this.model = model;
        this.brand = brand;
        this.price = price;
        this.processor = processor;
        this.memory = memory;
        this.storage = storage;
        this.cameraType = cameraType;
        this.operatingSystem = operatingSystem;
    }

    @Override
    public String toString() {
        return "Mobile{" +
                "model='" + model + '\'' +
                ", brand='" + brand + '\'' +
                ", price=" + price +
                ", processor='" + processor + '\'' +
                ", memory='" + memory + '\'' +
                ", storage='" + storage + '\'' +
                ", cameraType=" + cameraType +
                ", operatingSystem='" + operatingSystem + '\'' +
                '}';
    }
}
