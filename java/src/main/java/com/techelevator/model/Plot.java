package com.techelevator.model;

public class Plot {
	
	private int id;
	private String name;
	private int length;
	private int width;
	
	public Plot(int id, String name, int length, int width) {
		this.id = id;
		this.name = name;
		this.length = length;
		this.width = width;
	}

	public Plot() {
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
