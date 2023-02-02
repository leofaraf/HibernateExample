package org.example.structure;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDateTime;

@NoArgsConstructor
@Data
@ToString
@Entity
@Table(name="application")
public class Application {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "status")
    private String status;

    @Column(name = "email")
    private String email;

    @Column(name = "date")
    private LocalDateTime date;

    public Application(String status, String email, LocalDateTime date) {
        this.status = status;
        this.email = email;
        this.date = date;
    }
}
