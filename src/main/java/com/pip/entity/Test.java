package com.pip.entity;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.List;

public class Test {

    public static void main(String[] args) {

        // create session factory
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Author.class)
                .addAnnotatedClass(Post.class)
                .buildSessionFactory();

        // create session
        Session session = factory.getCurrentSession();

        try {
            // create a student object
            // create a teacher object
            session.beginTransaction();

            Author author = session.get(Author.class, 1);
            System.out.println("Info of teacher: " + author.toString());
            System.out.println("Saved teacher. Generated id: " + author.getId());

            session.getTransaction().commit();
        }
        finally {
            factory.close();
        }
    }

}

