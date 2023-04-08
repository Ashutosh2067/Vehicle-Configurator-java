package com.example.IndianFleetService.service.impl;

import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.IndianFleetService.entity.MfgMaster;
import com.example.IndianFleetService.repository.MfgMasterRepository;
import com.example.IndianFleetService.service.MfgMasterService;

@Service
@Transactional
public class MfgMasterServiceImpl implements MfgMasterService {

	@Autowired
	private MfgMasterRepository mfg;
	@Override
	public List<MfgMaster> getAllMfgMaster() 
	{
		
		return (List<MfgMaster>)mfg.findAll();
	}
	@Override
	public List<MfgMaster> getAllMfgBySegId(int seg_id) {
		// TODO Auto-generated method stub
		return (List<MfgMaster>)mfg.getAllMfgBySegId(seg_id);
	}
	@Override
	public List<Map<String, MfgMaster>> getMfgNameAndModelName(int model_id) {
		// TODO Auto-generated method stub
		return (List<Map<String, MfgMaster>>)mfg.getMfgNameAndModelName(model_id);
	}
	

}
