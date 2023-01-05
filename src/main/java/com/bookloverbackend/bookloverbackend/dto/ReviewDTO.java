package com.bookloverbackend.bookloverbackend.dto;

import com.bookloverbackend.bookloverbackend.model.Book;
import com.bookloverbackend.bookloverbackend.model.Review;
import com.bookloverbackend.bookloverbackend.model.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Objects;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReviewDTO{
    private LocalDateTime reviewDate;
    private String comment;
    private Float reviewRating;
    private String email;
    private String title;
    private boolean belongsToUser;

    public ReviewDTO(User user, Book book, Review review, String emailUser){
        this.reviewDate = review.getReviewDate();
        this.comment = review.getComment();
        this.reviewRating = review.getReviewRating();
        this.email = user.getEmail();
        this.title = book.getTitle();
        this.belongsToUser = Objects.equals(user.getEmail(), emailUser);
    }

}
