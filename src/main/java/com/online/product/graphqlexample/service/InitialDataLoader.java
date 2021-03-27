package com.online.product.graphqlexample.service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.online.product.graphqlexample.model.Brand;
import com.online.product.graphqlexample.model.Product;
import com.online.product.graphqlexample.repository.BrandRepository;
import com.online.product.graphqlexample.repository.ProductRepository;

@Service
public class InitialDataLoader {
	
	
	@Autowired
	private BrandRepository brandRepository;
	
	@Autowired
	private ProductRepository productRepository;
	
//	@PostConstruct
//	public void loadData() {
//		List<Brand> brands = Stream.of(
//				new Brand("Sony", "03-11-1954", "5"),
//				new Brand("Zebranics", "03-11-1954", "5"),
//				new Brand("Nokia", "03-11-1954", "5")
//				).collect(Collectors.toList());
//		brands.forEach(brand -> {
//			brandRepository.save(brand);
//		});
//		
//		List<Brand> brandListFromDB = brandRepository.findAll();
//		brandListFromDB.forEach(brand -> {
//			if(brand.getName().equalsIgnoreCase("Sony")) 
//				productRepository.save(new Product("Sony WH-1000XM3 Headphones","10-10-2030","10-10-2020",brand.getBrandId(),brand));
//			
//			if(brand.getName().equalsIgnoreCase("Zebranics"))
//				productRepository.save(new Product("Wireless Mouse","10-10-2030","10-10-2020",brand.getBrandId(),brand));
//			if(brand.getName().equalsIgnoreCase("Nokia"))
//				productRepository.save(new Product("Nokia 220 function phone","10-10-2030","10-10-2020",brand.getBrandId(),brand));
//			
//		});
//	}
}
