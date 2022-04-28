package com.courseapp.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@Entity
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Trainer {
    @Id
    @GeneratedValue(generator = "trainer_gen",strategy = GenerationType.AUTO)
    @SequenceGenerator(name = "trainer_gen",sequenceName = "trainer_seq",allocationSize = 1,initialValue = 1)
    @ToString.Exclude
    private Integer trainerId;

    @Column(length = 40)
    private String trainerName;

    private double ratings;

    private int experience;

    @Column(length = 40)
    private String techStack;

//    @Temporal(TemporalType.DATE)
//    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate joiningDate;

    @ToString.Exclude
    @ManyToMany(mappedBy = "trainers" // mappedBy uses the instance variable name
            ,fetch = FetchType.EAGER)
    private Set<Course> courses;

    public Trainer(String trainerName, double ratings, int experience, String techStack, LocalDate joiningDate) {
        this.trainerName = trainerName;
        this.ratings = ratings;
        this.experience = experience;
        this.techStack = techStack;
        this.joiningDate = joiningDate;
    }
}
