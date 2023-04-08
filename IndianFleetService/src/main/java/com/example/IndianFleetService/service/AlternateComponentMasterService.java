package com.example.IndianFleetService.service;

import java.util.List;
import com.example.IndianFleetService.entity.AlternateComponentMaster;

public interface AlternateComponentMasterService 
{
	public List<AlternateComponentMaster> getAllAlterComponent();
	public List<AlternateComponentMaster> getAlterComp(int model_id);
	
}
