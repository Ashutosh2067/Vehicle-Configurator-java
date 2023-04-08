package com.example.IndianFleetService.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.IndianFleetService.entity.ModelMaster;
import com.example.IndianFleetService.service.ModelMasterService;

@RestController
@RequestMapping("/ModelMaster")
@CrossOrigin(origins = "http://localhost:3000")
public class ModelMasterController 
{
	@Autowired
	private ModelMasterService model;
	
	@GetMapping("/AllModel")
	public ResponseEntity<List<ModelMaster>> getAllModelMaster()
	{
		List<ModelMaster> mod = null;
		
		try
		{
			mod=model.getAllModelMaster();
		}
		catch(Exception e)
		{
			e.getMessage();
		}
		
		return new ResponseEntity<List<ModelMaster>>(mod, HttpStatus.OK);
	}
	
	@GetMapping("/AllModel/{mfg_id}")
	public ResponseEntity<List<ModelMaster>> getAllModelByMfgId(@PathVariable("mfg_id") int mfg_id)
	{
		List<ModelMaster> mod = null;
		
		try
		{
			mod=model.getAllModelByMfgId(mfg_id);
		}
		catch(Exception e)
		{
			e.getMessage();
		}
		
		return new ResponseEntity<List<ModelMaster>>(mod, HttpStatus.OK);
	}
	
	@GetMapping("/ByModelId/{model_id}")
	public ResponseEntity<Optional<ModelMaster>> getAllByModelId(@PathVariable("model_id") int model_id)
	{
		Optional<ModelMaster> mod = null;
		
		try
		{
			mod=model.getAllModelByModelId(model_id);
		}
		catch(Exception e)
		{
			e.getMessage();
		}
		
		return new ResponseEntity<Optional<ModelMaster>>(mod, HttpStatus.OK);
	}
}
