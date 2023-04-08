package com.example.IndianFleetService.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.IndianFleetService.entity.AlternateComponentMaster;
import com.example.IndianFleetService.service.AlternateComponentMasterService;

@RestController
@RequestMapping("/AlternateMaster")
@CrossOrigin(origins = "http://localhost:3000")
public class AlternateComponentMasterController 
{
	@Autowired
	private AlternateComponentMasterService alterComp;
	
	@GetMapping("/AlterComp")
	public ResponseEntity<List<AlternateComponentMaster>> getAllAlterComponent()
	{
		List<AlternateComponentMaster> alt = null;
		
		try
		{
			alt=alterComp.getAllAlterComponent();
		}
		catch(Exception e)
		{
			e.getMessage();
		}
		
		return new ResponseEntity<List<AlternateComponentMaster>>(alt, HttpStatus.OK);
	}
	
}
