package com.hibernate.learning.postgresql;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Main {
    public static void main(String[] args) {
        System.out.println("Starting Hibernate PostgreSQL Setup...");
        try {
            Configuration config = new Configuration().configure();
            SessionFactory factory = config.buildSessionFactory();
            System.out.println("Hibernate SessionFactory for PostgreSQL created successfully!");
            factory.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
