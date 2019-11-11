/**
 *
 * tests for all the methods in the Spring Data JPA repositories.
 */

package com.udacity.course3.reviews;

import static org.assertj.core.api.Assertions.assertThat;

import com.udacity.course3.reviews.entity.Comment;
import com.udacity.course3.reviews.entity.Product;
import com.udacity.course3.reviews.entity.Review;
import com.udacity.course3.reviews.repository.CommentRepository;
import com.udacity.course3.reviews.repository.ReviewRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.persistence.EntityManager;
import java.util.List;

@RunWith(SpringRunner.class)
@DataJpaTest
public class RepositoryTests {

    @Autowired
    private ReviewRepository reviewRepository;

    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private EntityManager entityManager;

    @Test
    public void injectedComponentsAreNotNull() {
        assertThat(entityManager).isNotNull();
        assertThat(entityManager).isNotNull();
        assertThat(reviewRepository).isNotNull();
        assertThat(commentRepository).isNotNull();
    }

    @Test
    public void findReviewByProductId() {
        //create product
        Product product = new Product();

        //set fields
        product.setProductName("cup");
        product.setProductPrice(3.2);

        //persist product to db
        entityManager.persist(product);

        //create review
        Review review = new Review();

        //set fields
        review.setProductId(product.getProduct_Id());
        review.setReviewerName("Joe");
        review.setReviewerText("Nice cup bro");

        //persist review to db
        entityManager.persist(review);

        //find all reviews using findAllByProductId() method in the review repository
        List<Review> list = reviewRepository.findAllByProductId(product.getProduct_Id());

        //confirm that method returns reviews
        assertThat(list).isNotNull();
    }

    @Test
    public void findCommentByReviewId() {
        //create product
        Product product = new Product();

        //set fields
        product.setProductName("cup");
        product.setProductPrice(3.2);

        //persist product to db
        entityManager.persist(product);

        //create review
        Review review = new Review();

        //set fields
        review.setProductId(product.getProduct_Id());
        review.setReviewerName("Joe");
        review.setReviewerText("Nice cup bro");

        //persist review to db
        entityManager.persist(review);

        //create comment
        Comment comment = new Comment();

        //set fields
        comment.setReviewId(review.getReviewId());
        comment.setCommenterName("Doe");
        comment.setCommentTexts("nice review joe");

        //persist comment to db
        entityManager.persist(comment);

        //find all reviews using findAllByReviewId() method in the comment repository
        List<Comment> list = commentRepository.findAllByReviewId(review.getReviewId());

        //confirm that method returns comments
        assertThat(list).isNotNull();
    }

}
