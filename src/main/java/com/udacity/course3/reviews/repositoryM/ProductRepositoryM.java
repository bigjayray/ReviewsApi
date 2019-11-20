package com.udacity.course3.reviews.repositoryM;

import com.udacity.course3.reviews.entityM.ProductM;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductRepositoryM extends MongoRepository<ProductM, Integer> {
}
