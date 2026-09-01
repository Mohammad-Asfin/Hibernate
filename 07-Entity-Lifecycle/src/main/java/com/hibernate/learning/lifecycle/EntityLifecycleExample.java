package com.hibernate.learning.lifecycle;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class EntityLifecycleExample {
    public static void main(String[] args) {
        
        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();
        Transaction transaction = session.beginTransaction();
        
        try {
            // 1. TRANSIENT State
            // The object exists in memory but has NO connection to Hibernate or the database.
            // It has no ID yet.
            Student student = new Student("Alaric Saltzman", 40);
            System.out.println("State: TRANSIENT");
            
            // 2. PERSISTENT (MANAGED) State
            // By passing it to persist(), it is now managed by the Hibernate Session.
            // Any changes made to it now will be tracked by Dirty Checking.
            session.persist(student);
            System.out.println("State: PERSISTENT (ID generated: " + student.getId() + ")");
            
            student.setAge(41); // Hibernate automatically updates this upon commit!
            
            transaction.commit(); // Translates tracked changes into SQL and flushes them to the DB.
            
            // 3. DETACHED State
            // We close the session. The object 'student' still exists in Java memory,
            // but Hibernate is no longer tracking it.
            session.close();
            System.out.println("State: DETACHED (Session closed)");
            
            student.setAge(42); // This change will NOT be saved to the database.
            
            // 4. REMOVED State
            // Let's open a new session to demonstrate removal.
            Session newSession = factory.openSession();
            Transaction newTransaction = newSession.beginTransaction();
            
            // Fetch it back into the persistent state
            Student managedStudent = newSession.get(Student.class, student.getId());
            
            // Now mark it for removal
            newSession.remove(managedStudent);
            System.out.println("State: REMOVED (Scheduled for deletion on commit)");
            
            newTransaction.commit();
            newSession.close();
            
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            factory.close();
        }
    }
}
