**One to Many and Many to One Relationship**
For Simplicity We are assuming an Employee can belong to one and only one dept.

So Employee to Dept relationsip is Many to One

**How to create many to one relationship**

annotate the many side with below
 a) create an instance of dept(one side of the relationship) class in employee
 b) then annotate that instance as below
@ManyToOne
@JoinColumn(name="joining column name")

Now on the other hand Dept to Employe is a one to many relationship

**How to create one to many relationship**

a) Create list of employee in Dept class
b)Annotate that variable as below

@OneToMany(mappedBy = "department", cascade = CascadeType.ALL) P.N here department is the Department type variable declared in employee class.

Please Note mappedBy column is mandatory here.

**Owner Of the Relationship**

When you persist the owner obect inverse obect also gets persisted automatically. But viz is not true

Now Many side is the owner in most of the time in java point of view.
From DB point of view the table which will have the fk is the owner of the relationship.


**Cascading**
Cascading deals with the whole object graph. Meaning if you want to save dept while saving employee
Then you will have to mention CascadeType.Persist.
There are below cascade types are availale.
Persist
Remove
Marge
ALL
DETACH
REFRESH


These are self explanetory.