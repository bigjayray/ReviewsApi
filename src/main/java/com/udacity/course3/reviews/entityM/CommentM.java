package com.udacity.course3.reviews.entityM;

import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;

@Document("comments")
public class CommentM {

    @Id
    private int id;

    private String commenterName;

    private String commentTexts;

    private Integer reviewId;

    public CommentM(int id, String commenterName, String commentTexts, Integer reviewId) {
        this.id = id;
        this.commenterName = commenterName;
        this.commentTexts = commentTexts;
        this.reviewId = reviewId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCommenterName() {
        return commenterName;
    }

    public void setCommenterName(String commenterName) {
        this.commenterName = commenterName;
    }

    public String getCommentTexts() {
        return commentTexts;
    }

    public void setCommentTexts(String commentTexts) {
        this.commentTexts = commentTexts;
    }

    public Integer getReviewId() {
        return reviewId;
    }

    public void setReviewId(Integer reviewId) {
        this.reviewId = reviewId;
    }
}
