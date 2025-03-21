package org.example.exam_25.module;



import jakarta.persistence.Entity;

import java.util.Date;

@Entity
public class Book extends Document{

    private String author;

    private String isbn;
    private Date datePublishion;

    public Book() {
        super();
    }
    public Book(String isbn, Date datePublishion ,String author) {
        super();
        this.author = author;
        this.isbn = isbn;
        this.datePublishion = datePublishion;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public Date getDatePublishion() {
        return datePublishion;
    }

    public void setDatePublishion(Date datePublishion) {
        this.datePublishion = datePublishion;
    }
}
