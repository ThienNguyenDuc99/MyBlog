package com.pip.dao;

import com.pip.entity.Author;

import java.util.List;

public interface AuthorDAO {
    public List<Author> adminlogin(String username);

    public int getIdbyUsername(String username);

}
