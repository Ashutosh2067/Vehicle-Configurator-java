package com.example.IndianFleetService.service;

import java.util.List;
import java.util.Map;
import com.example.IndianFleetService.entity.MfgMaster;

public interface MfgMasterService 
{
	 public List<MfgMaster> getAllMfgMaster();
	 public List<MfgMaster> getAllMfgBySegId(int seg_id);
	 public List<Map<String, MfgMaster>> getMfgNameAndModelName(int model_id);
}
