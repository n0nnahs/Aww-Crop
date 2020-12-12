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
		String sql = "SELECT crop_id, name, yield_lbs_per_square_foot, crops_per_square_foot, seed_cost, description "
			       + "FROM crops";
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
					+ "WHERE name ILIKE '?'";
		SqlRowSet results = jdbc.queryForRowSet(sql, name);
		if(results.next()) {
			return mapRowToCrop(results);
		}
		else {
			return null;
		}
	}
	
	@Override
	public List<Crop> listAllCropsInPlot(int plotId){
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
		String sql = "SELECT crop_id, c.name, yield_lbs_per_square_foot, crops_per_square_foot, seed_cost, description "
				+ "FROM crops "
				+ "JOIN plot_coords pc USING (crop_id) "
				+ "JOIN plot p USING (plot_id) "
				+ "JOIN users_plot up USING (plot_id) "
				+ "WHERE up.user_id = ?";
		SqlRowSet results = jdbc.queryForRowSet(sql, userId);
		while(results.next()) {
			Crop c = mapRowToCrop(results);
			cropsForUser.add(c);
		}
		
		return cropsForUser;
	}

	private Crop mapRowToCrop(SqlRowSet results) {
		Crop c = new Crop();
		c.setId(results.getInt("crop_id"));
		c.setName(results.getString("name"));
		c.setYeild(results.getInt("yield_lbs_per_square_foot"));
		c.setCropsPerSqFt(results.getInt("crops_per_square_foot"));
		c.setSeed_cost(results.getDouble("seed_cost"));
		c.setDescription(results.getString("description"));
		return c;
	}
}
