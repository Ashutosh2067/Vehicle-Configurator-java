package com.example.IndianFleetService.entity;

import javax.persistence.*;


@Entity
@Table(name = "alternatecomponentmasters")
public class AlternateComponentMaster {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "AltId")
    private int altId;
    
    @Column (name="model_id")
    private Integer model_id;
    
    @Column(name="comp_id")
    private Integer comp_id;

    @Column(name = "AltCompId")
    private Integer altCompId;

    @Column(name = "AltCompType")
    private String altCompType;
    

	public Integer getComp_id()
    {
		return comp_id;
	}

	public void setComp_id(Integer comp_id) {
		this.comp_id = comp_id;
	}

	@Column(name = "DeltaPrice")
    private double deltaPrice;

    public int getAltId() {
        return altId;
    }

    public void setAltId(int altId) {
        this.altId = altId;
    }
    
    public Integer getModel_id() {
		return model_id;
	}

	public void setModel_id(Integer model_id) {
		this.model_id = model_id;
	}

	public Integer getAltCompId() {
        return altCompId;
    }

    public void setAltCompId(Integer altCompId) {
        this.altCompId = altCompId;
    }

    public String getAltCompType() {
        return altCompType;
    }

    public void setAltCompType(String altCompType) {
        this.altCompType = altCompType;
    }

    public double getDeltaPrice() {
        return deltaPrice;
    }

    public void setDeltaPrice(double deltaPrice) {
        this.deltaPrice = deltaPrice;
    }
}
