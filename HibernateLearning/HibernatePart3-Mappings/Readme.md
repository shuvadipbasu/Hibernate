**** One To One Mapping ****
Consider Employee to Personal Details relationship 1 employee's personal details
corresponds to one single personal details. Causing one to one relationship

 _How to achieve_
 
 1. Chose the owner. Here I chose employee.
 2. make a has a relationship from owner to other end. Here I created a personalDetails
    variable at Employee class
 3. annotate as below
    @OneToOne(cascade = CascadeType.ALL)
        @JoinColumn(name = "passPortNo") _put child pk name_
 
 4. Now you can make the relationship as bidirectional by keeping an object of the owner
    to the leaser class and annotate with mappedBy like below.
    @OneToOne(mappedBy = "personalDetails")
    
**** @Embeddable and @Embedded ****
Consider Personal Details and Address relationship. Address only exists if personal details exists.
it is the part of personal details. So only single table personal details and address(columns of address)
at db side. but at java side you can decouple it. using above annotations.

** Many To Many Relationship **
Employee to Skills. 1 emp can have multiple skills and at the same time one skill can belong to 
multiple employees. making it many to many.

Chose Owner and leaser. I chose Employee as owner.
then annotate as below
Owner class annotation.
** _Remember join table declaration should be at the owner side_ **
@ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "EMPLOYEE_SKILLS_MAP",
            joinColumns = {@JoinColumn(name = "emp_Id")},
            inverseJoinColumns = {@JoinColumn(name = "skill_Id")}


Leaser class annitations
@ManyToMany(mappedBy = "skills")


****_ PLEASE DONT FORGET TO PROVIDE NO ARGUMENT CONSTRUCTOR AT THE ENTITIES IN ANY RELATIONSHIP_****

**Mapping Collections of simple value type**
1. Here we have used employee and employee access. its simple one to many relationship. But
we can map the access to collections.

we need to do below.
a. declare a collection of simple value type
b) annotate that with below
        @ElementCollection
        @CollectionTable( name = "EMPLOYEE_ACCESS",
            joinColumns = @JoinColumn(name = "EMP_ID"))
        @Column(name = "ODC_NAME")
        
 **Mapping Enum Types**
 1. create an enum clas.
 2. in emplyee have the obj of that enum type
 3. annotate as below
 
 @Enumerated(EnumType.STRING)
     @Column(name = "STATUS")
     private EmployeeStatus employeeStatus;
     
 **Composit Keys**
 1.Create a class implemnting serializable and containing all keys. We created class CompositKeys.@Embedable
 2. Create Parent class where these key will be there.
 3. have a reference of CompositKey to parent class. and annotate that with @Embeded and @Id(Now your composit key added)
 
 **Composite Foreign keys**
   1. extending above example clreate Child class.
   2. create ref of Parent class at child.
   3. annotate that ref with below. Remember in child we want to fks. So, we will use mappedby at parent class.
   @ManyToOne(cascade = CascadeType.ALL)
       @JoinColumns({@JoinColumn(name = "id1", referencedColumnName = "id1"),
               @JoinColumn(name = "id2", referencedColumnName = "id2")
       })
   4. At parent class add @OneToMany(mappedBy="clientClass")
   
   Dont forget to add these new classes to HibernateUtil.java.
   
   Done.
 