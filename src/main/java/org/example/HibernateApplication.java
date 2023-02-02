package org.example;

import org.example.service.DatabaseService;
import org.example.structure.Application;

import java.time.LocalDateTime;

public class HibernateApplication {
    public static void main(String[] args) {
        System.out.println("__DATABASE_PROGRAM__");
        DatabaseService service = new DatabaseService();
        System.out.println("DELETE apl with have id 10");
        service.removeApplicationWithId(13);

        service.closeFactory();
    }
}