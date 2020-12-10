package com.techelevator.dao;

import java.util.List;

import com.techelevator.model.Crop;
import com.techelevator.model.Plot;

public interface PlotDAO {

	List<Plot> listAllForUser(int userId);
		
	void create(Plot plot);
	
}
