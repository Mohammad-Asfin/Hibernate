package com.hibernate.learning.onetoone;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class OneToOneExample {
    public static void main(String[] args) {
        
        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();
        Transaction transaction = session.beginTransaction();
        
        try {
            // 1. Create the entities
            Student student = new Student("Elena Gilbert");
            StudentProfile profile = new StudentProfile("Human/Vampire/Doppelgänger", "linkedin.com/in/elena-gilbert");
            
            // 2. Associate them
            // Because Student is the Owning Side (it has the @JoinColumn),
            // we MUST set the profile on the student object for the FK to be saved.
            student.setProfile(profile);
            
            // 3. Save the Student
            // Note: Because we used CascadeType.ALL on the @OneToOne mapping,
            // persisting the student will AUTOMATICALLY persist the profile first!
            session.persist(student);
            
            transaction.commit();
            System.out.println("Saved successfully: " + student);
            
            // 4. Read to verify
            Session readSession = factory.openSession();
            Student fetched = readSession.get(Student.class, student.getId());
            System.out.println("Fetched from DB: " + fetched);
            readSession.close();
            
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        } finally {
            session.close();
            factory.close();
        }
    }
}
