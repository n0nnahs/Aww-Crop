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
	public Crop getCropByName(String name) {
		return null;
	}

	@Override
	public Crop getCropById(int id) {
		return null;
	}

	@Override
	public List<Crop> listAllCropsInPlot(int plotId) {
		return null;
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
