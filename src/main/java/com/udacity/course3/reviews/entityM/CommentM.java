package com.udacity.course3.reviews.entityM;

import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;

@Document("comments")
public class CommentM {

    @Id
    private String id;

    private String commenterName;

    private String commentTexts;

    private String reviewId;

    public CommentM(String id, String commenterName, String commentTexts, String reviewId) {
        this.id = id;
        this.commenterName = commenterName;
        this.commentTexts = commentTexts;
        this.reviewId = reviewId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
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

    public String getReviewId() {
        return reviewId;
    }

    public void setReviewId(String reviewId) {
        this.reviewId = reviewId;
    }
}
