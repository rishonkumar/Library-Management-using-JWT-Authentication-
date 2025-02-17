package com.libarymanagment.libarymanagement.Entity;


import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "book")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private  String author;
    private String isbn;
    private Integer quantity;
    private Boolean isAvailable;

}
