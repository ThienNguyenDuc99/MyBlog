package com.pip.dao;

import com.pip.entity.Author;
import com.pip.entity.Image;
import com.pip.entity.Paragraph;
import com.pip.entity.Post;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class AuthorDAOImpl implements AuthorDAO{

    SessionFactory factory;

    public AuthorDAOImpl() {
         this.factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Author.class)
                 .addAnnotatedClass(Post.class)
                 .addAnnotatedClass(Paragraph.class)
                 .addAnnotatedClass(Image.class)
                .buildSessionFactory();
    }

    // create session

    @Override
    public List<Author> adminlogin(String username) {

        Session session = factory.getCurrentSession();

        session.beginTransaction();
        String hql = "FROM Author E WHERE E.username = '" + username + "'";
        Query query = session.createQuery(hql);

       /* Query<Author> theQuery =
                session.createQuery("from Author where username = '" ++"'" ,
                        Author.class);*/
        List<Author> results = query.getResultList();
        session.getTransaction().commit();

        return results;
    }

    @Override
    public int getIdbyUsername(String username) {
        Session session = factory.getCurrentSession();
        session.beginTransaction();
        String hql = "Select id FROM Author WHERE username = '" + username + "'";
        Query query = session.createQuery(hql);
        List<Author> a = query.getResultList();
        Object a1 = a.get(0);
        int a2 = a1.hashCode();
        return a2;
    }
}
