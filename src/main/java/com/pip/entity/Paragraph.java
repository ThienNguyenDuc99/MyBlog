package com.pip.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "paragraph")
public class Paragraph {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name = "content")
    private String content;

    @Column(name = "indexx")
    private int indexx;

    @ManyToOne(fetch = FetchType.EAGER, targetEntity = Post.class, cascade= {CascadeType.ALL})
    @JoinColumn(name = "post_id")
    private Post post;

    public Paragraph() {

    }

    public Paragraph(String content, int index) {
        this.content = content;
        this.indexx = index;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getIndex() {
        return indexx;
    }

    public void setIndex(int index) {
        this.indexx = index;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }
}
