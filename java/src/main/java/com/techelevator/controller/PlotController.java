package com.techelevator.controller;

import java.security.Principal;
import java.util.ArrayList;
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
import com.techelevator.model.Note;
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
	public int createPlot(@Valid @RequestBody Plot newPlot, Principal p) {
    	
		//creates a new plot and returns the new plots ID
    	int plotId = dao.create(newPlot);
    	
		//adds the new plot and the user who created the plot to the user_plot table
		dao.userPlot(daoUser.findIdByUsername(p.getName()), plotId);
		return plotId;
	}
    

	@RequestMapping(value = "/{plotId}", method = RequestMethod.GET)
	public Plot lunch(@PathVariable("plotId") int plotId){
			return dao.plotById(plotId);

	}
    
	
	@RequestMapping(value = "/myplot", method = RequestMethod.GET)
	public List<Crop> listCropsForOnePlot (@RequestParam int plotId){
		if(plotId > 0) {
			return cropDao.listCropsForOnePlot(plotId);
		}
		return null;
	}

	@RequestMapping(value = "/notes/{user_id}", method = RequestMethod.GET)
	public List<Note> getAllNotesForPlot(@PathVariable int user_id){
		return dao.getAllNotesForUser(user_id);
	}
	
	@ResponseStatus(HttpStatus.CREATED)
	@RequestMapping(value = "/notes", method = RequestMethod.POST)
	public void createNewNote(@Valid @RequestBody Note newNote) {
		dao.addNewNote(newNote);
	}
	
	@ResponseStatus(HttpStatus.ACCEPTED)
	@RequestMapping(value = "/notes/{id}/update", method = RequestMethod.PUT)
	public void updateNote(@Valid @RequestBody Note updateNote, @PathVariable int id) {
		dao.updateNote(updateNote, id);
	}
	
	@ResponseStatus(HttpStatus.ACCEPTED)
	@RequestMapping(value = "/notes/delete", method = RequestMethod.DELETE)
	public void deleteNote(@RequestParam int noteId) {
		dao.deleteNote(noteId);
	}
	
	@ResponseStatus(HttpStatus.ACCEPTED)
	@RequestMapping(value = "/abandon/{plotId}", method = RequestMethod.PUT)
	public void abandonPlot(@PathVariable int plotId) {
		dao.abandonPlot(plotId);
	}
	@ResponseStatus(HttpStatus.ACCEPTED)
	@RequestMapping(value = "/activate/{plotId}", method = RequestMethod.PUT)
	public void activatePlot(@PathVariable int plotId) {
		dao.activatePlot(plotId);
	}
}
