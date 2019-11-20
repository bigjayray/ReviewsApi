package com.udacity.course3.reviews.repositoryM;

import com.udacity.course3.reviews.entityM.ReviewM;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReviewRepositoryM extends MongoRepository<ReviewM, String> {

    @Query("{ 'productId' : ?0 }")
    List<ReviewM> findReviewMByProductId(int id);
}
