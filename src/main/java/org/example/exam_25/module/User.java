package org.example.exam_25.module;


import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id ;
    private String name ;
    private String email ;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "user_document",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "document_id")
    )
    private List<Document> borrowedDocuments = new ArrayList<Document>() ;

    public User() {}

    public User(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    public List<Document> getBorrowedDocuments() { return borrowedDocuments; }
    public void setBorrowedDocuments(List<Document> borrowedDocuments) { this.borrowedDocuments = borrowedDocuments; }

    public void borrowDocument(Document document) {
        borrowedDocuments.add(document);
        document.getBorrowedByUsers().add(this);
    }

    public void returnDocument(Document document) {
        borrowedDocuments.remove(document);
        document.getBorrowedByUsers().remove(this);
    }
}
