package com.online.product.graphqlexample.service;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.FindAndModifyOptions;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import com.online.product.graphqlexample.model.DatabaseSequence;

@Service
public class SequenceGeneratorService {

	
	private MongoOperations mongoOperations;

		
	@Autowired
    public SequenceGeneratorService(MongoOperations mongoOperations) {
        this.mongoOperations = mongoOperations;
    }
	
	
	
    public long generateSequence(String seqName)
    {
    	
    	// get the sequence number
        final Query query = new Query(Criteria.where("id").is(seqName));
        
        
        DatabaseSequence counter = mongoOperations.findAndModify(query,new Update().inc("seq",1),
        		FindAndModifyOptions.options().returnNew(true).upsert(true),
            DatabaseSequence.class);
        return !Objects.isNull(counter) ? counter.getSeq() : 1;
    }
}
