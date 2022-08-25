package com.example.ManytoMany.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name="student_tbl")
public class Student {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    private String name;
    private int age;
    private String dept;

    @JsonIgnore
    @ManyToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinTable(name="student_course_tbl",
            joinColumns={
                    @JoinColumn
                    (name="student_id", referencedColumnName ="id")},
            inverseJoinColumns={
                    @JoinColumn
                    (name="course_id",referencedColumnName = "id")})
    private Set< Course> course;
}
