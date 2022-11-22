package com.bookloverbackend.bookloverbackend.service;

import com.bookloverbackend.bookloverbackend.model.Book;
import com.bookloverbackend.bookloverbackend.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookService {
    private final BookRepository bookRepository;

    public Book addBook(Book book){
        return bookRepository.save(book);
    }

    public Book findBookById(Integer bookId){
        return bookRepository.findByBookId(bookId);
    }

    public List<Book> getAllBooks(){
        return bookRepository.findAll();
    }
}
