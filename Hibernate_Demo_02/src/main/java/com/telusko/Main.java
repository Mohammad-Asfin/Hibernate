package com.telusko;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Main {
    public static void main(String[] args) {
        Alien a1 = new Alien();
        a1.setAid(101);
        a1.setAname("Navin");
        a1.setTech("Java");

//        hey hibernate save with a1 object

        Configuration config = new Configuration();
        config.configure();
        SessionFactory factory = config.buildSessionFactory();
        Session session = factory.openSession();
        session.persist(a1);

    }
}
