package com.example.IndianFleetService.service.impl;

import java.util.List;
import java.util.Map;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.IndianFleetService.entity.ComponentMaster;
import com.example.IndianFleetService.repository.ComponentMasterRepository;
import com.example.IndianFleetService.service.ComponentMasterService;

@Service
@Transactional
public class ComponentMasterServiceImpl implements ComponentMasterService {

	@Autowired
	private ComponentMasterRepository component;
	@Override
	public List<ComponentMaster> getAllComp() {
		// TODO Auto-generated method stub
		return (List<ComponentMaster>)component.findAll();
	}
	@Override
	public List<ComponentMaster> getComponentByModelId(int model_id) {
		// TODO Auto-generated method stub
		return (List<ComponentMaster>)component.getComponentByModelId(model_id);
	}
	@Override
	public List<Map<String, ComponentMaster>> getAlterCompByModel(int model_id) {
		// TODO Auto-generated method stub
		return (List<Map<String, ComponentMaster>>)component.getAlterCompByModel(model_id);
	}
}
