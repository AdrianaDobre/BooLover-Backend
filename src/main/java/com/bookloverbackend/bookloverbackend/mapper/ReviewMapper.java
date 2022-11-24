package com.bookloverbackend.bookloverbackend.mapper;

import com.bookloverbackend.bookloverbackend.dto.ReviewDTO;
import com.bookloverbackend.bookloverbackend.model.Book;
import com.bookloverbackend.bookloverbackend.model.Review;
import com.bookloverbackend.bookloverbackend.model.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ReviewMapper {
    ReviewDTO toReviewDTO(User user, Book book, Review review);
}
