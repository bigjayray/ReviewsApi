package com.udacity.course3.reviews.service;

import com.udacity.course3.reviews.entity.Comment;
import com.udacity.course3.reviews.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService {

    @Autowired
    private CommentRepository commentRepository;

    public List<Comment> list(int i) {

        return commentRepository.findAllByReviewId(i);
    }

    public Comment saveComment(Comment comment) {
        return commentRepository.save(comment);
    }

}
