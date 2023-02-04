package org.example.service;

import jakarta.persistence.Query;
import org.example.structure.Application;
import org.example.structure.ApplicationDetails;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class DatabaseService {
    private final SessionFactory factory = new Configuration()
            .configure("hibernate.cfg.xml")
            .addAnnotatedClass(Application.class)
            .addAnnotatedClass(ApplicationDetails.class)
            .buildSessionFactory();

    public void addApplication(Application application) {
        Session session = factory.openSession();
        Transaction transaction = session.beginTransaction();
        session.persist(application);
        transaction.commit();
        session.close();
    }

    public void addApplicationDetails(ApplicationDetails details, Application application) {
        Session session = factory.openSession();
        Transaction transaction = session.beginTransaction();
        details.setApplication(application);
        session.persist(details);
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

    public ApplicationDetails getApplicationDetailsWithId(int id) {
        Session session = factory.openSession();
        Transaction transaction = session.beginTransaction();
        ApplicationDetails application = session.get(ApplicationDetails.class, id);
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

    public void updateApplicationWithId(int id, Application application) {
        Session session = factory.openSession();
        Transaction transaction = session.beginTransaction();
        Application receiveApplication = session.get(Application.class, id);
        receiveApplication.setDate(application.getDate());
        receiveApplication.setEmail(application.getEmail());
        receiveApplication.setStatus(application.getStatus());
        transaction.commit();
        session.close();
    }

    public void removeApplicationWithId(int id) {
        Session session = factory.openSession();
        Transaction transaction = session.beginTransaction();
        Application application = session.get(Application.class, id);
        session.remove(application);
        transaction.commit();
        session.close();
    }

    public void removeApplication(Application application) {
        Session session = factory.openSession();
        Transaction transaction = session.beginTransaction();
        session.remove(application);
        transaction.commit();
        session.close();
    }

    public void removeApplicationDetailsWithId(int id) {
        Session session = factory.openSession();
        Transaction transaction = session.beginTransaction();
        ApplicationDetails application = session.get(ApplicationDetails.class, id);
        session.remove(application);
        transaction.commit();
        session.close();
    }

    public void removeApplicationDetails(ApplicationDetails application) {
        Session session = factory.openSession();
        Transaction transaction = session.beginTransaction();
        session.remove(application);
        transaction.commit();
        session.close();
    }

    public void closeFactory() {
        factory.close();
    }
}