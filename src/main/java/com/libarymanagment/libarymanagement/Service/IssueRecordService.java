package com.libarymanagment.libarymanagement.Service;

import com.libarymanagment.libarymanagement.Entity.Book;
import com.libarymanagment.libarymanagement.Entity.IssueRecord;
import com.libarymanagment.libarymanagement.Entity.User;
import com.libarymanagment.libarymanagement.Repository.BookRepository;
import com.libarymanagment.libarymanagement.Repository.IssueRecordRepository;
import com.libarymanagment.libarymanagement.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.time.LocalDate;


@Service
public class IssueRecordService {

    @Autowired
    private IssueRecordRepository issueRecordRepository;

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private UserRepository userRepository;

    public IssueRecord returnTheBook(Long bookid) {

    }

    public IssueRecord issueTheBook(Long bookid) {

        Book book = bookRepository.findById(bookid).orElseThrow(() -> new RuntimeException("Book not found"));

        if(book.getQuantity() <= 0  || !book.getIsAvailable()) {
            throw new RuntimeException("Book not available");
        }

        String userName = SecurityContextHolder.getContext().getAuthentication().getName();
        User user = userRepository.findByUserName(userName).orElseThrow(() -> new RuntimeException("User not found"));

        IssueRecord issueRecord = new IssueRecord();
        issueRecord.setBook(book);
        issueRecord.setUser(user);
        issueRecord.setIsReturned(false);
        issueRecord.setIssueDate(LocalDate.now());
        issueRecord.setDueDate(LocalDate.now().plusDays(14));

        book.setQuantity(book.getQuantity() - 1);
        if(book.getQuantity() == 0) {
            book.setIsAvailable(false);
        }

        bookRepository.save(book);
        issueRecordRepository.save(issueRecord);
    }
}
