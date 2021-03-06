package com.qa.paymentPlans;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

@Service
public class PaymentPlanService {
	
	private MongoTemplate mongoTemplate;
	
	@Autowired
	public PaymentPlanService(MongoTemplate mongoTemplate) {
		this.mongoTemplate = mongoTemplate;
	}
	
	public PaymentPlan getPaymentPlanByName(String name) throws Exception {
		if (name.matches("^[a-zA-Z]+$")) {
			
	        PaymentPlan pPlan = mongoTemplate.findOne(Query.query(Criteria.where("name").is(name)), PaymentPlan.class);
			
	        if( pPlan == null ) {
	            throw new Exception( "Payment plan not found" );
	        }
	 
	        return pPlan;
	       
    	} else {
    		throw new Exception("Bad payment plan: " + name);
    	}
    }
	
	public List<PaymentPlan> getAllPaymentPlans() {
		return mongoTemplate.find(Query.query(Criteria.where("name").exists(true)), PaymentPlan.class);				
		
	}

}
