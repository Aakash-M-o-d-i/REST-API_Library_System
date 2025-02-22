package com.LMS.LibraryManagementSys.service;

import com.LMS.LibraryManagementSys.Book;
import com.LMS.LibraryManagementSys.User;
import com.LMS.LibraryManagementSys.repository.BookRepository;
import com.LMS.LibraryManagementSys.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;

public class BookService {
    @Autowired
    private BookRepository bookRepo;
    @Autowired
    private UserRepository userRepo;
    // This will display all book
    public List<Book> findAll(){
        return bookRepo.findAll();
    }

    // this will display the book by their id
    public Book findById(Long id){
        return bookRepo.findById(id).orElse(null);
    }

    // allows you to save a given entity to the database
    public Book save(Book book){
        return bookRepo.save(book);
    }
    // this will delete the entity to the database
    public void deleteById(Long id){
        bookRepo.deleteById(id);
    }

    // this method do -> borrow the book using bookID and userID
    public Book borrowBook(Long bookId, Long userId){
        Book book = findById(bookId); // this will not use bookRepo, since the return type of Book
        User user = userRepo.findById(userId).orElse(null);
        
        if(book != null && !book.isBorrowed() && user != null){
            book.setBorrowedBy(user);
            book.setBorrowed(true);
            return save(book);
        }
        return null;
    }

    // this method do -> return the book in bookID
    public Book returnBook(Long bookId){
        Book book = findById(bookId);
        if (book != null && book.isBorrowed()){
            book.setBorrowedBy(null);
            book.setBorrowed(false);
            return save(book);
        }
        return null;
    }


}
