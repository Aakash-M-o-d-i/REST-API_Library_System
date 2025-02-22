package com.LMS.LibraryManagementSys.repository;

import com.LMS.LibraryManagementSys.Book;
import org.springframework.data.jpa.repository.JpaRepository;
// Database for Book
public interface BookRepository extends JpaRepository<Book, Long> {
}
