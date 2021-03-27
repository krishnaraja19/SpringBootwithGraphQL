package com.online.product.graphqlexample.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coxautodev.graphql.tools.GraphQLResolver;
import com.online.product.graphqlexample.model.Brand;
import com.online.product.graphqlexample.model.Product;
import com.online.product.graphqlexample.repository.BrandRepository;

@Service
public class BrandService implements GraphQLResolver<Product>{
	
	@Autowired
	private BrandRepository brandRepository;
	
	public Brand getBrand(Product product) {
		return brandRepository.findById((long) product.getBrandId()).get();
	}
	
	public List<Brand> getAllBrands(){
		return brandRepository.findAll();
	}
}
