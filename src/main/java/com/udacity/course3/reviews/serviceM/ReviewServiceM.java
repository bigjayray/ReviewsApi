package com.udacity.course3.reviews.serviceM;

import com.udacity.course3.reviews.entityM.ReviewM;
import com.udacity.course3.reviews.repositoryM.ReviewRepositoryM;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReviewServiceM {
    @Autowired
    private ReviewRepositoryM reviewRepositoryM;

    public List<ReviewM> listM(int i) {

        return reviewRepositoryM.findReviewMByProductId(i);
    }

    public Optional<ReviewM> findByIdM(String s) {
        return reviewRepositoryM.findById(s);
    }

    public ReviewM saveReviewM(ReviewM reviewM) {
        return reviewRepositoryM.save(reviewM);
    }
}
