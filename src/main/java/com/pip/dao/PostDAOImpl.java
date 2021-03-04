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

public class PostDAOImpl implements PostDAO {

    SessionFactory factory;

    public PostDAOImpl() {
        this.factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Author.class)
                .addAnnotatedClass(Post.class)
                .addAnnotatedClass(Paragraph.class)
                .addAnnotatedClass(Image.class)
                .buildSessionFactory();
    }

    @Override
    public void CreateNewPost(Post post, int author_id) {
        Session session = factory.getCurrentSession();

        session.beginTransaction();
        Author author = session.get(Author.class, author_id);
        author.add(post);

        session.save(post);
        session.getTransaction().commit();
    }

    /**
     * Get last id in post
     * @param
     * @return
     */
    @Override
    public int getLastId(){
        Session session = factory.getCurrentSession();
        session.beginTransaction();
        String hql = "Select max(id) FROM Post";
        Query query = session.createQuery(hql);
        List<Post> a = query.getResultList();
        Object a1 = a.get(0);
        int a2 = a1.hashCode();
        session.getTransaction().commit();
        return a2;
    }

    /**
     * Get post by author_id
     * @param id
     * @return
     */
    @Override
    public List<Post> getListPost(int id) {
        Session session = factory.getCurrentSession();
        session.beginTransaction();
        String hql = "FROM Post E WHERE E.author = '" + id + "'";
        Query query = session.createQuery(hql);
        List<Post> post = query.getResultList();
        session.getTransaction().commit();
        return post;
    }

    /**
     * Get post by id
     * @param id
     * @return
     */
    @Override
    public List<Post> getPost_byID(int id) {
        Session session = factory.getCurrentSession();
        session.beginTransaction();
        String hql = "FROM Post E WHERE E.id = '" + id + "'";
        Query query = session.createQuery(hql);
        List<Post> post = query.getResultList();
        session.getTransaction().commit();
        return post;
    }

    @Override
    public int UpdatePost(Post post, int id) {
        Session session = factory.getCurrentSession();
        session.getTransaction().begin();
        String hql = "UPDATE Post SET title = :title, subject = :subject WHERE id = :id";
        Query query = session.createQuery(hql);
        query.setParameter("title", post.getTitle());
        query.setParameter("subject", post.getSubject());
        query.setParameter("id", id);;
        int result = query.executeUpdate();
        session.getTransaction().commit();
        return result;
    }

    @Override
    public List<Post> getPosts() {
        Session session = factory.getCurrentSession();
        session.beginTransaction();
        String hql = "FROM Post";
        Query query = session.createQuery(hql);
        List<Post> post = query.getResultList();
        session.getTransaction().commit();
        return post;
    }

    @Override
    public List<Post> searchPost(String q) {
        Session session = factory.getCurrentSession();
        session.beginTransaction();
        String hql = "FROM Post E WHERE E.title LIKE  '%" +q+ "%'";
        Query query = session.createQuery(hql);
        List<Post> post = query.getResultList();
        session.getTransaction().commit();
        return post;
    }


    @Override
    public void deletePost(int id) {
        Session session = factory.getCurrentSession();
        session.beginTransaction();
        Post temp = session.get(Post.class, id);
        if (temp != null) {
            session.delete(temp);
        }
        session.getTransaction().commit();
    }

}
