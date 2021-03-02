package com.pip.dao;

import com.pip.entity.Author;
import com.pip.entity.Image;
import com.pip.entity.Paragraph;
import com.pip.entity.Post;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.List;

public class ImageDAOImpl implements ImageDAO{

    SessionFactory factory;

    public ImageDAOImpl() {
        this.factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Author.class)
                .addAnnotatedClass(Post.class)
                .addAnnotatedClass(Paragraph.class)
                .addAnnotatedClass(Image.class)
                .buildSessionFactory();
    }

    @Override
    public void CreateNewImage(Image image) {
        Session session = factory.getCurrentSession();
        session.beginTransaction();

        PostDAOImpl postDAO = new PostDAOImpl();
        // Get last id in post
        int lastId = postDAO.getLastId();
        // Get object of last id
        Post post = session.get(Post.class, lastId);
        // Make associated between post and paragraph
        post.addImage(image);
        // Save paragraph object to DB
        session.save(image);

        session.getTransaction().commit();
    }

    /**
     * Get paragraph by id
     * @param id
     * @return
     */
    @Override
    public List<Image> getListPost_byPostId(int id) {
        Session session = factory.getCurrentSession();
        session.beginTransaction();
        String hql = "FROM Image E WHERE E.post = '" + id + "'";
        Query query = session.createQuery(hql);
        List<Image> images = query.getResultList();
        session.getTransaction().commit();
        return images;
    }

    @Override
    public int UpdateImage(Image image, int id) {
        Session session = factory.getCurrentSession();
        session.getTransaction().begin();
        String hql = "UPDATE Image SET content = :content, indexx = :indexx WHERE id = :id";
        Query query = session.createQuery(hql);
        query.setParameter("content", image.getContent());
        query.setParameter("indexx", image.getIndex());
        query.setParameter("id", id);;
        int result = query.executeUpdate();
        session.getTransaction().commit();
        return result;
    }
}
