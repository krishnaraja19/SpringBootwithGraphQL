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
@Document(collection = "brands")
public class Brand {
	
	
	@Id
	private long brandId;
	private String name;
	private String startsAt;
	private String rating;
	
	public Brand(String name,String startsAt,String rating) {
		this.name = name;
		this.startsAt = startsAt;
		this.rating = rating;
	}
}
