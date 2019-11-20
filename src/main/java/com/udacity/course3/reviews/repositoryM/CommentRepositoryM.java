package com.udacity.course3.reviews.repositoryM;

import com.udacity.course3.reviews.entityM.CommentM;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepositoryM extends MongoRepository<CommentM, String> {

    @Query("{ 'reviewId' : ?0 }")
    List<CommentM> findCommentMByReviewMId(String id);
}
