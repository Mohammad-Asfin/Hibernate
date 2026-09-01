package com.hibernate.learning.nativesql;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.NativeQuery;
import java.util.List;

public class NativeSQLExample {
    public static void main(String[] args) {
        
        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();
        
        try {
            // Native SQL
            // We use the exact database table and column names here
            
            System.out.println("\n--- 1. Native SQL: Select All Students ---");
            String sql = "SELECT * FROM students";
            
            // createNativeQuery allows raw SQL to be mapped to our Entity
            NativeQuery<Student> query = session.createNativeQuery(sql, Student.class);
            List<Student> students = query.list();
            
            for (Student s : students) {
                System.out.println(s);
            }
            
            System.out.println("\n--- 2. Native SQL: Complex Queries not easily done in HQL ---");
            // E.g. Using DB specific functions, complex joins, or recursive CTEs
            // String complexSql = "SELECT * FROM students WHERE email LIKE '%@example.com'";
            
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
            factory.close();
        }
    }
}
