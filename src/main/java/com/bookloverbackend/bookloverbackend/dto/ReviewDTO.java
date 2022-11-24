package com.bookloverbackend.bookloverbackend.dto;

import com.bookloverbackend.bookloverbackend.model.Book;
import com.bookloverbackend.bookloverbackend.model.Review;
import com.bookloverbackend.bookloverbackend.model.User;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReviewDTO {
    private LocalDateTime reviewDate;
    private String comment;
    private Float reviewRating;
    private String email;
    private String title;

    public ReviewDTO(User user, Book book, Review review){
        this.reviewDate = review.getReviewDate();
        this.comment = review.getComment();
        this.reviewRating = review.getReviewRating();
        this.email = user.getEmail();
        this.title = book.getTitle();
    }
}
