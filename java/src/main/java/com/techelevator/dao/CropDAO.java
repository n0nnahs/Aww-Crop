package com.techelevator.dao;

import java.util.List;

import com.techelevator.model.Crop;

public interface CropDAO {

	List<Crop> listAll();
	
	Crop getCropByName(String name);
	
	Crop getCropById(int id);
	
}
