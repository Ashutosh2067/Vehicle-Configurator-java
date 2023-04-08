package com.example.IndianFleetService.entity;
import javax.persistence.*;

import org.springframework.lang.NonNull;

import java.util.List;

@Entity
@Table(name = "userdatamasters")
public class UserData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "UserId")
    private int userId;

    @Column(name = "UserName")
    @NonNull
    private String userName;

    @Column(name = "Password")
    @NonNull
    private String password;

    @Column(name = "EmailId")
    @NonNull
    private String emailId;

    @Column(name = "CompanyName")
    @NonNull
    private String companyName;

    @Column(name = "Address")
    @NonNull
    private String address;

    @Column(name = "Telephone")
    @NonNull
    private String telephone;

    @Column(name = "holding")
    @NonNull
    private String holding;

    @OneToMany(mappedBy = "userData", cascade = CascadeType.ALL)
    private List<InvoiceHeader> invoiceHeaders;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getHolding() {
        return holding;
    }

    public void setHolding(String holding) {
        this.holding = holding;
    }

    public List<InvoiceHeader> getInvoiceHeaders() {
        return invoiceHeaders;
    }

    public void setInvoiceHeaders(List<InvoiceHeader> invoiceHeaders) {
        this.invoiceHeaders = invoiceHeaders;
    }
}
