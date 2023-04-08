package com.example.IndianFleetService.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.IndianFleetService.entity.SegmentMaster;
import com.example.IndianFleetService.repository.SegmentMasterRepository;
import com.example.IndianFleetService.service.SegmentMasterService;

@Service
@Transactional
public class SegmentMasterServiceImpl implements SegmentMasterService {

	@Autowired
	private SegmentMasterRepository segment;
	
	@Override
	public List<SegmentMaster> getAllSegmentMasters() 
	{
		// TODO Auto-generated method stub
		
		return (List<SegmentMaster>) segment.findAll();
	}

}
