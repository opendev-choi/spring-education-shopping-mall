package com.choijh.service;

import com.choijh.repository.ProductRepository;
import com.choijh.repository.ReviewRepository;
import com.choijh.repository.SaleRepository;
import com.choijh.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class InitializeService {
    private final ProductRepository productRepository;
    private final ReviewRepository reviewRepository;
    private final SaleRepository saleRepository;
    private final UserRepository userRepository;

    @Autowired
    public InitializeService(ProductRepository productRepository,
                             ReviewRepository reviewRepository,
                             SaleRepository saleRepository,
                             UserRepository userRepository) {
        this.productRepository = productRepository;
        this.reviewRepository = reviewRepository;
        this.saleRepository = saleRepository;
        this.userRepository = userRepository;
    }

    public void initialize() {

    }
}
