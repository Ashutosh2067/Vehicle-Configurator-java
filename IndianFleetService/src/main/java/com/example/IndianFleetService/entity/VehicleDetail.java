package com.example.IndianFleetService.entity;

import javax.persistence.*;


@Entity
@Table(name = "vehicledetailmasters")
public class VehicleDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ConfiId")
    private int confiId;

    @Column (name="model_id")
    private Integer model_id;
    

    public Integer getModel_id() {
		return model_id;
	}

	public void setModel_id(Integer model_id) {
		this.model_id = model_id;
	}

	@Column(name="comp_id")
    private Integer comp_id;

    public Integer getComp_id() {
		return comp_id;
	}

	public void setComp_id(Integer comp_id) {
		this.comp_id = comp_id;
	}

	@Column(name = "CompType")
    private String compType;

    @Column(name = "IsConfigurable")
    private boolean isConfigurable;

    public int getConfiId() {
        return confiId;
    }

    public void setConfiId(int confiId) {
        this.confiId = confiId;
    }


    public String getCompType() {
        return compType;
    }

    public void setCompType(String compType) {
        this.compType = compType;
    }

    public boolean isConfigurable() {
        return isConfigurable;
    }

    public void setConfigurable(boolean isConfigurable) {
        this.isConfigurable = isConfigurable;
    }
}
