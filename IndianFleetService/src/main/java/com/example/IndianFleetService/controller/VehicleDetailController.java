package com.example.IndianFleetService.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.IndianFleetService.entity.VehicleDetail;
import com.example.IndianFleetService.service.impl.VehicleDetailServiceImpl;

@RestController
@RequestMapping("/VehicleMaster")
@CrossOrigin(origins = "http://localhost:3000")
public class VehicleDetailController 
{
	@Autowired
	private VehicleDetailServiceImpl vehicle;
	
	@GetMapping("/AllVehicle")
	public ResponseEntity<List<VehicleDetail>> getAllVehicleDetail()
	{
		List<VehicleDetail> veh = null;
		
		try
		{
			veh=vehicle.getAllVehicleDetail();
		}
		catch(Exception e)
		{
			e.getMessage();
		}
		
		return new ResponseEntity<List<VehicleDetail>>(veh, HttpStatus.OK);
	}
	
}
