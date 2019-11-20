package com.udacity.course3.reviews.controller;

import com.udacity.course3.reviews.entityM.CommentM;
import com.udacity.course3.reviews.serviceM.CommentServiceM;
import com.udacity.course3.reviews.serviceM.ReviewServiceM;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

/**
 * Spring REST controller for working with comment entity.
 */
@RestController
@RequestMapping("/comments")
public class CommentsController {

    // wire Mongodb repositories here

    @Autowired
    CommentServiceM commentServiceM;

    @Autowired
    ReviewServiceM reviewServiceM;

    /**
     * Creates a comment for a review.
     *
     * 1. Check for existence of review.
     * 2. If review not found, return NOT_FOUND.
     * 3. If found, save comment.
     *
     * @param reviewId The id of the review.
     */
    @RequestMapping(value = "/reviews/{reviewId}", method = RequestMethod.POST)
    public ResponseEntity<?> createCommentForReview(@PathVariable("reviewId") String reviewId, @Valid @RequestBody CommentM commentM) {
        if (reviewServiceM.findByIdM(reviewId).isPresent()) {
            CommentM savedComment = commentServiceM.saveCommentM(commentM);

            URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{reviewId}")
                    .buildAndExpand(savedComment.getId()).toUri();
            return ResponseEntity.created(uri).build();
        }

        throw new HttpServerErrorException(HttpStatus.NOT_FOUND);
    }

    /**
     * List comments for a review.
     *
     * 1. Check for existence of review.
     * 2. If review not found, return NOT_FOUND.
     * 3. If found, return list of comments.
     *
     * @param reviewId The id of the review.
     */
    @RequestMapping(value = "/reviews/{reviewId}", method = RequestMethod.GET)
    public List<CommentM> listCommentsForReview(@PathVariable("reviewId") String reviewId) {
        if (reviewServiceM.findByIdM(reviewId).isPresent()) {
            return commentServiceM.listM(reviewId);
        }
        throw new HttpServerErrorException(HttpStatus.NOT_FOUND);
    }
}