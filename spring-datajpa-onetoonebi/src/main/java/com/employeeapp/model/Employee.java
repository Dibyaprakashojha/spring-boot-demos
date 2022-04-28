package com.employeeapp.model;

import lombok.*;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Employee {
    @Id
    @GeneratedValue(generator = "emp_gen",strategy = GenerationType.AUTO)
    @SequenceGenerator(name = "emp_gen",sequenceName = "emp_seq",initialValue = 1,allocationSize = 1)
    private Integer employeeId;
    @Column(length = 20)
    private String name;
    @Column(length = 20)
    private String department;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id") //give different column name
    private BiAddress biAddress;

    public Employee(String name, String department, BiAddress biAddress) {
        this.name = name;
        this.department = department;
        this.biAddress = biAddress;
    }
}
