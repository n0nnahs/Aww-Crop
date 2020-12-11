package com.techelevator.controller;

import java.security.Principal;
import java.util.List;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.techelevator.dao.CropDAO;
import com.techelevator.model.Crop;





@RestController
@CrossOrigin
@RequestMapping("/crop")

public class CropController {
	
	private CropDAO dao;
	
	public CropController(CropDAO dao) {
		this.dao = dao;
	}
	
	@RequestMapping(value = "/myfarm", method = RequestMethod.GET)
	public List<Crop> list(@RequestParam(value = "user_id", defaultValue = "0") int userId){
						   
		if(userId > 0) {
			return dao.listCropsForViewFarm(userId);
		}
		return null;
	}
	
	@RequestMapping(value = "/myplot", method = RequestMethod.GET)
	public List<Crop> list(@RequestParam(value = "user_id", defaultValue = "0") int userId,
						   @RequestParam(value = "plot_id", defaultValue = "0") int plotId){
		if(userId > 0 && plotId > 0) {
			return dao.listCropsForOnePlot(userId, plotId);
		}
		return null;
	}

}
