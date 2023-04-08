package com.example.IndianFleetService.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "modelmaster")
public class ModelMaster {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="model_id")
    private Integer model_id;

    private String modelName;

    
    @Column(name="mfg_id")
    private Integer mfg_id;

    private Integer minQty;

    private Double basicPrice;

    private String imagePath;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name="model_id", referencedColumnName="model_id")
    private List<VehicleDetail> vehicleDetails;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name="model_id", referencedColumnName="model_id")
    private List<AlternateComponentMaster> alternateComponentsMasters;

    public Integer getModelId() {
        return model_id;
    }

    public void setModelId(Integer model_id) {
        this.model_id = model_id;
    }

    public String getModelName() {
        return modelName;
    }

    public Integer getMfg_id() {
		return mfg_id;
	}

	public void setMfg_id(Integer mfg_id) {
		this.mfg_id = mfg_id;
	}

	public void setModelName(String modelName) {
        this.modelName = modelName;
    }


    public Integer getMinQty() {
        return minQty;
    }

    public void setMinQty(Integer minQty) {
        this.minQty = minQty;
    }

    public Double getBasicPrice() {
        return basicPrice;
    }

    public void setBasicPrice(Double basicPrice) {
        this.basicPrice = basicPrice;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public List<VehicleDetail> getVehicleDetails() {
        return vehicleDetails;
    }

    public void setVehicleDetails(List<VehicleDetail> vehicleDetails) {
        this.vehicleDetails = vehicleDetails;
    }

    public List<AlternateComponentMaster> getAlternateComponentsMasters() {
        return alternateComponentsMasters;
    }

    public void setAlternateComponentsMasters(List<AlternateComponentMaster> alternateComponentsMasters) {
        this.alternateComponentsMasters = alternateComponentsMasters;
    }
}
