package com.bookloverbackend.bookloverbackend.repository;

import com.bookloverbackend.bookloverbackend.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book,Integer> {
    Book findByBookId(Integer id);
    Book findByTitle(String title);
}
