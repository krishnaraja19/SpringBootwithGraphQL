package com.online.product.graphqlexample.model;

import graphql.schema.GraphQLInputType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class ProductMutationInput implements GraphQLInputType{
	
	
	private long productId;
	private String name;
	private String expiryDate;
	private String mfgDate;
	private long brandId;
}
