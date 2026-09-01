package com.hibernate.learning.crud;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ReadExample {
    public static void main(String[] args) {
        
        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();
        
        try {
            // Concept: READ / SELECT
            // We use get() or find() to retrieve the object by its Primary Key
            
            Long studentId = 1L; // Assuming ID 1 exists
            
            // Hibernate generated SQL approx:
            // SELECT * FROM students WHERE id = ?
            Student student = session.get(Student.class, studentId);
            
            if (student != null) {
                System.out.println("Student found: " + student);
            } else {
                System.out.println("Student with ID " + studentId + " not found!");
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
            factory.close();
        }
    }
}
