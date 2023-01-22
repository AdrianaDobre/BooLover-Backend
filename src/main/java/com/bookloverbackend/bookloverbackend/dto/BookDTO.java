package com.bookloverbackend.bookloverbackend.dto;

import com.bookloverbackend.bookloverbackend.model.Book;
import com.bookloverbackend.bookloverbackend.model.Review;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.text.DecimalFormat;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookDTO {
    private String title;

    private String author;

    private String category;

    private String description;

    private Double averageRating;

    public BookDTO(Book book, List<ReviewDTO> reviews){
        this.title = book.getTitle();
        this.author = book.getAuthor();
        this.category = book.getCategory();
        this.description = book.getDescription();
        DecimalFormat df = new DecimalFormat("#.#");
        this.averageRating = Double.valueOf(df.format(reviews.stream().mapToDouble(ReviewDTO::getReviewRating).average().orElse(0)));
        System.out.println(this.averageRating);
    }
}

