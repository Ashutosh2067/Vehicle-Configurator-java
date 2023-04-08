package com.example.IndianFleetService.service;

import java.util.List;
import java.util.Map;
import com.example.IndianFleetService.entity.ComponentMaster;


public interface ComponentMasterService 
{
	public List<ComponentMaster> getAllComp();
	public List<ComponentMaster> getComponentByModelId(int model_id);
	public List<Map<String, ComponentMaster>> getAlterCompByModel(int model_id);	
}
