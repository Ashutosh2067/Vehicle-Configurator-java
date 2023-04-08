package com.example.IndianFleetService.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.IndianFleetService.entity.VehicleDetail;

public interface VehicleDetailMasterRepository extends JpaRepository<VehicleDetail, Integer> {

}
