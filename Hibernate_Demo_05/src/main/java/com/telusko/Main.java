package com.telusko;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Main {
    public static void main(String[] args) {

        Alien a1 = new Alien();
        a1.setAid(104);
        a1.setAname("Avni");
        a1.setTech("Databases");


        SessionFactory factory = new Configuration().addAnnotatedClass(com.telusko.Alien.class).configure().buildSessionFactory();
        Session session = factory.openSession();


        Transaction transaction = session.beginTransaction();

        session.persist(a1);
        transaction.commit();

        session.close();
        factory.close();
    }
}
