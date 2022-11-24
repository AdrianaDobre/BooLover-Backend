package com.bookloverbackend.bookloverbackend.repository;

import com.bookloverbackend.bookloverbackend.model.Review;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReviewRepository extends JpaRepository<Review,Integer> {
    Review findByBookId(Integer reviewId);
    List<Review> findAllByUserId(Integer userId);
    List<Review> findAllByBookId(Integer bookId);
}
