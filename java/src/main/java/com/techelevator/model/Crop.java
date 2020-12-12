package com.techelevator.model;

public class Crop {
	
	private int id;
	private String name;
	private int yeild;
	private int cropsPerSqFt;
	private double seed_cost;
	private String description;
	
	public Crop(int id, String name, int yeild, int cropsPerSqFt, double seed_cost, String description) {
		this.id = id;
		this.name = name;
		this.yeild = yeild;
		this.cropsPerSqFt = cropsPerSqFt;
		this.seed_cost = seed_cost;
		this.description = description;
	}
	
	public Crop(int id, String name, String description) {
		this.id = id;
		this.name = name;
		this.description = description;
	}

	public Crop() {
		super();
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getYeild() {
		return yeild;
	}
	public void setYeild(int yeild) {
		this.yeild = yeild;
	}
	public int getCropsPerSqFt() {
		return cropsPerSqFt;
	}
	public void setCropsPerSqFt(int cropsPerSqFt) {
		this.cropsPerSqFt = cropsPerSqFt;
	}
	public double getSeed_cost() {
		return seed_cost;
	}
	public void setSeed_cost(double seed_cost) {
		this.seed_cost = seed_cost;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}


}
