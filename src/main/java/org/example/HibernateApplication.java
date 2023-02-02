package org.example;

import org.example.service.DatabaseService;
import org.example.structure.Application;

import java.time.LocalDateTime;

public class HibernateApplication {
    public static void main(String[] args) {
        System.out.println("__DATABASE_PROGRAM__");
        DatabaseService service = new DatabaseService();
        Application testApplication = new Application("testApplication", "testemail1@test.com", LocalDateTime.now());
        service.addApplication(testApplication);
        Application application2 = service.getApplicationWithId(13);
        Application application1 = service.getApplicationWithEmail("testemail1@test.com");
        System.out.println(application1);
        System.out.println(application2);
        service.closeFactory();
    }
}