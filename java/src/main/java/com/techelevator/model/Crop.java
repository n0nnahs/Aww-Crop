package com.techelevator.model;

public class Crop {
	
	private int id;
	private String name;
	private double yeild;
	private int cropsPerSqFt;
	private double seed_cost;
	private String description;
	private int amount;
	private double totalYield;
	private int xCoordinate;
	private int yCoordinate;
	private int plotId;
	

	public Crop(int id, String name, double yeild, int cropsPerSqFt, double seed_cost, String description) {
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
	
	public Crop(String name, int amount, double totalYield) {
		this.name = name;
		this.amount = amount;
		this.totalYield = totalYield;
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
	public double getYeild() {
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
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public double getTotalYield() {
		return totalYield;
	}
	public void setTotalYield(int totalYield) {
		this.totalYield = totalYield;
	}
	public int getxCoordinate() {
		return xCoordinate;
	}
	public void setxCoordinate(int xCoordinate) {
		this.xCoordinate = xCoordinate;
	}
	public int getyCoordinate() {
		return yCoordinate;
	}
	public void setyCoordinate(int yCoordinate) {
		this.yCoordinate = yCoordinate;
	}	
	public int getPlotId() {
		return plotId;
	}
	public void setPlotId(int plotId) {
		this.plotId = plotId;
	}

}
