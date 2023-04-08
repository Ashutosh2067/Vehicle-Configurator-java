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

import com.example.IndianFleetService.entity.MfgMaster;
import com.example.IndianFleetService.service.MfgMasterService;

@RestController
@RequestMapping("/MfgMaster")
@CrossOrigin(origins = "http://localhost:3000")
public class MfgMasterController 
{
	@Autowired
	private MfgMasterService mfgMaster;
	@GetMapping("/AllMfg")
	public ResponseEntity<List<MfgMaster>> getAllMfgMaster()
	{
		List<MfgMaster> mfg = null;
		
		try
		{
			mfg=mfgMaster.getAllMfgMaster();
		}
		catch(Exception e)
		{
			e.getMessage();
		}
		
		return new ResponseEntity<List<MfgMaster>>(mfg, HttpStatus.OK);
	}
	
	@GetMapping("/AllMfgById/{seg_id}")
	public ResponseEntity<List<MfgMaster>> getAllMfgBySegId(@PathVariable("seg_id") int seg_id)
	{
		List<MfgMaster> mfg = null;
		
		try
		{
			mfg=mfgMaster.getAllMfgBySegId(seg_id);
		}
		catch(Exception e)
		{
			e.getMessage();
		}
		
		return new ResponseEntity<List<MfgMaster>>(mfg, HttpStatus.OK);
	}
	@GetMapping("/getMfgNameAndModelName/{model_id}")
	public ResponseEntity<List<Map<String, MfgMaster>>> getMfgNameAndModelName(@PathVariable("model_id") int model_id)
	{
		List<Map<String, MfgMaster>> mfg = null;
		
		try
		{
			mfg=mfgMaster.getMfgNameAndModelName(model_id);
		}
		catch(Exception e)
		{
			e.getMessage();
		}
		
		return new ResponseEntity<List<Map<String, MfgMaster>>>(mfg, HttpStatus.OK);
	}
}
