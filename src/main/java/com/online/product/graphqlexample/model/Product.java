package com.online.product.graphqlexample.model;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Document(collection = "products")
public class Product {
	

	
	@Id
	private long productId;
	private String name;
	private String expiryDate;
	private String mfgDate;
	private long brandId;
	private Brand brand;
	
	public Product(String name,String expiryDate,String mfgDate,long brandId,Brand brand) {
		this.name = name;
		this.expiryDate = expiryDate;
		this.mfgDate = mfgDate;
		this.brandId = brandId;
		this.brand = brand;
	}
	

}
