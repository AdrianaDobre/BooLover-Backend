package com.bookloverbackend.bookloverbackend.controller;

import com.bookloverbackend.bookloverbackend.dto.ReviewDTO;
import com.bookloverbackend.bookloverbackend.model.Review;
import com.bookloverbackend.bookloverbackend.service.ReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("review")
public class ReviewController {
    private final ReviewService reviewService;

    @PostMapping("/addReview")
    public Review addReview(@RequestBody ReviewDTO reviewDTO, Principal principal){
        reviewDTO.setEmail(principal.getName());
        return reviewService.addReview(reviewDTO);
    }

    @DeleteMapping("/deleteReview")
    public void deleteReview(@RequestBody ReviewDTO reviewDTO){
        reviewService.deleteReview(reviewDTO);
    }

    @GetMapping("/getAllByBook")
    public List<ReviewDTO> getReviewsByBook(@RequestParam String title, Principal principal){
        return reviewService.getReviewsByBook(title, principal.getName());
    }

    @GetMapping("/getAllByEmail")
    public List<ReviewDTO> getReviewsByEmail(Principal principal){
        return reviewService.getReviewsByEmail(principal.getName());
    }
}
