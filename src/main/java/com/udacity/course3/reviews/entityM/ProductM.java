package com.udacity.course3.reviews.entityM;

import org.springframework.data.mongodb.core.mapping.Document;
import javax.persistence.Id;

@Document("products")
public class ProductM {
    @Id
    private int product_Id;

    private String productName;

    private double productPrice;

    public int getProduct_Id() {
        return product_Id;
    }

    public void setProduct_Id(int product_Id) {
        this.product_Id = product_Id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(double productPrice) {
        this.productPrice = productPrice;
    }
}
