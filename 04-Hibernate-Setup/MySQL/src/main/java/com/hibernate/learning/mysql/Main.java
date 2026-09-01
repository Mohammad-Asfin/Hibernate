package com.hibernate.learning.mysql;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Main {
    public static void main(String[] args) {
        System.out.println("Starting Hibernate MySQL Setup...");
        try {
            // By default, configure() looks for hibernate.cfg.xml in the classpath
            Configuration config = new Configuration().configure();
            SessionFactory factory = config.buildSessionFactory();
            
            System.out.println("Hibernate SessionFactory for MySQL created successfully!");
            
            // Always close the factory when the application stops
            factory.close();
        } catch (Exception e) {
            System.err.println("Failed to create SessionFactory for MySQL.");
            e.printStackTrace();
        }
    }
}
