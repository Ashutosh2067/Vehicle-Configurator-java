package com.example.IndianFleetService.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "mfgmasters")
public class MfgMaster {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="mfg_id")
    private Integer mfg_id;

    @Column(name="mfg_name")
    private String mfgName;

    @Column(name="seg_id")
    private Integer seg_id;
    
    public Integer getSeg_id() {
		return seg_id;
	}

	public void setSeg_id(Integer seg_id) {
		this.seg_id = seg_id;
	}


    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name="mfg_id", referencedColumnName="mfg_id")
    private List<ModelMaster> modelMasters;

    public Integer getMfgId() {
        return mfg_id;
    }

    public void setMfgId(Integer mfgId) {
        this.mfg_id = mfgId;
    }

    public String getMfgName() {
        return mfgName;
    }

    public void setMfgName(String mfgName) {
        this.mfgName = mfgName;
    }

    public List<ModelMaster> getModelMasters() {
        return modelMasters;
    }

    public void setModelMasters(List<ModelMaster> modelMasters) {
        this.modelMasters = modelMasters;
    }
}
