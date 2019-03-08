package com.entity;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
public class Skills {

    @Id
    //@GeneratedValue(strategy = GenerationType.AUTO)
    private Long skillId;
    private String SkillName;

    @ManyToMany(mappedBy = "skills")
    Set<Employee> employees;

    public Skills() {
    }

    public Skills(Long skillId, String skillName) {
        this.skillId = skillId;
        SkillName = skillName;
    }

    public Long getSkillId() {
        return skillId;
    }

    public void setSkillId(Long skillId) {
        this.skillId = skillId;
    }

    public String getSkillName() {
        return SkillName;
    }

    public void setSkillName(String skillName) {
        SkillName = skillName;
    }

    public Set<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(Set<Employee> employees) {
        this.employees = employees;
    }

    @Override
    public String toString() {
        return "Skills{" +
                "skillId=" + skillId +
                ", SkillName='" + SkillName + '\''+
                '}';
    }
}
