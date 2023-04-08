package com.example.IndianFleetService.controller;

import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.IndianFleetService.entity.ComponentMaster;
import com.example.IndianFleetService.service.ComponentMasterService;

@RestController
@RequestMapping("/Component")
@CrossOrigin(origins = "http://localhost:3000")
public class ComponetMasterController 
{
	@Autowired
	private ComponentMasterService component;
	
	@GetMapping("/AllComp")
	public ResponseEntity<List<ComponentMaster>> getAllComp()
	{
		List<ComponentMaster> comp = null;
		
		try
		{
			comp=component.getAllComp();
		}
		catch(Exception e)
		{
			e.getMessage();
		}
		
		return new ResponseEntity<List<ComponentMaster>>(comp, HttpStatus.OK);
	}
	@GetMapping("/AllCompByModelId/{model_id}")
	public ResponseEntity<List<ComponentMaster>> getAllCompByModelId(@PathVariable("model_id") int model_id)
	{
		List<ComponentMaster> comp = null;
		
		try
		{
			comp=component.getComponentByModelId(model_id);
		}
		catch(Exception e)
		{
			e.getMessage();
		}
		
		return new ResponseEntity<List<ComponentMaster>>(comp, HttpStatus.OK);
	}
	@GetMapping("/AlterComp/{model_id}")
	public ResponseEntity<List<Map<String, ComponentMaster>>> getAlterCompByModel(@PathVariable("model_id") int model_id)
	{
		List<Map<String, ComponentMaster>> comp = null;
		
		try
		{
			comp=component.getAlterCompByModel(model_id);
		}
		catch(Exception e)
		{
			e.getMessage();
		}
		
		return new ResponseEntity<List<Map<String, ComponentMaster>>>(comp, HttpStatus.OK);
	}
	
	
}
