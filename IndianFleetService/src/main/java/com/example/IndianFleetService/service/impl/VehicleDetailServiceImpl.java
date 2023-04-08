package com.example.IndianFleetService.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.IndianFleetService.entity.VehicleDetail;
import com.example.IndianFleetService.repository.VehicleDetailMasterRepository;
import com.example.IndianFleetService.service.VehicleDetailMasterService;

@Service
@Transactional
public class VehicleDetailServiceImpl implements VehicleDetailMasterService
{
	@Autowired
	private VehicleDetailMasterRepository vehicle;
	@Override
	public List<VehicleDetail> getAllVehicleDetail() 
	{
		// TODO Auto-generated method stub
		return (List<VehicleDetail>)vehicle.findAll();
	}

}
