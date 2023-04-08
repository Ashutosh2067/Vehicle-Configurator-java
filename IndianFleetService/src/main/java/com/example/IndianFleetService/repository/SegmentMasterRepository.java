package com.example.IndianFleetService.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.IndianFleetService.entity.SegmentMaster;

@Repository
public interface SegmentMasterRepository extends CrudRepository<SegmentMaster, Integer> 
{
	
}
