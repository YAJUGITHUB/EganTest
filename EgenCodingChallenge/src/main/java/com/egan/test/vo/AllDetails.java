package com.egan.test.vo;

import java.util.Date;

public class AllDetails{
	private double id;
	private String name;
	private double weight;
	private Date time;
	private int age;
	private double baseWeight;
	public double getBaseWeight() {
	return baseWeight;
	}
	public void setBaseWeight(double baseWeight) {
		this.baseWeight = baseWeight;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public double getId() {
		return id;
	}
	public void setId(double id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getWeight() {
		return weight;
	}
	public void setWeight(double weight) {
		this.weight = weight;
	}
	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		this.time = time;
	}


}
