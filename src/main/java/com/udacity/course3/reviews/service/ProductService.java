package com.udacity.course3.reviews.service;

import com.udacity.course3.reviews.entity.Product;
import com.udacity.course3.reviews.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public List<Product> list() {

        return productRepository.findAll();
    }

    public Product findById(int i) {

        return productRepository.findById(i).orElseThrow(ProductNotFoundException::new);
    }

    public void saveProduct(Product product) {
        productRepository.save(product);
    }

}
