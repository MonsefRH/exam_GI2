package org.example.exam_25.dao;

import org.example.exam_25.module.Document;
import org.example.exam_25.module.User;

import java.util.List;

public interface InterfaceDAo {
    List<Document> getAvailableDocuments();
    List<Document> getBorrowedDocumentsByUser(int userId);
    void borrowDocument(int userId, int documentId);
    void returnDocument(int userId, int documentId);
    User findUserById(int id);
    Document findDocumentById(int id);
}
