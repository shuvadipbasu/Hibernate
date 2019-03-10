package com.entity.compositKey;

import javax.annotation.Generated;
import javax.persistence.*;

@Entity
public class ChildClass {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumns({@JoinColumn(name = "id1", referencedColumnName = "id1"),
            @JoinColumn(name = "id2", referencedColumnName = "id2")
    })
    private ParentClass parentClass;

    public ChildClass() {
    }

    public ChildClass( String name, ParentClass parentClass) {

        this.name = name;
        this.parentClass = parentClass;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ParentClass getParentClass() {
        return parentClass;
    }

    public void setParentClass(ParentClass parentClass) {
        this.parentClass = parentClass;
    }
}
