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
import com.techelevator.dao.PlotDAO;
import com.techelevator.model.Crop;





@RestController
@CrossOrigin
@RequestMapping("/home")

public class GardenController {
	
	private CropDAO cropDao;
	private PlotDAO plotDao;
	
	public GardenController(CropDAO cropDao, PlotDAO plotDao) {
		this.cropDao = cropDao;
		this.plotDao = plotDao;
	}
	
	@RequestMapping(value = "/myfarm", method = RequestMethod.GET)
	public List<Crop> listlistAllCropsForUser(@RequestParam(value = "user_id", defaultValue = "0") int userId){
						   
		if(userId > 0) {
			return cropDao.listCropsForViewFarm(userId);
		}
		return null;
	}
	


}
