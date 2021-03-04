package com.pip.dao;

import com.pip.entity.Author;
import com.pip.entity.Image;
import com.pip.entity.Paragraph;
import com.pip.entity.Post;
import javafx.geometry.Pos;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.List;

public class ParagraphDAOImpl implements ParagraphDAO{

    SessionFactory factory;

    public ParagraphDAOImpl() {
        this.factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Author.class)
                .addAnnotatedClass(Post.class)
                .addAnnotatedClass(Paragraph.class)
                .addAnnotatedClass(Image.class)
                .buildSessionFactory();
    }

    @Override
    public void CreateNewParagraph(Paragraph paragraph) {
        Session session = factory.getCurrentSession();
        session.beginTransaction();

        PostDAOImpl postDAO = new PostDAOImpl();
        // Get last id in post
        int lastId = postDAO.getLastId();
        // Get object of last id
        Post post = session.get(Post.class, lastId);
        // Make associated between post and paragraph
        post.add(paragraph);
        // Save paragraph object to DB
        session.save(paragraph);

        session.getTransaction().commit();
    }

    /**
     * Get paragraph by id
     * @param id
     * @return
     */
    @Override
    public List<Paragraph> getListParagraph_byPostId(int id) {
        Session session = factory.getCurrentSession();
        session.beginTransaction();
        String hql = "FROM Paragraph E WHERE E.post = '" + id + "' order by indexx";
        Query query = session.createQuery(hql);
        List<Paragraph> paragraphs = query.getResultList();
        session.getTransaction().commit();
        return paragraphs;
    }

    @Override
    public int UpdateParagraph(Paragraph post, int id) {
        Session session = factory.getCurrentSession();
        session.getTransaction().begin();
        String hql = "UPDATE Paragraph SET content = :content, indexx = :indexx WHERE id = :id";
        Query query = session.createQuery(hql);
        query.setParameter("content", post.getContent());
        query.setParameter("indexx", post.getIndex());
        query.setParameter("id", id);;
        int result = query.executeUpdate();
        session.getTransaction().commit();
        return result;
    }

}
