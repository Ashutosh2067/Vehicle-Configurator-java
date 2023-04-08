package com.example.IndianFleetService.service.impl;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.IndianFleetService.entity.ModelMaster;
import com.example.IndianFleetService.repository.ModelMasterRepository;
import com.example.IndianFleetService.service.ModelMasterService;

@Service
@Transactional
public class ModelMasterServiceimpl implements ModelMasterService {

	@Autowired
	private ModelMasterRepository modelMaster;
	@Override
	public List<ModelMaster> getAllModelMaster() 
	{
		// TODO Auto-generated method stub
		return (List<ModelMaster>)modelMaster.findAll();
	}
	@Override
	public List<ModelMaster> getAllModelByMfgId(int id) {
		// TODO Auto-generated method stub
		return (List<ModelMaster>)modelMaster.getAllModelByMfgId(id);
	}
	@Override
	public Optional<ModelMaster> getAllModelByModelId(int id) {
		// TODO Auto-generated method stub
		return (Optional<ModelMaster>)modelMaster.findById(id);
	}

}
