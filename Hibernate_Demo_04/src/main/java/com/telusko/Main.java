package com.telusko;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Main {
    public static void main(String[] args) {


//        updating the existing data
//        Alien a1 = new Alien();
//        a1.setAid(102);
//        a1.setAname("Harsh");
//        a1.setTech("Cloud");


//        Alien a1 = new Alien();
//        a1.setAid(104);
//        a1.setAname("Avni");
//        a1.setTech("Databases");


        SessionFactory factory = new Configuration().addAnnotatedClass(com.telusko.Alien.class).configure().buildSessionFactory();
        Session session = factory.openSession();


//        Alien a1 = session.find(Alien.class, 103);
//
//        Alien a1=session.byId(Alien.class).load(103);


//        Lazy Fetching
//        Alien a1 = session.byId(Alien.class).getReference(103);


//       Eager Fetching- firing the select query
//        Alien a1 = session.get(Alien.class, 103);

//        Eager Fetching- find method also uses eager fetching technique
//        Alien a1 = session.find(Alien.class, 103);


        Transaction transaction = session.beginTransaction();

//        updating
//        session.merge(a1);


//        deleting
        Alien a1 = session.find(Alien.class, 104);
        session.remove(a1);


        transaction.commit();

        session.close();
        factory.close();
    }
}
