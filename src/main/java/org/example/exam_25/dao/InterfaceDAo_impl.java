package org.example.exam_25.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.example.exam_25.module.Document;
import org.example.exam_25.module.User;
import java.util.List;

public class InterfaceDAo_impl implements InterfaceDAo {
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("Mypresistence");
    private EntityManager em;
    public InterfaceDAo_impl() {
        em = emf.createEntityManager();
    }

    @Override
    public List<Document> getAvailableDocuments() {
        return em.createQuery(
                "SELECT d FROM Document d WHERE SIZE(d.borrowedByUsers) = 0",
                Document.class
        ).getResultList();
    }

    @Override
    public List<Document> getBorrowedDocumentsByUser(int userId) {
        return em.createQuery(
                        "SELECT d FROM Document d JOIN d.borrowedByUsers u WHERE u.id = :userId",
                        Document.class
                ).setParameter("userId", userId)
                .getResultList();
    }

    @Override
    public void borrowDocument(int userId, int documentId) {
        em.getTransaction().begin();
        User user = findUserById(userId);
        Document document = findDocumentById(documentId);
        if (user != null && document != null && document.isAvailable()) {
            user.borrowDocument(document);
            em.merge(user);
        }
        em.getTransaction().commit();
    }

    @Override
    public void returnDocument(int userId, int documentId) {
        em.getTransaction().begin();
        User user = findUserById(userId);
        Document document = findDocumentById(documentId);
        if (user != null && document != null && !document.isAvailable()) {
            user.returnDocument(document);
            em.merge(user);
        }
        em.getTransaction().commit();
    }

    @Override
    public User findUserById(int id) {
        return em.find(User.class, id);
    }

    @Override
    public Document findDocumentById(int id) {
        return em.find(Document.class, id);
    }
}