package com.example.IndianFleetService.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.IndianFleetService.entity.AlternateComponentMaster;
import com.example.IndianFleetService.repository.AlternateComponentMasterRepository;
import com.example.IndianFleetService.service.AlternateComponentMasterService;

@Service
@Transactional
public class AlternateComponentMasterServiceImpl implements AlternateComponentMasterService {

	@Autowired
	private AlternateComponentMasterRepository altComp;
	@Override
	public List<AlternateComponentMaster> getAllAlterComponent() {
		// TODO Auto-generated method stub
		return (List<AlternateComponentMaster>)altComp.findAll();
	}
	@Override
	public List<AlternateComponentMaster> getAlterComp(int model_id) {
		// TODO Auto-generated method stub
		return null;//(List<AlternateComponentMaster>)altComp.getAlterComp(model_id);
	}
	

}
