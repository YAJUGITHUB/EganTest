package com.egan.test.vo;

import java.util.Date;

import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Property;
import org.mongodb.morphia.annotations.Reference;

@Entity("alerts")
public class AlertDetails {
	  @Reference	
	  private double id;
	  @Property("alert")
	  private String alert;
	  @Property("time")
	  private Date time;
	  
	  public double getId() {
		return id;
	  }

	  public void setId(double id) {
		this.id = id;
	  }
	  public AlertDetails(){		  
	  }
	  
	  public AlertDetails(double personId,String alert, Date time){
		  this.id=personId;
		  this.alert=alert;
		  this.time=time;
	  }
	  public String toString(){
		  StringBuilder sb = new StringBuilder();
		  sb.append(this.id);
		  sb.append(this.alert);
		  sb.append(time);
		  return sb.toString();		  
	  }
}
