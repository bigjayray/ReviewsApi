package com.udacity.course3.reviews.entityM;

import com.udacity.course3.reviews.entity.Comment;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;
import java.util.ArrayList;
import java.util.List;

@Document("reviews")
public class ReviewM {

    @Id
    private Integer id;

    private int productId;

    private String reviewerName;

    private String reviewerText;

    private List<CommentM> comments = new ArrayList<CommentM>();

    public ReviewM(Integer id, int productId, String reviewerName, String reviewerText) {
        this.id = id;
        this.productId = productId;
        this.reviewerName = reviewerName;
        this.reviewerText = reviewerText;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getReviewerName() {
        return reviewerName;
    }

    public void setReviewerName(String reviewerName) {
        this.reviewerName = reviewerName;
    }

    public String getReviewerText() {
        return reviewerText;
    }

    public void setReviewerText(String reviewerText) {
        this.reviewerText = reviewerText;
    }

    public List<CommentM> getComments() {
        return comments;
    }

    public void setComments(List<CommentM> comments) {
        this.comments = comments;
    }
}
