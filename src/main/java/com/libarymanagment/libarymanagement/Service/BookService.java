package com.libarymanagment.libarymanagement.Service;

import com.libarymanagment.libarymanagement.DTO.BookDTO;
import com.libarymanagment.libarymanagement.Entity.Book;
import com.libarymanagment.libarymanagement.Repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
    @Autowired
    private BookRepository bookRepository;

    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    public Book getBookById(Long id) {
        Book book = bookRepository.findById(id).orElseThrow(() -> new RuntimeException("Book not found"));
        return book;
    }

    public Book addBook(BookDTO bookDTO) {
        Book book = new Book();
        book.setTitle(bookDTO.getTitle());
        book.setAuthor(bookDTO.getAuthor());
        book.setIsbn(bookDTO.getIsbn());
        book.setQuantity(bookDTO.getQuantity());
        book.setIsAvailable(bookDTO.getIsAvailable());

        return bookRepository.save(book);
    }

    public Book updateBook(BookDTO bookDTO, Long id) {
        Book udpatedBook = bookRepository.findById(id).orElseThrow(() -> new RuntimeException("Book not found"));
        udpatedBook.setTitle(bookDTO.getTitle());
        udpatedBook.setAuthor(bookDTO.getAuthor());
        udpatedBook.setIsbn(bookDTO.getIsbn());
        udpatedBook.setQuantity(bookDTO.getQuantity());
        udpatedBook.setIsAvailable(bookDTO.getIsAvailable());

        return bookRepository.save(udpatedBook);
    }

    public void deleteBook(Long id) {
        if (!bookRepository.existsById(id)) {
            throw new RuntimeException("Book not found");
        }
        bookRepository.deleteById(id);
    }
}
