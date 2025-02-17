package com.libarymanagment.libarymanagement.Repository;

import com.libarymanagment.libarymanagement.Entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book,Long> {
}
