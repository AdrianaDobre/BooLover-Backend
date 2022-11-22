package com.bookloverbackend.bookloverbackend.repository;

import com.bookloverbackend.bookloverbackend.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Integer> {
    User findByEmail(String email);
}
