package com.hibernate.learning.onetoone;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "students")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    // OWNING SIDE: The 'students' table will contain a Foreign Key column 'profile_id'
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "profile_id")
    private StudentProfile profile;

    public Student() {}
    public Student(String name) { this.name = name; }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public StudentProfile getProfile() { return profile; }
    public void setProfile(StudentProfile profile) { this.profile = profile; }
    
    @Override
    public String toString() {
        return "Student{" + "id=" + id + ", name='" + name + '\'' + ", profile=" + profile + '}';
    }
}
