package org.example;

import org.example.service.DatabaseService;
import org.example.structure.Application;

import java.time.LocalDateTime;

public class HibernateApplication {
    public static void main(String[] args) {
        System.out.println("__DATABASE_PROGRAM__");
        DatabaseService service = new DatabaseService();



        service.closeFactory();
    }
}