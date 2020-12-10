package com.techelevator.dao;

import java.util.List;

import com.techelevator.model.Crop;
import com.techelevator.model.Plot;

public class PlotSqlDAO implements PlotDAO {

	@Override
	public List<Plot> listAllForUser(int userId) {

		return null;
	}

	@Override
	public List<Crop> listAllCropsInPlot(int plotId) {

		return null;
	}

	@Override
	public boolean create(String name, int length, int width) {

		return false;
	}

}
