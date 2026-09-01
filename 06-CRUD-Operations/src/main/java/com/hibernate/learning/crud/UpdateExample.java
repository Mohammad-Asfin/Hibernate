package com.hibernate.learning.crud;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class UpdateExample {
    public static void main(String[] args) {
        
        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();
        Transaction transaction = session.beginTransaction();
        
        try {
            // Concept: UPDATE
            // 1. Fetch the entity
            // 2. Modify properties via setters
            // 3. Hibernate automatically detects changes (Dirty Checking) or use merge()
            
            Long studentId = 1L;
            Student student = session.get(Student.class, studentId);
            
            if (student != null) {
                // Modifying the object
                student.setAge(23); // Elena turned 23
                
                // session.merge() ensures the object is updated in the context if detached
                // but since it's already persistent here, dirty checking handles it upon commit.
                session.merge(student);
                
                // Hibernate generated SQL approx:
                // UPDATE students SET age=?, email=?, name=? WHERE id=?
                transaction.commit();
                System.out.println("Student updated successfully!");
            } else {
                System.out.println("Student not found.");
            }
            
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        } finally {
            session.close();
            factory.close();
        }
    }
}
