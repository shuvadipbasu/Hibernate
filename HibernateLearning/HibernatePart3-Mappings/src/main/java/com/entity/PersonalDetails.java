package com.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
public class PersonalDetails {
    @Id
    private String passPortNo;
    private Date expiryDate;
    private String fullName;
    private String panNo;

    @Embedded
    private Address address;

    @OneToOne(mappedBy = "personalDetails")
    private Employee employee;

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public PersonalDetails() {
    }

    public PersonalDetails(String passPortNo, Date expiryDate, String fullName, String panNo) {
        this.passPortNo = passPortNo;
        this.expiryDate = expiryDate;
        this.fullName = fullName;
        this.panNo = panNo;
    }

    public String getPassPortNo() {
        return passPortNo;
    }

    public void setPassPortNo(String passPortNo) {
        this.passPortNo = passPortNo;
    }

    public Date getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(Date expiryDate) {
        this.expiryDate = expiryDate;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPanNo() {
        return panNo;
    }

    public void setPanNo(String panNo) {
        this.panNo = panNo;
    }

    @Override
    public String toString() {
        return "PersonalDetails{" +
                "passPortNo='" + passPortNo + '\'' +
                ", expiryDate=" + expiryDate +
                ", fullName='" + fullName + '\'' +
                ", panNo='" + panNo + '\'' +
                ", address=" + address +

                '}';
    }
}
