package com.example.IndianFleetService.repository;

import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.IndianFleetService.entity.MfgMaster;

@Repository
public interface MfgMasterRepository extends CrudRepository<MfgMaster, Integer> 
{
	
	
	@Query(value="SELECT  m.mfg_name, n.model_name, n.basic_price, n.image_path FROM mfgmasters m JOIN modelmaster n WHERE n.model_id=:model_id AND n.mfg_id=m.mfg_id", nativeQuery=true)
	public List<Map<String, MfgMaster>> getMfgNameAndModelName(@Param("model_id") int model_id);
	
	@Query(value="select m from MfgMaster m where m.seg_id = :seg_id")
	public List<MfgMaster> getAllMfgBySegId(@Param("seg_id") int seg_id);
}
