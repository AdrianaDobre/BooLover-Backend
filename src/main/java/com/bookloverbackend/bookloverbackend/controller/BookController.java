package com.bookloverbackend.bookloverbackend.controller;

import com.bookloverbackend.bookloverbackend.dto.BookDTO;
import com.bookloverbackend.bookloverbackend.model.Book;
import com.bookloverbackend.bookloverbackend.model.Review;
import com.bookloverbackend.bookloverbackend.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("book")
public class BookController {
    private final BookService bookService;

    @PostMapping("/addBook")
    public Book addBook(@RequestBody Book book){
        return bookService.addBook(book);
    }

    @GetMapping("/getBookById/{bookId}")
    public Book getBookById(@PathVariable Integer bookId){
        return bookService.findBookById(bookId);
    }

    @GetMapping("/getAllBooks")
    public List<BookDTO> getAllBooks(Principal principal){
        return bookService.getAllBooks(principal.getName());
    }

    @GetMapping("/getAllReviewedByEmail")
    public List<BookDTO> getAllReviewedByEmail(Principal principal){
        return bookService.getAllReviewedByEmail(principal.getName());
    }

    @GetMapping("/getBookByTitle")
    public BookDTO getBookByTitle(@RequestParam String title, Principal principal){
        return bookService.getBookByTitle(title, principal.getName());
    }
}
