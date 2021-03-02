package com.pip.dao;

import com.pip.entity.Post;

import java.util.List;

public interface PostDAO {

    public void CreateNewPost(Post post, int author_id);

    public int getLastId();

    public List<Post> getListPost(int id);

    public void deletePost(int id);

    public List<Post> getPost_byID(int id);

    public int UpdatePost(Post post, int id);
}
