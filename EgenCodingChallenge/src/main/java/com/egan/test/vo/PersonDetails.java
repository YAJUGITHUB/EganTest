package com.egan.test.vo;

import java.util.List;

import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;
import org.mongodb.morphia.annotations.Property;
import org.mongodb.morphia.annotations.Reference;

@Entity("person")
public class PersonDetails{
	  @Id	 
	  private double id;	 
	  @Property("name")
	  private String name;
	  @Property("age")
	  private int age;
	  @Reference
	  private List<MetricesDetails> metricesDetail;
	  public List<MetricesDetails> getMetricesDetail() {
		return metricesDetail;
	}
	  public PersonDetails(){}
	public void setMetricesDetail(List<MetricesDetails> metricesDetail) {
		this.metricesDetail = metricesDetail;
	}
	public PersonDetails(double personId,String name,int age){
		  this.id = personId;
		  this.name = name;
		  this.age = age;
	  }
	 public double getPersonId() {
			return id;
		}
		public void setPersonId(double personId) {
			this.id = personId;
		}
}
