package com.entity.compositKey;

import javax.persistence.*;
import java.util.List;

@Entity
public class ParentClass {

    @Id
    @Embedded
    private CompositKeys compositKeys;
    private String name;

    @OneToMany(mappedBy = "parentClass", cascade = CascadeType.ALL)
    private List<ChildClass> childClass;

    public List<ChildClass> getChildClass() {
        return childClass;
    }

    public void setChildClass(List<ChildClass> childClass) {
        this.childClass = childClass;
    }

    public ParentClass() {
    }

    public ParentClass(CompositKeys compositKeys, String name) {
        this.compositKeys = compositKeys;
        this.name = name;
    }

    public CompositKeys getCompositKeys() {
        return compositKeys;
    }

    public void setCompositKeys(CompositKeys compositKeys) {
        this.compositKeys = compositKeys;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
