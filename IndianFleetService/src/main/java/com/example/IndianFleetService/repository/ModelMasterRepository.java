package com.example.IndianFleetService.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.example.IndianFleetService.entity.ModelMaster;

@Repository
public interface ModelMasterRepository extends CrudRepository<ModelMaster, Integer> 
{
	@Query(value="select M from ModelMaster M where M.mfg_id = :mfg_id")
	public List<ModelMaster> getAllModelByMfgId(@Param("mfg_id") int id);
}
