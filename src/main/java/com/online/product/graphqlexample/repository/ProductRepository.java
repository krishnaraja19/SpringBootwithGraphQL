package com.online.product.graphqlexample.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.online.product.graphqlexample.model.Product;

@Repository
public interface ProductRepository extends MongoRepository<Product, Long>{

}
