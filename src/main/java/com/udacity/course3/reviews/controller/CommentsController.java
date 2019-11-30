package com.udacity.course3.reviews.controller;

import com.udacity.course3.reviews.entity.Comment;
import com.udacity.course3.reviews.entityM.CommentM;
import com.udacity.course3.reviews.entityM.ReviewM;
import com.udacity.course3.reviews.repository.CommentRepository;
import com.udacity.course3.reviews.repository.ReviewRepository;
import com.udacity.course3.reviews.repositoryM.CommentRepositoryM;
import com.udacity.course3.reviews.repositoryM.ReviewRepositoryM;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpServerErrorException;

import javax.validation.Valid;
import java.util.List;

/**
 * Spring REST controller for working with comment entity.
 */
@RestController
@RequestMapping("/comments")
public class CommentsController {

    // wire Mongodb repositories here
    @Autowired
    CommentRepositoryM commentRepositoryM;

    @Autowired
    CommentRepository commentRepository;

    @Autowired
    ReviewRepositoryM reviewRepositoryM;

    @Autowired
    ReviewRepository reviewRepository;

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
    public ResponseEntity<?> createCommentForReview(@PathVariable("reviewId") Integer reviewId, @Valid @RequestBody Comment comment) {
        if (reviewRepository.findById(reviewId).isPresent()) {
            commentRepository.save(comment);

            ReviewM reviewM = null;
            if (reviewRepositoryM.findById(reviewId).isPresent()) {
                reviewM = reviewRepositoryM.findById(reviewId).get();
                List<CommentM> comments = reviewM.getComments();
                CommentM commentM = new CommentM(comment.getCommentId(), comment.getCommenterName(), comment.getCommentTexts(), comment.getReviewId());
                comments.add(commentM);
                reviewM.setComments(comments);
            }

            return new ResponseEntity<ReviewM>(reviewRepositoryM.save(reviewM), HttpStatus.OK);
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
    public List<?> listCommentsForReview(@PathVariable("reviewId") Integer reviewId) {
        if (reviewRepository.findById(reviewId).isPresent()) {
            return commentRepository.findAllByReviewId(reviewId);
        }
        throw new HttpServerErrorException(HttpStatus.NOT_FOUND);
    }
}