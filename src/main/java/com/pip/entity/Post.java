package com.pip.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "post")
public class Post {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name = "title")
    private String title;

    @Column(name = "subject")
    private String subject;

    @Column(name = "date")
    private Date date;

    @ManyToOne(fetch = FetchType.EAGER, targetEntity = Author.class, cascade= {CascadeType.PERSIST, CascadeType.MERGE,
            CascadeType.DETACH, CascadeType.REFRESH})
    @JoinColumn(name = "author_id")
    private Author author;

    @OneToMany(mappedBy="post", targetEntity = Paragraph.class, cascade= {CascadeType.ALL})
    private List<Paragraph> paragraphs;

    @OneToMany(mappedBy="post", targetEntity = Image.class, cascade= {CascadeType.ALL})
    private List<Image> images;

    public Post(String title, String subject, Date date) {
        this.title = title;
        this.subject = subject;
        this.date = date;
    }

    public Post() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubject() {
        return subject;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    /**
     * get associated with Department
     */
    public Author getAuthor() {
        return author;
    }

    /**
     * set associated with Department
     */
    public void setAuthor(Author a) {
        this.author = a;
    }

    public List<Paragraph> getParagraphs() {
        return paragraphs;
    }

    public void setParagraphs(List<Paragraph> paragraphs) {
        this.paragraphs = paragraphs;
    }

    public List<Image> getImages() {
        return images;
    }

    public void setImages(List<Image> images) {
        this.images = images;
    }

    public void add(Paragraph temp) {
        if (paragraphs == null) {
            paragraphs = new ArrayList<>();
        }

        paragraphs.add(temp);

        temp.setPost(this);
    }



    public void addImage(Image temp) {

        if (paragraphs == null) {
            paragraphs = new ArrayList<>();
        }

        images.add(temp);

        temp.setPost(this);
    }
}
