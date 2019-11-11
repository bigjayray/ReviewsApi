package com.udacity.course3.reviews.entity;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "comments")
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "comment_id")
    private int commentId;

    @Column(name = "commenter_name")
    private String commenterName;

    @Column(name = "comment_text")
    private String commentTexts;

    @Column(name = "comment_time")
    private Timestamp commentTime;

    @Column(name = "review_id")
    private int reviewId;

    public Comment() {}

    public Integer getCommentId() {
        return commentId;
    }

    public void setCommentId(Integer commentId) {
        this.commentId = commentId;
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

    public Timestamp getCommentTime() {
        return commentTime;
    }

    public void setCommentTime(Timestamp commentTime) {
        this.commentTime = commentTime;
    }

    public Integer getReviewId() {
        return reviewId;
    }

    public void setReviewId(Integer reviewId) {
        this.reviewId = reviewId;
    }
}
