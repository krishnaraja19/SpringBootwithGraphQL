package com.online.product.graphqlexample.service;

import java.util.concurrent.ConcurrentHashMap;

import org.reactivestreams.Publisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.coxautodev.graphql.tools.GraphQLSubscriptionResolver;
import com.online.product.graphqlexample.model.Brand;
import com.online.product.graphqlexample.model.Product;
import com.online.product.graphqlexample.model.ProductMutationInput;
import com.online.product.graphqlexample.repository.BrandRepository;
import com.online.product.graphqlexample.repository.ProductRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.FluxSink;

@Service
public class ProductMutationService implements GraphQLMutationResolver,GraphQLSubscriptionResolver {
	
	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private BrandRepository brandRepository;
	
	@Autowired
	SequenceGeneratorService sequenceGeneratorService;
	
	private ConcurrentHashMap<Long, FluxSink<Product>> subscribers =
					new ConcurrentHashMap<>();
	
	
	@Transactional
	public Product addNewProduct(String name,String expiryDate,String mfgDate,long brandId) {
		
		Product product = productRepository.save(new Product(sequenceGeneratorService.generateSequence("DatabaseSequence"),name,expiryDate,mfgDate,brandId,brandRepository.findById(brandId).get()));
		
		if(subscribers.get(product.getProductId())!= null)
			subscribers.get(product.getProductId()).next(product);	
		return product;
		
	}
	
	@Transactional
	public Product addNewProductByInputObject(ProductMutationInput input) {
		
		Product product  = productRepository.save(new Product(sequenceGeneratorService.generateSequence("DatabaseSequence"),input.getName(),input.getExpiryDate(),input.getMfgDate(),input.getBrandId(),brandRepository.findById(input.getBrandId()).get()));
		if(subscribers.get(product.getProductId())!= null)
			subscribers.get(product.getProductId()).next(product);	
		return product;
		
	}
	
	@Transactional
	public Product updateProductById(Long productId,String name) {
		
		Product product = productRepository.findById(productId).get();
		product.setName(name);
		productRepository.save(product);
		if(subscribers.get(product.getProductId())!= null)
			subscribers.get(product.getProductId()).next(product);	
		return product;
		
	}
	
	public Publisher<Product> onProductUpdate(Long productId){
		return Flux.create(subscriber -> subscribers.put(productId,subscriber.onDispose(()->subscribers.remove(productId,subscriber))) , FluxSink.OverflowStrategy.LATEST);
		
	}
}
