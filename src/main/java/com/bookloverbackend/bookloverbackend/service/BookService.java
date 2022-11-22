package com.bookloverbackend.bookloverbackend.service;

import com.bookloverbackend.bookloverbackend.dto.BookDTO;
import com.bookloverbackend.bookloverbackend.mapper.BookMapper;
import com.bookloverbackend.bookloverbackend.model.Book;
import com.bookloverbackend.bookloverbackend.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BookService {
    private final BookRepository bookRepository;
    private final BookMapper bookMapper;

    public Book addBook(Book book){
        return bookRepository.save(book);
    }

    public Book findBookById(Integer bookId){
        return bookRepository.findByBookId(bookId);
    }

    public List<BookDTO> getAllBooks(){
        return bookRepository.findAll().stream()
                .map(bookMapper::toBookDTO)
                .collect(Collectors.toList());
    }
}
