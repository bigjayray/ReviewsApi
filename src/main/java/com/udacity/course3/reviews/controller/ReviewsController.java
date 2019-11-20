package com.udacity.course3.reviews.controller;

import com.udacity.course3.reviews.entityM.ReviewM;
import com.udacity.course3.reviews.service.ProductService;
import com.udacity.course3.reviews.serviceM.ReviewServiceM;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

/**
 * Spring REST controller for working with review entity.
 */
@RestController
public class ReviewsController {

    //Wired JPA and Mongodb repositories here
    @Autowired
    private ReviewServiceM reviewServiceM;

    @Autowired
    private ProductService productService;

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
    public ResponseEntity<ReviewM> createReviewForProduct(@PathVariable("productId") Integer productId, @RequestBody ReviewM reviewM) {
        if (productService.findById(productId) != null) {
            ReviewM savedReview = reviewServiceM.saveReviewM(reviewM);

            URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{productId}")
                    .buildAndExpand(savedReview.getId()).toUri();
            return ResponseEntity.created(uri).build();
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
    public ResponseEntity<List<ReviewM>> listReviewsForProduct(@PathVariable("productId") Integer productId) {
        List<ReviewM> list = reviewServiceM.listM(productId);
        return new ResponseEntity<List<ReviewM>>(list, HttpStatus.OK);
    }
}