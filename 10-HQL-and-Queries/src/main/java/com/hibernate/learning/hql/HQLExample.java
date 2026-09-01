package com.hibernate.learning.hql;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import java.util.List;

public class HQLExample {
    public static void main(String[] args) {
        
        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();
        
        try {
            // HQL: Hibernate Query Language
            // Notice we use the Class Name "Student" and Property Names (age), NOT table names!
            
            System.out.println("\n--- 1. Select All Students ---");
            Query<Student> query1 = session.createQuery("FROM Student", Student.class);
            List<Student> students = query1.list();
            for (Student s : students) {
                System.out.println(s);
            }
            
            System.out.println("\n--- 2. Select Students with age > 22 ---");
            Query<Student> query2 = session.createQuery("FROM Student WHERE age > 22", Student.class);
            List<Student> olderStudents = query2.list();
            for (Student s : olderStudents) {
                System.out.println(s);
            }
            
            System.out.println("\n--- 3. Select only Names ---");
            Query<String> query3 = session.createQuery("SELECT s.name FROM Student s", String.class);
            List<String> names = query3.list();
            for (String name : names) {
                System.out.println(name);
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
            factory.close();
        }
    }
}
