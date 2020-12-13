package com.techelevator.model;

public class Plot {
	
	private int id;
	private String name;
	private int length;

	private int width;
	private boolean active;
	
	private String topCrop;
	

	public Plot(int id, String name, int length, int width, boolean active) {
		this.id = id;
		this.name = name;
		this.length = length;
		this.width = width;
		this.active = active;
	}
	
	public Plot() {
	}

	public String getTopCrop() {
		return topCrop;
	}
	
	public void setTopCrop(String topCrop) {
		this.topCrop = topCrop;
	}

	public boolean isActive() {
		return active;
	}
	
	public void setActive(boolean active) {
		this.active = active;
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

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}
	
	
	
}
