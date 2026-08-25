package com.telusko;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Main {
    public static void main(String[] args) {
        Alien a1 = new Alien();
//        a1.setAid(101);
//        a1.setAname("Navin");
//        a1.setTech("Java");

        a1.setAid(102);
        a1.setAname("Harsh");
        a1.setTech("Spring");
//        hey hibernate save with a1 object

        Configuration config = new Configuration();
        config.addAnnotatedClass(com.telusko.Alien.class);
        config.configure();
        SessionFactory factory = config.buildSessionFactory();
        Session session = factory.openSession();


        Transaction transaction = session.beginTransaction();
        session.persist(a1);
        transaction.commit();
        session.close();
        factory.close();
    }
}
