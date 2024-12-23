package com.nautiDevelopers.Todo.Entity;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Data
@Entity //Declaring it is an Entity Table.
public class Todo {

    // Define Field
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String username;

    private String description;
    private boolean done;
    private LocalDate deadline;

    //Creating Constructors

    public Todo() {

    }

    public Todo(String username, String description, LocalDate targetDate, boolean done) {
        super();
        this.username = username;
        this.description = description;
        this.deadline = targetDate;
        this.done = done;
    }
}
