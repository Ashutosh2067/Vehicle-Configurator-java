package com.example.IndianFleetService.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.IndianFleetService.entity.SegmentMaster;
import com.example.IndianFleetService.service.SegmentMasterService;

@RestController
@RequestMapping("/Segment")
@CrossOrigin(origins = "http://localhost:3000")
public class SegmentMasterController
{
	@Autowired
	private SegmentMasterService segment;
	
	@GetMapping("/Allseg")
	public ResponseEntity<List<SegmentMaster>> getAllSegmentMaster()
	{
		List<SegmentMaster> seg = null;
		
		try
		{
			seg=segment.getAllSegmentMasters();
		}
		catch(Exception e)
		{
			e.getMessage();
		}
		
		return new ResponseEntity<List<SegmentMaster>>(seg, HttpStatus.OK);
	}
}
