package com.egan.test.vo;

import java.util.Date;

import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Property;
import org.mongodb.morphia.annotations.Reference;

@Entity("metrices")
public class MetricesDetails {
	MetricesDetails(){
		
	}
  public MetricesDetails(double personId, double weight, Date time) {
		// TODO Auto-generated constructor stub
	  this.id=personId;
	  this.weight=weight;
	  this.time=time;
	}

  @Reference	
  private double id;
  public double getId() {
	return id;
}
public void setId(double id) {
	this.id = id;
}

@Property("weight")
  private double weight;
  @Property("time")
  private Date time;
 
public double getWeight() {
	return weight;
}
public void setWeight(double weight) {
	this.weight = weight;
}
}
