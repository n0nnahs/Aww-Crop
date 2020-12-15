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
@RequestMapping("/crops")

public class GardenController {
	
	private CropDAO cropDao;
	public GardenController(CropDAO cropDao, PlotDAO plotDao) {
		this.cropDao = cropDao;
	}
	
	@RequestMapping(value = "", method = RequestMethod.GET)
	public List<Crop> listAll(@RequestParam( value = "user_id", defaultValue = "0") int userId,
            				  @RequestParam(value = "plot_id", defaultValue = "0") int plotId){
		//if you want to return a list of all crops for the users farm
		if(userId > 0) {
			return cropDao.listAllCropsForUser(userId);
		}
		
		//if you want to look up a list of crops by the plot 
		else if(plotId > 0){
			return cropDao.listCropsForOnePlot(plotId);
		}
		
		//otherwise just returns a list of all crops available
		else return cropDao.listAll();
	}
	
	@RequestMapping(value = "/filter", method = RequestMethod.GET)
	public Crop getCrop(@RequestParam(value = "name", defaultValue = "") String cropName,
						@RequestParam(value = "id", defaultValue = "0") int cropId){
		if(!cropName.isEmpty()) {
			return cropDao.getCropByName(cropName);
		} 
		 if(cropId > 0) {
			return cropDao.getCropById(cropId);
			
		}
		return null;
	}
	
	@RequestMapping(value = "/myplot", method = RequestMethod.GET)
	public List<Crop> listlistAllCropsForOnePlot(@RequestParam int plotId){
						   
		if(plotId > 0) {
			return cropDao.listCropCoordinatesForOnePlot(plotId);
		}
		return null;
	}
	
	@RequestMapping(value = "/myplot", method = RequestMethod.POST)
	public void addCropCoordinateData(@RequestParam int plotId, @RequestBody Crop crop) {
		if(plotId > 0) {
			cropDao.updateCoordinateData(plotId, crop);
		}
	}
	

	

	 

}
