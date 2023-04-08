package com.example.IndianFleetService.service;

import java.util.List;
import java.util.Optional;

import com.example.IndianFleetService.entity.ModelMaster;

public interface ModelMasterService 
{
	public List<ModelMaster> getAllModelMaster();
	public List<ModelMaster> getAllModelByMfgId(int id);
	public Optional<ModelMaster> getAllModelByModelId(int id);
}
