package com.techelevator.dao;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import com.techelevator.model.Crop;


@Component
public class CropSqlDAO implements CropDAO {

	private JdbcTemplate jdbc;
	
	 

	public CropSqlDAO(DataSource dataSource) {
		this.jdbc = new JdbcTemplate(dataSource);
	}

	@Override
	public List<Crop> listAll() {
		List<Crop> allCrops = new ArrayList<>();
		String sql = "SELECT crop_id, yield_lbs_per_square_foot, crops_per_square_foot, seed_cost, crops.name AS name, "
				+ "COUNT (coords_id) AS amount, "
				+ "        (COUNT (coords_id) * (yield_lbs_per_square_foot)) AS yield, description "
				+ "FROM crops JOIN plot_coords USING (crop_id) "
				+ "JOIN plot USING (plot_id) "
				+ "JOIN users_plot USING (plot_id) "
				+ "JOIN users USING (user_id) "
				+ "GROUP BY crops.name, crops.crop_id, yield_lbs_per_square_foot";
		SqlRowSet results = jdbc.queryForRowSet(sql);
		while(results.next()) {
			Crop c = mapRowToCrop(results);
			allCrops.add(c);
		}
		return allCrops;
		
	}
	
	@Override
	public Crop getCropById(int id) {
		String sql = "SELECT crop_id, name, yield_lbs_per_square_foot, crops_per_square_foot, seed_cost, description "
					+ "FROM crops "
					+ "WHERE crop_id = ?";
		SqlRowSet results = jdbc.queryForRowSet(sql, id);
		if(results.next()) {
			return mapRowToCrop(results);
		}
		else {
			return null;
		}
	}

	@Override
	public Crop getCropByName(String name) {
		String sql = "SELECT crop_id, name, yield_lbs_per_square_foot, crops_per_square_foot, seed_cost, description "
					+ "FROM crops "
					+ "WHERE name ILIKE ?";
		SqlRowSet results = jdbc.queryForRowSet(sql, name);
		if(results.next()) {
			return mapRowToCrop(results);
		}
		else {
			return null;
		}
	}
	
	@Override
	public List<Crop> listAllCropsInActivePlots(int plotId){
		List<Crop> cropsInPlot = new ArrayList<>();
		String sql = "SELECT crop_id, name, yield_lbs_per_square_foot, crops_per_square_foot, seed_cost, description "
			       + "FROM crops "
			       + "JOIN plot_coords USING (crop_id) "
			       + "WHERE plot_id = ?";
		SqlRowSet results = jdbc.queryForRowSet(sql, plotId);
		while(results.next()) {
			Crop c = mapRowToCrop(results);
			cropsInPlot.add(c);
		} 
		return cropsInPlot;
	}

	@Override
	public List<Crop> listAllCropsForUser(int userId) {
		List<Crop> cropsForUser = new ArrayList<>();
		String sql = "SELECT crop_id, yield_lbs_per_square_foot, crops_per_square_foot, seed_cost, crops.name AS name, "
				+ "COUNT (coords_id) AS amount, "
				+ "        (COUNT (coords_id) * (yield_lbs_per_square_foot)) AS yield, description "
				+ "FROM crops JOIN plot_coords USING (crop_id) "
				+ "JOIN plot USING (plot_id) "
				+ "JOIN users_plot USING (plot_id) "
				+ "JOIN users USING (user_id) "
				+ "WHERE user_id = ? AND active = true "
				+ "GROUP BY crops.name, crops.crop_id, yield_lbs_per_square_foot";
		SqlRowSet results = jdbc.queryForRowSet(sql, userId);
		while(results.next()) {
			Crop c = mapRowToCrop(results);
			cropsForUser.add(c);
		}
		
		return cropsForUser;
	}

	
	@Override
	public List<Crop> listCropsForOnePlot(int plotId) {
		List<Crop> plotCrops = new ArrayList<>();
		String sql = "SELECT crop_id, yield_lbs_per_square_foot, crops_per_square_foot, seed_cost, crops.name AS name, " +
				     "COUNT (coords_id) AS amount, " +
				     "(COUNT (coords_id) * (yield_lbs_per_square_foot)) AS yield " +
				     "FROM crops JOIN plot_coords USING (crop_id) " +
				     "JOIN plot USING (plot_id) " +
				     "JOIN users_plot USING (plot_id) " +
				     "JOIN users USING (user_id) " +
				     "WHERE plot_id = ? " +
				     "GROUP BY crops.name, yield_lbs_per_square_foot ";
		SqlRowSet results = jdbc.queryForRowSet(sql, plotId);
		while(results.next()) {
			Crop c = mapRowToCrop(results);
			plotCrops.add(c);
		}
		return plotCrops;
	}
	
	public List<Crop> listCropCoordinatesForOnePlot (int plotId) {
		List<Crop> plotCrops = new ArrayList<>();
		String sql = "SELECT plot_id, crop_id, crops.name, plot_coords.x, plot_coords.y " + 
				"FROM crops JOIN plot_coords USING (crop_id) " + 
				"JOIN plot USING (plot_id) " + 
				"JOIN users_plot USING (plot_id) " + 
				"JOIN users USING (user_id) " + 
				"WHERE plot_id = ?";
		SqlRowSet results = jdbc.queryForRowSet(sql, plotId);
		while(results.next()) {
			Crop c = mapRowToCropCoordDetails(results);
			plotCrops.add(c);
		}
		return plotCrops;
	}
	
	public void updateCoordinateData(int plotId, Crop crop) {
		String cropName = crop.getName();
		int id = getCropId(cropName);
		String d = "dirt";
		if(cropName.equals(d)){
			String sqlDelete = "DELETE FROM plot_coords WHERE plot_id = ? AND x = ? AND y = ?";
			jdbc.update(sqlDelete, plotId, crop.getxCoordinate(), crop.getyCoordinate());
		} else if(checkCropCoordinates(crop)) {
			String sql = "UPDATE plot_coords SET crop_id = ? WHERE x = ? AND y = ?";
			jdbc.update(sql, id, crop.getxCoordinate(), crop.getyCoordinate());

		} else {
			String sqlElse = "INSERT INTO plot_coords (coords_id, crop_id, plot_id, x, y) " + 
					"VALUES (DEFAULT, ?, ?, ?, ?)";
			int cropId = getCropId(cropName);
			jdbc.update(sqlElse, cropId, plotId, crop.getxCoordinate(), crop.getyCoordinate());
		}
	}

	public int getCropId(String cropName) {
		int output = 0;
		String sql = "SELECT crop_id FROM crops " + 
				"WHERE name ILIKE ?";
		SqlRowSet results = jdbc.queryForRowSet(sql, cropName);
		while(results.next()) {
			output = results.getInt("crop_id");
		}
		return output;
	}
	
	public boolean checkCropCoordinates(Crop crop) {
		boolean output = false;
		String sql = "SELECT * FROM plot_coords " + 
				"WHERE plot_id = ? AND x = ? AND y = ?";
		SqlRowSet results = jdbc.queryForRowSet(sql, crop.getPlotId(), crop.getxCoordinate(), crop.getyCoordinate());
		while(results.next()) {
			if(results.getInt("crop_id") >= 1)
			output = true;
		}
		return output;
	}
	
	private Crop mapRowToCrop(SqlRowSet results) {
		Crop c = new Crop();
		c.setId(results.getInt("crop_id"));
		c.setName(results.getString("name").toLowerCase());
		c.setYeild(results.getDouble("yield_lbs_per_square_foot"));
		c.setCropsPerSqFt(results.getInt("crops_per_square_foot"));
		c.setSeed_cost(results.getDouble("seed_cost"));
		c.setDescription(results.getString("description"));
		c.setAmount(results.getInt("amount"));
		c.setTotalYield(results.getDouble("yield"));
		return c;
	}
	
	private Crop mapRowToCropCoordDetails(SqlRowSet results) {
		Crop c = new Crop();
		c.setName(results.getString("name").toLowerCase());
		c.setxCoordinate(results.getInt("x"));
		c.setyCoordinate(results.getInt("y"));
		c.setPlotId(results.getInt("plot_id"));
		return c;
	}

	@Override
	public Crop getTopCropForPlot(int plotId) {
		// TODO Auto-generated method stub
		return null;
	}


}
