package org.example.service;

import jakarta.persistence.Query;
import org.example.structure.Application;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class DatabaseService {
    private final SessionFactory factory = new Configuration()
            .configure("hibernate.cfg.xml")
            .addAnnotatedClass(Application.class)
            .buildSessionFactory();

    public void addApplication(Application application) {
        Session session = factory.openSession();
        Transaction transaction = session.beginTransaction();
        session.persist(application);
        transaction.commit();
        session.close();
    }

    public Application getApplicationWithId(int id) {
        Session session = factory.openSession();
        Transaction transaction = session.beginTransaction();
        Application application = session.get(Application.class, id);
        transaction.commit();
        session.close();
        return application;
    }

    public Application getApplicationWithEmail(String email) {
        Session session = factory.openSession();
        Transaction transaction = session.beginTransaction();
        Query query = session.createQuery("from Application u where u.email=:email");
        query.setParameter("email", email);
        Application application = (Application) query.setMaxResults(1).getSingleResult();
        transaction.commit();
        session.close();
        return application;
    }

    public void removeApplicationWithId(int id) {
        Session session = factory.openSession();
        Transaction transaction = session.beginTransaction();

        transaction.commit();
        session.close();
    }

    public void closeFactory() {
        factory.close();
    }
}