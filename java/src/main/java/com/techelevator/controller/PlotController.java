package com.techelevator.controller;

import java.security.Principal;
import java.util.List;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.techelevator.dao.CropDAO;
import com.techelevator.dao.PlotDAO;
import com.techelevator.dao.UserDAO;
import com.techelevator.model.Crop;
import com.techelevator.model.Plot;

@RestController
@CrossOrigin
@RequestMapping("/plot")

public class PlotController {
	
	private CropDAO cropDao;
	private PlotDAO dao;
	private UserDAO daoUser;

	public PlotController(CropDAO cropDao, PlotDAO plotDAO, UserDAO daoUser) {
		this.dao = plotDAO;
		this.daoUser = daoUser;
		this.cropDao = cropDao;
	}
	
	@RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
	public List<Plot> list(@PathVariable("id") int userId){
		return dao.listAllForUser(userId);
	}

    @ResponseStatus(HttpStatus.CREATED)
	@RequestMapping(value = "", method = RequestMethod.POST)
	public void createPlot(@Valid @RequestBody Plot newPlot, Principal p) {
    	
		//creates a new plot and returns the new plots ID
    	int plotId = dao.create(newPlot);
    	
		//adds the new plot and the user who created the plot to the user_plot table
		dao.userPlot(daoUser.findIdByUsername(p.getName()), plotId);
	}
    
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public List<Crop> listCropsForOnePlot (@PathVariable("id") int plotId){
		return cropDao.listCropsForOnePlot(plotId);
	}
	
	
	
}
