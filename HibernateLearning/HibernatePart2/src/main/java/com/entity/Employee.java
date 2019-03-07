package com.entity;

import javax.persistence.*;

@Entity
public class Employee {
    @Id
    private Long empId;
    private String fName;
    private String lName;

    public Employee() {
    }

    @Override
    public String toString() {
        return "Employee{" +
                "empId=" + empId +
                ", fName='" + fName + '\'' +
                ", lName='" + lName + '\'' +
                ", department=" + department +
                ", mobileNo='" + mobileNo + '\'' +
                '}';
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id")
    private Department department;

    private String mobileNo;

    public Employee(String fName, String lName, Long empId, String mobileNo) {
        this.fName = fName;
        this.lName = lName;
        this.empId = empId;
        this.mobileNo = mobileNo;
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public Long getEmpId() {
        return empId;
    }

    public void setEmpId(Long empId) {
        this.empId = empId;
    }

    public String getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }
}
