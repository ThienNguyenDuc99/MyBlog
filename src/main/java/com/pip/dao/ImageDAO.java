package com.pip.dao;

import com.pip.entity.Image;
import com.pip.entity.Paragraph;
import com.pip.entity.Post;

import java.util.List;

public interface ImageDAO {
    public void CreateNewImage(Image image);

    public List<Image> getListPost_byPostId(int id);

    public int UpdateImage(Image image, int id);
}
