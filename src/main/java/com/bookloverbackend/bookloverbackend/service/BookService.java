package com.bookloverbackend.bookloverbackend.service;

import com.bookloverbackend.bookloverbackend.dto.BookDTO;
import com.bookloverbackend.bookloverbackend.mapper.BookMapper;
import com.bookloverbackend.bookloverbackend.model.Book;
import com.bookloverbackend.bookloverbackend.model.Review;
import com.bookloverbackend.bookloverbackend.model.User;
import com.bookloverbackend.bookloverbackend.repository.BookRepository;
import com.bookloverbackend.bookloverbackend.repository.ReviewRepository;
import com.bookloverbackend.bookloverbackend.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BookService {
    private final BookRepository bookRepository;
    private final ReviewRepository reviewRepository;
    private final UserRepository userRepository;

    private final ReviewService reviewService;
    private final BookMapper bookMapper;

    public Book addBook(Book book){
        return bookRepository.save(book);
    }

    public Book findBookById(Integer bookId){
        return bookRepository.findByBookId(bookId);
    }

    public List<BookDTO> getAllBooks(){
        return bookRepository.findAll().stream()
                .map(book -> {
                    return bookMapper.toBookDTO(book,reviewService.getReviewsByBook(book.getTitle()));
                })
                .collect(Collectors.toList());
    }

    public List<BookDTO> getAllReviewedByEmail(String email){
        User user = userRepository.findByEmail(email);
        List<Book> books = reviewRepository.findAllByUserId(user.getUserId()).stream()
                .map(Review::getBookId).distinct().toList().stream()
                .map(bookRepository::findByBookId).toList();
        return books.stream()
                .map(book -> {
                    return bookMapper.toBookDTO(book,reviewService.getReviewsByBook(book.getTitle()));
                }).collect(Collectors.toList());
    }
}
