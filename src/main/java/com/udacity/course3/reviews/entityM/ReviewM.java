package com.udacity.course3.reviews.entityM;

import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;

@Document("reviews")
public class ReviewM {

    @Id
    private String id;

    private int productId;

    private String reviewerName;

    private String reviewerText;

    public ReviewM(String id, int productId, String reviewerName, String reviewerText) {
        this.id = id;
        this.productId = productId;
        this.reviewerName = reviewerName;
        this.reviewerText = reviewerText;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
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
}
