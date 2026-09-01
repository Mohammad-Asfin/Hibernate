package com.hibernate.learning.onetoone;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "student_profiles")
public class StudentProfile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String bio;
    private String linkedInUrl;

    public StudentProfile() {}

    public StudentProfile(String bio, String linkedInUrl) {
        this.bio = bio;
        this.linkedInUrl = linkedInUrl;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getBio() { return bio; }
    public void setBio(String bio) { this.bio = bio; }
    public String getLinkedInUrl() { return linkedInUrl; }
    public void setLinkedInUrl(String linkedInUrl) { this.linkedInUrl = linkedInUrl; }
    
    @Override
    public String toString() {
        return "StudentProfile{" + "id=" + id + ", bio='" + bio + '\'' + ", linkedInUrl='" + linkedInUrl + '\'' + '}';
    }
}
