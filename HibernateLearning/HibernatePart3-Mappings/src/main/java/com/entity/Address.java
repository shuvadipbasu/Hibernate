package com.entity;

import javax.persistence.Embeddable;
import javax.persistence.Id;

@Embeddable
public class Address {
    private String zipCode;
    private String houseNo;
    private String state;

    public Address() {
    }

    public Address(String zipCode, String houseNo, String state) {
        this.zipCode = zipCode;
        this.houseNo = houseNo;
        this.state = state;
    }



    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getHouseNo() {
        return houseNo;
    }

    public void setHouseNo(String houseNo) {
        this.houseNo = houseNo;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "Address{" +
                "zipCode='" + zipCode + '\'' +
                ", houseNo='" + houseNo + '\'' +
                ", state='" + state + '\'' +
                '}';
    }
}
