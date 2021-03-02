package com.pip.dao;

import com.pip.entity.Paragraph;
import com.pip.entity.Post;

import java.util.List;

public interface ParagraphDAO {
    public void CreateNewParagraph(Paragraph paragraph);

    public List<Paragraph> getListPost_byPostId(int id);

    public int UpdateParagraph(Paragraph post, int id);
}
