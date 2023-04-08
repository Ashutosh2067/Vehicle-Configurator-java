package com.example.IndianFleetService.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "segmentmaster")
public class SegmentMaster {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "seg_id")
    private Integer seg_id;

    @Column(name = "seg_name")
    private String segName;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name="seg_id", referencedColumnName="seg_id")
    private List<MfgMaster> mfgMasters;

    public Integer getSegId() {
        return seg_id;
    }

    public void setSegId(Integer segId) {
        this.seg_id = segId;
    }

    public String getSegName() {
        return segName;
    }

    public void setSegName(String segName) {
        this.segName = segName;
    }

    public List<MfgMaster> getMfgMasters() {
        return mfgMasters;
    }

    public void setMfgMasters(List<MfgMaster> mfgMasters) {
        this.mfgMasters = mfgMasters;
    }

    
}
