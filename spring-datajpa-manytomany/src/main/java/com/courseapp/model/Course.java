package com.courseapp.model;

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
public class Course {

    @Id
    @GeneratedValue(generator = "course_gen",strategy = GenerationType.AUTO)
    @SequenceGenerator(name = "course_gen",sequenceName = "course_seq",allocationSize = 10,initialValue = 100)
    @ToString.Exclude
    private Integer courseId;

    @Column(length = 40)
    private String courseName;

    private int durationInDays;

    private double fees;

    private String category;

    @ToString.Exclude
    @ManyToMany(cascade=CascadeType.MERGE,fetch = FetchType.EAGER)
    @JoinTable( name = "course_trainer",
            joinColumns =  {
                    @JoinColumn(name = "course_id") // refers to the P.K. of the owner entity
            },
            inverseJoinColumns = {
                    @JoinColumn(name = "trainer_id") // refers to the P.K. of the child entity
            }
    )
    private Set<Trainer> trainers;

    public Course(String courseName, int durationInDays, double fees, String category) {
        this.courseName = courseName;
        this.durationInDays = durationInDays;
        this.fees = fees;
        this.category = category;
    }
}
