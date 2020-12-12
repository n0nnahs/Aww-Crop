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

import com.techelevator.dao.PlotDAO;
import com.techelevator.dao.UserDAO;
import com.techelevator.model.Plot;

@RestController
@CrossOrigin
@RequestMapping("/plot")
public class PlotController {
	
	private PlotDAO dao;
	private UserDAO daoUser;

	public PlotController(PlotDAO plotDAO, UserDAO daoUser) {
		this.dao = plotDAO;
		this.daoUser = daoUser;
	}
	
//	@RequestMapping(value = "", method = RequestMethod.GET)
//	public List<Plot> list(@RequestParam(value = "user_id", defaultValue = "0") int userId,
//						   @RequestParam(value = "plot_id", defaultValue = "0") int plotId){
//		if(userId > 0) {
//			return dao.listAllForUser(userId);
//		}
//		if(plotId > 0) {
////			return dao.plotById(plotId);
//		}
//		return null;
//	}
	
    @ResponseStatus(HttpStatus.CREATED)
	@RequestMapping(value = "", method = RequestMethod.POST)
	public void createPlot(@Valid @RequestBody Plot newPlot, Principal p) {
		int plotId = dao.create(newPlot);
		
		dao.userPlot(daoUser.findIdByUsername(p.getName()), plotId);
	}
    
// Randy's testing code below...will delete //
    
    @RequestMapping(value = "/{user_id}", method = RequestMethod.GET)
	public List<Plot> breakfast(@PathVariable int user_id){
		if(user_id > 0) {
			return dao.listAllForUser(user_id);
		}
		return null;
    }
    
	@RequestMapping(value = "", method = RequestMethod.GET)
	public Plot lunch(@RequestParam int plotId){

			return dao.plotById(plotId);

	}
    
    
   
// Randy's testing code above...will delete //
	
}
