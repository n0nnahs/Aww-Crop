package com.techelevator.dao;

import java.util.List;

import com.techelevator.model.Crop;

public interface CropDAO {

	List<Crop> listAll();
	
	List<Crop> listAllCropsInPlot(int plotId);
	
	Crop getCropByName(String name);
	
	Crop getCropById(int id);

	List<Crop> listAllCropsForUser(int userId);

	List<Crop> listCropsForViewFarm(int userId);

	List<Crop> listCropsForOnePlot(int plotId);

	
}
