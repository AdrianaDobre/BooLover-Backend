package com.bookloverbackend.bookloverbackend.repository;

import com.bookloverbackend.bookloverbackend.model.Review;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository extends JpaRepository<Review,Integer> {
}
