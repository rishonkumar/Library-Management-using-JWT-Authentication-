package com.libarymanagment.libarymanagement.DTO;

import lombok.Data;

@Data
public class BookDTO {

    private Long id;
    private String title;
    private  String author;
    private String isbn;
    private Integer quantity;
    private Boolean isAvailable;
}
