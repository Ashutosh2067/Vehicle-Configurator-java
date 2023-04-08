package com.example.IndianFleetService.repository;

import java.util.List;
import java.util.Map;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.example.IndianFleetService.entity.ComponentMaster;


@Repository
public interface ComponentMasterRepository extends CrudRepository<ComponentMaster, Integer> 
{
	@Query(value="SELECT c.comp_id, c.comp_Name, v.comp_type FROM componentmastermasters c JOIN vehicledetailmasters v where v.model_id = :model_id and c.comp_id = v.comp_id", nativeQuery=true)
	public List<ComponentMaster> getComponentByModelId(@Param("model_id") int model_id);
	
	@Query(value="select a.comp_id as compID, a.model_id as modelId, a.alt_comp_id as altCompId, c.comp_name as compName, a.delta_price as deltaPrice, alt_comp_type as altCompType from componentmastermasters c join alternatecomponentmasters a where a.alt_comp_id=c.comp_id and a.model_id=:model_id", nativeQuery=true)
	public List<Map<String, ComponentMaster>> getAlterCompByModel(@Param("model_id") int model_id);
	
}	

