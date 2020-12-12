package com.techelevator.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;

import com.techelevator.model.Crop;
import com.techelevator.model.Plot;


@Component
public class PlotSqlDAO implements PlotDAO {

	private JdbcTemplate jdbc;
	
	public PlotSqlDAO(DataSource dataSource) {
		this.jdbc = new JdbcTemplate(dataSource);
	}
	
	@Override
	public List<Plot> listAllForUser(int userId) {
		List<Plot> plots = new ArrayList<>();
		String sql =  "SELECT plot_id, name, length, width, active "
					+ "FROM plot "
					+ "JOIN users_plot USING(plot_id) "
					+ "JOIN users USING (user_id) "
					+ "WHERE user_id = ?";
		
		SqlRowSet results = jdbc.queryForRowSet(sql, userId);
		while(results.next()) {
			Plot plotResult = mapRowToPlot(results);
			plots.add(plotResult);
		}
		return plots;
	}

	@Override
	public int create(Plot plot) {
		String sqlCreate = "INSERT INTO plot(name, length, width) "
				   + "VALUES(?, ?, ?) "
				   + "RETURNING plot_id";
		Long plotIdLong = jdbc.queryForObject(sqlCreate, Long.class, plot.getName(), plot.getLength(), plot.getWidth());
		return plotIdLong.intValue();
		
	}
	
	@Override
	public void userPlot(int userId, int plotId) {
		String sql = "INSERT INTO users_plot(user_id, plot_id) "
				   + "VALUES(?, ?)";
		jdbc.update(sql, userId, plotId);
	}
	
	@Override
	public Plot plotById(int plotId) {
		Plot plotResult = new Plot();
		String sql =  "SELECT plot_id, name, length, width, active "
					+ "FROM plot "
					+ "WHERE plot_id = ?";
		
		SqlRowSet results = jdbc.queryForRowSet(sql, plotId);
		
			
			//plots.add(plotResult);
			if(results.next()) {
				plotResult = mapRowToPlot(results);
			}
		
		return plotResult;
	}


	private Plot mapRowToPlot(SqlRowSet results) {
		Plot p = new Plot();
		p.setId(results.getInt("plot_id"));
		p.setName(results.getString("name"));
		p.setLength(results.getInt("length"));
		p.setWidth(results.getInt("width"));
		
		return p;
	}
}
