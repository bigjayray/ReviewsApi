package com.udacity.course3.reviews.controller;

import com.udacity.course3.reviews.entity.Review;
import com.udacity.course3.reviews.entityM.ReviewM;
import com.udacity.course3.reviews.repository.ProductRepository;
import com.udacity.course3.reviews.repository.ReviewRepository;
import com.udacity.course3.reviews.repositoryM.ReviewRepositoryM;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpServerErrorException;

import java.net.URI;
import java.util.List;

/**
 * Spring REST controller for working with review entity.
 */
@RestController
public class ReviewsController {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ReviewRepository reviewRepository;

    @Autowired
    private ReviewRepositoryM reviewRepositoryM;


    /**
     * Creates a review for a product.
     * <p>
     *
     * 1. Check for existence of product.
     * 2. If product not found, return NOT_FOUND.
     * 3. If found, save review.
     *
     */
    @RequestMapping(value = "/reviews/products/{productId}", method = RequestMethod.POST)
    public ResponseEntity<?> createReviewForProduct(@PathVariable("productId") Integer productId, @RequestBody Review review) {
        if (productRepository.findById(productId).isPresent()) {
            reviewRepository.save(review);
            ReviewM reviewM = new ReviewM(review.getReviewId(),review.getProductId(),review.getReviewerName(), review.getReviewerText());

            return new ResponseEntity<ReviewM>(reviewRepositoryM.save(reviewM), HttpStatus.OK);
        }
        throw new HttpServerErrorException(HttpStatus.NOT_FOUND);
    }

    /**
     * Lists reviews by product.
     *
     * @param productId The id of the product.
     * @return The list of reviews.
     */
    @RequestMapping(value = "/reviews/products/{productId}", method = RequestMethod.GET)
    public ResponseEntity<List<?>> listReviewsForProduct(@PathVariable("productId") Integer productId) {
        if (productRepository.findById(productId).isPresent()) {
            List<?> reviewIds = reviewRepository.findReviewIdsByProductId(productId);

            List<?> list = reviewRepositoryM.findReviewMByProductId(productId);

            return new ResponseEntity<List<?>>(list, HttpStatus.OK);
        }
        throw new HttpServerErrorException(HttpStatus.NOT_FOUND);
    }
}