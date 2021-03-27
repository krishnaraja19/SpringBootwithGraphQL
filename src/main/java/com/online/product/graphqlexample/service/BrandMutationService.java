package com.online.product.graphqlexample.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.online.product.graphqlexample.model.Brand;
import com.online.product.graphqlexample.repository.BrandRepository;

@Service
public class BrandMutationService implements GraphQLMutationResolver {
	
	@Autowired
	private BrandRepository brandRepository;
	
	@Autowired
	SequenceGeneratorService sequenceGeneratorService;
	
	
	@Transactional
	public Brand addNewBrand(String name,String startsAt,String rating) {
		return brandRepository.save(new Brand(sequenceGeneratorService.generateSequence("DatabaseSequence"),name,startsAt,rating));
		
	}
}
