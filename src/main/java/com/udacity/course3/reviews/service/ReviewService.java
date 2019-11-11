package com.udacity.course3.reviews.service;

import com.udacity.course3.reviews.entity.Product;
import com.udacity.course3.reviews.entity.Review;
import com.udacity.course3.reviews.repository.ProductRepository;
import com.udacity.course3.reviews.repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewService {

    @Autowired
    private ReviewRepository reviewRepository;

    public List<Review> list(int i) {

        return reviewRepository.findAllByProductId(i);
    }

    public Review findById(int i) {
        return reviewRepository.findById(i).orElseThrow(ReviewNotFoundException::new);
    }

    public Review saveReview(Review review) {
        return reviewRepository.save(review);
    }

}
