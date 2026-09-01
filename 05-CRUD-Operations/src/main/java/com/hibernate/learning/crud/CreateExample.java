package com.hibernate.learning.crud;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class CreateExample {
    public static void main(String[] args) {
        
        // 1. Setup SessionFactory
        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        
        // 2. Open Session
        Session session = factory.openSession();
        
        // 3. Begin Transaction
        Transaction transaction = session.beginTransaction();
        
        try {
            // Concept: CREATE / INSERT
            // Java Object ↓ session.persist() ↓ Hibernate ↓ Generated SQL INSERT ↓ MySQL Database
            
            Student student = new Student("Elena Gilbert", "elena@example.com", 22);
            
            // Hibernate generated SQL approx:
            // INSERT INTO students (age, email, name) VALUES (?, ?, ?)
            session.persist(student);
            
            // 4. Commit transaction
            transaction.commit();
            System.out.println("Student saved successfully!");
            
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        } finally {
            session.close();
            factory.close();
        }
    }
}
