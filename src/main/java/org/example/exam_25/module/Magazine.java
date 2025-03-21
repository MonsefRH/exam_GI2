package org.example.exam_25.module;


import java.util.Date;

public class Magazine extends Document{

    private String publisher;
    private String issuerNumber;
    private Date dateIssue;

    public Magazine() {
        super();
    }
    public Magazine(String publisher, String issuerNumber, Date dateIssue) {
        super();
        this.publisher = publisher;
        this.issuerNumber = issuerNumber;
        this.dateIssue = dateIssue;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getIssuerNumber() {
        return issuerNumber;
    }

    public void setIssuerNumber(String issuerNumber) {
        this.issuerNumber = issuerNumber;
    }

    public Date getDateIssue() {
        return dateIssue;
    }

    public void setDateIssue(Date dateIssue) {
        this.dateIssue = dateIssue;
    }
}
