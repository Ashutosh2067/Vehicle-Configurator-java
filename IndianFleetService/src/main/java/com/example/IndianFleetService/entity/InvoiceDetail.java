package com.example.IndianFleetService.entity;
import javax.persistence.*;

@Entity
@Table(name = "invoicedetailmasters")
public class InvoiceDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "invoice_detail_id")
    private int invoiceDetailId;

    @ManyToOne
    @JoinColumn(name = "invoice_id")
    private InvoiceHeader invoiceHeader;

    @Column(name = "vehicle_description")
    private String vehicleDescription;

    @Column(name = "alt_comp_id")
    private Integer altCompId;

    public int getInvoiceDetailId() {
        return invoiceDetailId;
    }

    public void setInvoiceDetailId(int invoiceDetailId) {
        this.invoiceDetailId = invoiceDetailId;
    }

    public InvoiceHeader getInvoiceHeader() {
        return invoiceHeader;
    }

    public void setInvoiceHeader(InvoiceHeader invoiceHeader) {
        this.invoiceHeader = invoiceHeader;
    }

    public String getVehicleDescription() {
        return vehicleDescription;
    }

    public void setVehicleDescription(String vehicleDescription) {
        this.vehicleDescription = vehicleDescription;
    }

    public Integer getAltCompId() {
        return altCompId;
    }

    public void setAltCompId(Integer altCompId) {
        this.altCompId = altCompId;
    }

}
