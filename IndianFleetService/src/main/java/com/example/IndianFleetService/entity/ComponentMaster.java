package com.example.IndianFleetService.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;



@Entity
@Table(name = "componentmastermasters")
public class ComponentMaster {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "comp_id")
    private int comp_id;

    @Column(name = "compName")
    private String compName;

    @OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name="comp_id" ,referencedColumnName="comp_id" )
    private List<AlternateComponentMaster> alternateComponentMasters = new ArrayList<>();

    @OneToMany(fetch = FetchType.LAZY)
	@JoinColumn(name="comp_id" ,referencedColumnName="comp_id" )
    private List<VehicleDetail> vehicleDetails = new ArrayList<>();

    public int getCompId() {
        return comp_id;
    }

    public void setCompId(int compId) {
    	this.comp_id = compId;
    }

    public String getCompName() {
        return compName;
    }

    public void setCompName(String compName) {
        this.compName = compName;
    }

    public List<AlternateComponentMaster> getAlternateComponentMasters() {
        return alternateComponentMasters;
    }

    public void setAlternateComponentMasters(List<AlternateComponentMaster> alternateComponentMasters) {
        this.alternateComponentMasters = alternateComponentMasters;
    }

	    public List<VehicleDetail> getVehicleDetails() {
	        return vehicleDetails;
	    }
	
	    public void setVehicleDetails(List<VehicleDetail> vehicleDetails) {
	        this.vehicleDetails = vehicleDetails;
	    }
}
