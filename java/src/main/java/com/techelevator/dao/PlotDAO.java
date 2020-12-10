package com.techelevator.dao;

import java.util.List;

import com.techelevator.model.Crop;
import com.techelevator.model.Plot;

public interface PlotDAO {

	List<Plot> listAllForUser(int userId);
	
	List<Crop> listAllCropsInPlot(int plotId);
	
	boolean create(String name, int length, int width);
	
}
