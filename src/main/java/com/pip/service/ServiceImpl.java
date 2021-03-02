package com.pip.service;

import java.util.List;

import com.pip.dao.*;
import com.pip.entity.Author;
import com.pip.entity.Image;
import com.pip.entity.Paragraph;
import com.pip.entity.Post;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ServiceImpl implements com.pip.service.Service {

    @Override
    public boolean login(String password, String username) {
        AuthorDAO author = new AuthorDAOImpl();
        List<Author> listAuthor = author.adminlogin(username);
        if(listAuthor.size()==1){
            Author a = listAuthor.get(0);
            if(password.equals(a.getPassword())) return true;
        }
        return false;
    }

    @Override
    public void CreateNewPost(Post post, int author_id) {
        PostDAOImpl postDAO = new PostDAOImpl();
        postDAO.CreateNewPost(post, author_id);
    }

    @Override
    public int getIdbyUsername(String username) {
        AuthorDAO author = new AuthorDAOImpl();
        return author.getIdbyUsername(username);
    }

    @Override
    public void CreateNewParagraph(Paragraph paragraph) {
        ParagraphDAOImpl paragraphDAO = new ParagraphDAOImpl();
        paragraphDAO.CreateNewParagraph(paragraph);
    }

    @Override
    public void CreateNewImage(Image image) {
        ImageDAOImpl imageDAO = new ImageDAOImpl();
        imageDAO.CreateNewImage(image);
    }

    @Override
    public List<Post> getListPost(int id) {
        PostDAOImpl postDAO = new PostDAOImpl();
        List<Post> posts = postDAO.getListPost(id);
        return posts;
    }

    @Override
    public void deletePost(int id) {
        PostDAOImpl postDAO = new PostDAOImpl();
        postDAO.deletePost(id);
    }

    @Override
    public List<Post> getPost_byID(int id) {
        PostDAOImpl postDAO = new PostDAOImpl();
        return postDAO.getPost_byID(id);
    }

    @Override
    public List<Paragraph> getListPost_byPostId(int id) {
        ParagraphDAOImpl paragraphDAO = new ParagraphDAOImpl();
        return paragraphDAO.getListPost_byPostId(id);
    }

    @Override
    public List<Image> getListPost_byPostId1(int id) {
        ImageDAOImpl imageDAO = new ImageDAOImpl();
        return imageDAO.getListPost_byPostId(id);
    }

    @Override
    public void UpdatePost(Post post, int id) {
        PostDAOImpl postDAO = new PostDAOImpl();
        postDAO.UpdatePost(post, id);
    }

    @Override
    public void UpdateParagraph(Paragraph paragraph, int id) {
        ParagraphDAOImpl paragraphDAO = new ParagraphDAOImpl();
        paragraphDAO.UpdateParagraph(paragraph, id);
    }

    @Override
    public void UpdateImage(Image image, int id) {
        ImageDAOImpl imageDAO = new ImageDAOImpl();
        imageDAO.UpdateImage(image, id);
    }


}
