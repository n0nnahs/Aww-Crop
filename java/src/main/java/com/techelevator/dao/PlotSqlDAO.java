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
		
		SqlRowSet results = jdbc.queryForRowSet(sql);
		while(results.next()) {
			Plot plotResult = mapRowToPlot(results);
			plots.add(plotResult);
		}
		return plots;
	}

	@Override
	public void create(Plot plot) {
		String sql = "INSERT INTO plot(name, length, width) "
				   + "VALUES(?, ?, ?)";
		jdbc.update(sql, plot.getName(), plot.getLength(), plot.getWidth());
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
