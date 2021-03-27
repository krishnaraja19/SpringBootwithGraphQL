package com.online.product.graphqlexample.repository;

import org.checkerframework.common.util.report.qual.ReportCreation;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.online.product.graphqlexample.model.Brand;

@Repository
public interface BrandRepository extends MongoRepository<Brand, Long>{

}
