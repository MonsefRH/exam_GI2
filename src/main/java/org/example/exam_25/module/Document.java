package org.example.exam_25.module;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Document {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String title;
    private Date dateCreat;
    @ManyToMany(mappedBy = "profs")
    private List<User> borrowedByUsers = new ArrayList<>();


    public Document() {}
    public Document(String title, Date dateCreat) {
        this.title = title;
        this.dateCreat = dateCreat;
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
    public Date getDateCreat() {
        return dateCreat;
    }
    public void setDateCreat(Date dateCreat) {
        this.dateCreat = dateCreat;
    }
    public List<User> getBorrowedByUsers() { return borrowedByUsers; }
    public void setBorrowedByUsers(List<User> borrowedByUsers) { this.borrowedByUsers = borrowedByUsers; }

    public boolean isAvailable() {
        return borrowedByUsers.isEmpty();
    }

}
