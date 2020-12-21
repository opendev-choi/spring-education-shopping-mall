package com.choijh.route;

import com.choijh.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/review")
public class ReviewRoute {
    private final ReviewService reviewService;

    @Autowired
    public ReviewRoute(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @GetMapping("/initialize")
    public void initializeReviews(){
        this.reviewService.initializeReviews();
    }
}
