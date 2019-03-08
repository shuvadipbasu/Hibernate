package com.entity;

import javax.naming.Name;
import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Employee {
    @Id
    private Long empId;
    private String fName;
    private String lName;


    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "passPortNo")
    private PersonalDetails personalDetails;

    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "EMPLOYEE_SKILLS_MAP",
            joinColumns = {@JoinColumn(name = "emp_Id")},
            inverseJoinColumns = {@JoinColumn(name = "skill_Id")}

    )
    private Set<Skills> skills = new HashSet<Skills>();


   public PersonalDetails getPersonalDetails() {
        return personalDetails;
    }

   public void setPersonalDetails(PersonalDetails personalDetails) {
        this.personalDetails =personalDetails;
}

    public Set<Skills> getSkills() {
        return skills;
    }

    public void setSkills(Set<Skills> skills) {
        this.skills = skills;
    }

    public Employee() {
    }


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

    @Override
    public String toString() {
        return "Employee{" +
                "empId=" + empId +
                ", fName='" + fName + '\'' +
                ", lName='" + lName + '\'' +
                ", personalDetails=" + personalDetails +
                ", skills=" + skills +
                ", mobileNo='" + mobileNo + '\'' +
                '}';
    }
}
