package com.mijatovic.microservices.product.repository;

import com.mijatovic.microservices.product.model.Product;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductRepository extends MongoRepository<Product, String> {
}
