package com.htec.microservicecourses.models.entity;

import com.htec.commonsstudents.models.entity.Student;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "courses")
public class Course {

    public Course(){
        this.students= new ArrayList<>();
    }

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToMany(fetch = FetchType.LAZY)
    private List<Student> students;

    @Column(name="created_at")
    private Date createdAt;

    public void addStudent(Student student) {
        this.students.add(student);
    }

    public void removeStudent(Student student) {
        this.students.remove(student);
    }

    @PrePersist
    public void prePersist() {
        this.createdAt = new Date();
    }
}
