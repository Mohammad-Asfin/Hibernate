package com.hibernate.learning.entity;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Main {
    public static void main(String[] args) {
        
        System.out.println("Starting Entity Mapping Example...");

        // Concept: 
        // We have defined a Student class with @Entity and @Id annotations.
        // Let's verify that Hibernate can read this mapping and connect to the database.

        try {
            Configuration config = new Configuration().configure();
            SessionFactory factory = config.buildSessionFactory();
            
            System.out.println("Entity Mapping loaded successfully!");
            System.out.println("Check your database (if hbm2ddl.auto=update), the 'students' table should be created.");
            
            factory.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
