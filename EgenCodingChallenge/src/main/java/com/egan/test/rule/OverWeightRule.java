package com.egan.test.rule;

import java.util.Date;

import org.easyrules.annotation.Action;
import org.easyrules.annotation.Condition;
import org.easyrules.annotation.Rule;
import org.springframework.beans.factory.annotation.Autowired;

import com.egan.test.service.AlertService;
import com.egan.test.vo.AlertDetails;
import com.egan.test.vo.AllDetails;

@Rule(name = "OverWeightRule")
public class OverWeightRule {
	
    @Autowired
	private AlertService alertservice;
	
	private AllDetails allDetails;
	private double baseWeight = 0;
	private double tenPercent = 0;
	private double currentWeight  = 0; 
	 
	public OverWeightRule(AllDetails allDetails,AlertService alertservice) {
	  this.allDetails = allDetails;
	  this.baseWeight = this.allDetails.getBaseWeight();
	  tenPercent =  baseWeight*20/100;
	  currentWeight = allDetails.getWeight();
	  this.alertservice = alertservice;
	}
	
	@Condition
	public boolean isOverWeight() {
		boolean isOverWight = false;	
		if(currentWeight > baseWeight){
			double weightDiff = currentWeight - baseWeight;
			if(weightDiff > tenPercent){
				return true;
			}else{
				return false;
			}
		}
		return isOverWight;
   }
	
	@Action
	public void markAsOverWeight(){
		AlertDetails alertDetails = new AlertDetails(allDetails.getId(),"Weight is Over of 10% of your Base Weight",new Date());
		alertservice.create(alertDetails);
	  //person.setAdult(true);
	  //System.out.printf("Person %s has been marked as adult", person.getName());
	}
}
