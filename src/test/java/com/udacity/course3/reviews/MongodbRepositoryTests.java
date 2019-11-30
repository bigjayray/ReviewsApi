package com.udacity.course3.reviews;

import com.udacity.course3.reviews.entityM.CommentM;
import com.udacity.course3.reviews.entityM.ReviewM;
import com.udacity.course3.reviews.repositoryM.CommentRepositoryM;
import com.udacity.course3.reviews.repositoryM.ReviewRepositoryM;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataMongoTest
public class MongodbRepositoryTests {
    @Autowired
    ReviewRepositoryM reviewRepositoryM;

    @Autowired
    CommentRepositoryM commentRepositoryM;

    @Autowired
    MongoTemplate mongoTemplate;

    @Before
    public void init(){
        //creating review object
        ReviewM reviewM = new ReviewM(1, 1, "Joey", "Nice product");
        //saving reviewM to db
        mongoTemplate.save(reviewM, "reviews");

        //creating comment object
        CommentM commentM = new CommentM(1,"john", "nice review joey", 1);
        //saving reviewM to db
        mongoTemplate.save(commentM, "comments");
    }


    @Test
    public void findReviewMByProductId() {
        //find all reviews using findReviewMByProductId() method in the reviewM repository
        List<ReviewM> list = reviewRepositoryM.findReviewMByProductId(1);
        assertThat(list).isNotNull();
    }

    @Test
    public void findCommentMByReviewMId() {
        //find all comments using findCommentMByReviewMId() method in the commentM repository
        List<CommentM> list = commentRepositoryM.findCommentMByReviewMId(1);
        assertThat(list).isNotNull();
    }
}
