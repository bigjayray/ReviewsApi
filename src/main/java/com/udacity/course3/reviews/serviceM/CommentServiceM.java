package com.udacity.course3.reviews.serviceM;

import com.udacity.course3.reviews.entityM.CommentM;
import com.udacity.course3.reviews.repositoryM.CommentRepositoryM;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentServiceM {
    @Autowired
    private CommentRepositoryM commentRepositoryM;

    public List<CommentM> listM(String s) {

        return commentRepositoryM.findCommentMByReviewMId(s);
    }

    public CommentM saveCommentM(CommentM commentM) {
        return commentRepositoryM.save(commentM);
    }
}
