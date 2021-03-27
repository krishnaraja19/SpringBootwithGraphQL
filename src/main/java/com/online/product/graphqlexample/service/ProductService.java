package com.online.product.graphqlexample.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.online.product.graphqlexample.model.Brand;
import com.online.product.graphqlexample.model.Product;
import com.online.product.graphqlexample.repository.BrandRepository;
import com.online.product.graphqlexample.repository.ProductRepository;

@Service 
public class ProductService implements GraphQLQueryResolver{
	
	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private BrandRepository brandRepository;
	
	public Product getProductById(int productId) {
		return productRepository.findById((long) productId).get();
	}
	
	public List<Product> getAllProducts(){
		return productRepository.findAll();
	}
	
	public List<Brand> getAllBrands(){
		return brandRepository.findAll();
	}
	
	
}
