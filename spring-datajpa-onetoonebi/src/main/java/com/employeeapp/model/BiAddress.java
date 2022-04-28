package com.employeeapp.model;

import lombok.*;

import javax.persistence.*;


@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "Biaddress")
public class BiAddress {
    @Id
    @GeneratedValue(generator = "biadd_gen",strategy = GenerationType.AUTO)
    @SequenceGenerator(name = "biadd_gen",sequenceName = "add_seq",initialValue = 10,allocationSize = 10)
    private Integer addressId;
    @Column(length = 20)
    private String city;

    @Column(length = 20)
    private String state;

    private long zipcode;
    @Column(length = 20)
    private String flatNumber;

    @Column(length = 20)
    private String streetname;

    //mappedBy is used to tell which class is the owner of this relationship
    //in our case it is employee which has biAddress property
    //biAddress property is mappedBy
    @OneToOne(mappedBy = "biAddress")
    private Employee employee;

    public BiAddress( String city, String state, long zipcode, String flatNumber, String streetname) {
        this.city = city;
        this.state = state;
        this.zipcode = zipcode;
        this.flatNumber = flatNumber;
        this.streetname = streetname;
    }

    @Override
    public String toString() {
        return "BiAddress{" +
                "addressId=" + addressId +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", zipcode=" + zipcode +
                ", flatNumber='" + flatNumber + '\'' +
                ", streetname='" + streetname + '\'' +
                '}';
    }
}
