package com.hibernate.learning.crud;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class DeleteExample {
    public static void main(String[] args) {
        
        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();
        Transaction transaction = session.beginTransaction();
        
        try {
            // Concept: DELETE
            
            Long studentId = 1L;
            Student student = session.get(Student.class, studentId);
            
            if (student != null) {
                // Hibernate generated SQL approx:
                // DELETE FROM students WHERE id=?
                session.remove(student);
                
                transaction.commit();
                System.out.println("Student deleted successfully!");
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
