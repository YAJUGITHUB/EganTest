package com.egan.test.rule;

import java.util.Date;

import org.easyrules.annotation.Action;
import org.easyrules.annotation.Condition;
import org.easyrules.annotation.Rule;
import org.springframework.beans.factory.annotation.Autowired;

import com.egan.test.service.AlertService;
import com.egan.test.vo.AlertDetails;
import com.egan.test.vo.AllDetails;

@Rule(name = "UnderWeightRule",description = "Check if person's weight is less then 10 % of base weight")
public class UnderWeightRule {

	@Autowired
	private AlertService alertservice;
	
	private AllDetails allDetails;
	private double baseWeight = 0;
	private double tenPercent = 0;
	private double currentWeight  = 0; 
	
   
 public UnderWeightRule(AllDetails allDetails, AlertService alertservice) {
  this.allDetails = allDetails;
  this.baseWeight = this.allDetails.getBaseWeight();
  tenPercent =  baseWeight*10/100;
  currentWeight = allDetails.getWeight();
  this.alertservice = alertservice;
}

@Condition
public boolean isUnderWeight() {
	boolean isUnderWight = false;	
	if(currentWeight < baseWeight){
		double weightDiff = baseWeight - currentWeight ;
		if(weightDiff > tenPercent){
			return true;
		}else{
			return false;
		}
	}
	return isUnderWight;
}

@Action
public void markAsUnderWeight(){
	AlertDetails alertDetail = new AlertDetails(allDetails.getId(),"Weight is Under of 10% of your Base Weight",new Date());	
	alertservice.create(alertDetail);
}
}


