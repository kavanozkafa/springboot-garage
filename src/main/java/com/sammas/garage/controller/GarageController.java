package com.sammas.garage.controller;

import java.util.HashMap;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sammas.garage.dto.Vehicle;
import com.sammas.garage.service.ParkService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@CrossOrigin(origins = "http://localhost:8085")
@RestController
@RequestMapping("/api/v1")
@Api(value = "Garage Parking API")
@ApiResponses(value = {
		@ApiResponse(code = 200, message ="OK"),
		@ApiResponse(code = 401, message ="Unauthorized"),
		@ApiResponse(code = 400, message ="Bad request")
})

public class GarageController {
	        
	@Autowired
	private ParkService parkService;

	private Logger logger = LoggerFactory.getLogger(GarageController.class);
	
	@ApiOperation(value = "api health check service",response = String.class)
	@GetMapping("/marco")
	public String message(){
		return "polo";
	}
	
	@ApiOperation(value = "Returns garage status",response = HashMap.class)
	@GetMapping("/status")
	public HashMap<String, Object> status(){		 
		return parkService.getStatus();
	}
		
	@ApiOperation(value = "Parks vehicle and returns ticketId",response = HashMap.class)
	@PostMapping("/park")
	public HashMap<String, String> park(@Valid @RequestBody Vehicle vehicle){
		logger.info(vehicle.toString());	 
		return parkService.park(vehicle);
	}


	@ApiOperation(value = "Take out vehicle from garage by ticketId",response = String.class)
	@PostMapping("/leave")
	public String leave(@RequestBody HashMap<String, String> input){
		logger.info(input.toString());
		return parkService.leave(input.get("ticketId"));
	}
	
}
