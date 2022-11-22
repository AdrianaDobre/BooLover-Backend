package com.bookloverbackend.bookloverbackend.security.service;

import com.bookloverbackend.bookloverbackend.exceptions.EmailUsedAlready;
import com.bookloverbackend.bookloverbackend.model.User;
import com.bookloverbackend.bookloverbackend.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public String registerUser(User user) throws EmailUsedAlready {
        if (userRepository.findByEmail(user.getEmail()) != null)
           throw new EmailUsedAlready("An account already exits with this email!");
        else
        {
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            userRepository.save(user);
            return "The account was created!";
        }
    }
}
