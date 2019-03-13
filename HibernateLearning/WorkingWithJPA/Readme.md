**JPA OR Java Persistance API**
Jpa provides interfaces to build your entities. Hibernate provides
the implementation. So Hibernate is a JPA provider.
use of JPA is lose coupling with the implementation and making sure you can switch
to any JPA provider of your choice next day.

**How to configure**
1. create META-INF/persistance.xml just like hibernate.cfg.xml file. Please note 
this persistance.xml should be under meta-inf and should be placed under root of the dir.
as maven places every thing under resources under src after build.So we created this meta-inf 
under resources dir.

2. transaction-type="RESOURCE_LOCAL"--> this means you are responsible for creating
entity manager from entitymanagerfactory. when using some app server which provides 
entity manager we can change it.

3.Here is how you create Entity manager
EntityManager em = Persistence.
                createEntityManagerFactory("hello-world").
                createEntityManager();

        EntityTransaction transaction = em.getTransaction();
        em.persist(msg);
        etransaction.commit();
        
**Obect Life Cycle and 1st level cacheing**

//Whenever we create an entity manager, an persistance onntext gets created.
This persistance context have a non shared db connection in itself.
EntityManager em = Persistence.
                createEntityManagerFactory("hello-world").
                createEntityManager();

        EntityTransaction transaction = em.getTransaction();

        try{
            transaction.begin();
            Message msg = new Message("Hello");
            ****WHEN ABOVE LINE GETS EXECUTED, AN OBECT GETS CREATED AT JAVA MEMORY
            AND ITS STATE IS TRANSIENT MEANING IT HAS NOTHING TO DO WITH DB****
            
            
            em.persist(msg);
            
            **WHEN ABOVE LINE GETS EXECUTED, THAT TRANSIENT OBJECT GETS ATTACHED TO
            THE PERSISTANCE CONTEXT.AND ONCE AN OBJECT IS AT THE PERSISTANCE CONTEXT OF
            AN ENTITY MANAGER, IF YOU QUERY THAT OBJECT USING THAT ENTITYMANAGER, IT WILL 
            NOT GO TO DB, RATHER IT WILL PROVIDE IT FROM THE PERSISTANCE CONTEXT. THIS PERSISTANCE
            CONTEXT IS 1ST LEVEL CACHING IN HIBERNATE.
            REMEMBER IF YOU QUERY A DIFFERENT ENTITY MANAGER THAT WILL LEAD TO A DB CALL AND
            RETURNED OBJECT REFERENCE WILL NOT BE SAME.**
            
            transaction.commit();
            
            **HERE DATA GETS LOADED TO DB,BUT WILL ALSO BE THERE AT 1ST LEVEL CACHE**
        }	catch(Exception e) {
        if(transaction != null) { transaction.rollback(); }
        e.printStackTrace();
    }	finally {
        if(em != null) { 
        
        em.close(); 
        **AT THIS LINE ENTITY MANAGER GETS CLOSED MEANING ATTACHED PERSISTANCE CONTEXT ALSO
        GETS CLOSED AND NOW THE msg OBJECT HAS ONLY REFERENCE AT JVM. THIS IS A DETACHED OBECT.
        TO MERGE ANY DETACHED OBJECT TO AN ENTITY MANAGER, CALL MARGE METHODE.**
        }
        
        
        
        ````
        
        
        
        **EAGER AND LAZY LOADING**
        
        1. Consider Student to Guide relationship. its many to one and guide to student is one to many relationship, consider it as 
        bi directional relationship. Now think we are calling em.find method on guide id. think of this an guide may have lots of student
        associated with it. So, by default when we call find on guide hibernate lezily fetch guide obect meaning guide data will be there but not 
        list of students data. its only when you do some operation on the list of student object from guide entity, another db call occurres to get the 
        associated students.(guide.getStudents() will not trigger db call but guide.getStudents().size() will do).
        
        By default in case one to many and many to many relationship, entities are fetched lazily.
        By default for Many to one and one to one relationship, entities are fetched eagerly.meaning if you perform a find method on student id, associated 
        guide will also get loaded.