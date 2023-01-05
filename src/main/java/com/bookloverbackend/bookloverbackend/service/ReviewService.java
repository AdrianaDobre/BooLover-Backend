package com.bookloverbackend.bookloverbackend.service;

import com.bookloverbackend.bookloverbackend.dto.ReviewDTO;
import com.bookloverbackend.bookloverbackend.mapper.ReviewMapper;
import com.bookloverbackend.bookloverbackend.model.Book;
import com.bookloverbackend.bookloverbackend.model.Review;
import com.bookloverbackend.bookloverbackend.model.User;
import com.bookloverbackend.bookloverbackend.repository.BookRepository;
import com.bookloverbackend.bookloverbackend.repository.ReviewRepository;
import com.bookloverbackend.bookloverbackend.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ReviewService {
    private final ReviewRepository reviewRepository;
    private final UserRepository userRepository;
    private final BookRepository bookRepository;

    private final ReviewMapper reviewMapper;

    public Review addReview(ReviewDTO reviewDTO) {
        Review review = new Review();
        review.setReviewDate(LocalDateTime.now());
        review.setComment(reviewDTO.getComment());
        review.setReviewRating(reviewDTO.getReviewRating());
        review.setUserId(userRepository.findByEmail(reviewDTO.getEmail()).getUserId());
        review.setBookId(bookRepository.findByTitle(reviewDTO.getTitle()).getBookId());
        return reviewRepository.save(review);
    }

    public void deleteReview(ReviewDTO reviewDTO) {
        Book book = bookRepository.findByTitle(reviewDTO.getTitle());
        User user = userRepository.findByEmail(reviewDTO.getEmail());
        Review reviewFound = reviewRepository.findAllByUserId(user.getUserId()).stream()
                .filter(review -> ((Objects.equals(review.getBookId(), book.getBookId()))
                        && (Objects.equals(review.getComment(), reviewDTO.getComment()))
                        && (Objects.equals(review.getReviewRating(), reviewDTO.getReviewRating())))).findFirst().get();
        reviewRepository.delete(reviewFound);
    }

    public List<ReviewDTO> getReviewsByBook(String title, String emailUser) {
        Book book = bookRepository.findByTitle(title);
        return reviewRepository.findAllByBookId(book.getBookId()).stream()
                .map(review -> {
                    return reviewMapper.toReviewDTO(userRepository.findById(review.getUserId()).get(), bookRepository.findById(review.getBookId()).get(), review, emailUser);
                }).collect(Collectors.toList());
    }

    public List<ReviewDTO> getReviewsByEmail(String email) {
        User user = userRepository.findByEmail(email);
        return reviewRepository.findAllByUserId(user.getUserId()).stream()
                .map(review -> {
                    return reviewMapper.toReviewDTO(userRepository.findById(review.getUserId()).get(), bookRepository.findById(review.getBookId()).get(), review, email);
                }).collect(Collectors.toList());
    }
}
