package com.pip.service;

import com.pip.entity.Image;
import com.pip.entity.Paragraph;
import com.pip.entity.Post;
import javafx.geometry.Pos;

import java.util.List;

public interface Service {

    public boolean login(String password, String username);

    public void CreateNewPost(Post post, int author_id);

    public int getIdbyUsername(String username);

    public void CreateNewParagraph(Paragraph paragraph);

    public void CreateNewImage(Image image);

    public List<Post> getListPost(int id);

    public void deletePost(int id);

    public List<Post> getPost_byID(int id);

    public List<Paragraph> getListParagraph_byPostId(int id);

    public List<Image> getListPost_byPostId1(int id);

    public void UpdatePost(Post post, int id);

    public void UpdateParagraph(Paragraph paragraph, int id);

    public void UpdateImage(Image image, int id);

    public List<Post> getPosts();

    public List<Post> searchPost(String q);
}
