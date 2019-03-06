1. ojdbc is a third party jar. So one need to install it to local maven repo.

Steps:
1. place the jar at project root
2. run below command

mvn install:install-file -Dfile=ojdbc6.jar -DgroupId=oracle -DartifactId=ojdbc6 Dversion=11.2.0.3 -Dpackaging=jar

#logging in Hibernate
1. Hibernate internally usues SLF4J.
2. Slf4j can be bounded to other logging framework loke log4j and then configure that framework to work with.
3. here in log4.properties for below line we get to see the binding parameters of a sql statement.


log4j.logger.org.hibernate.type.descriptor.sql.BasicBinder=TRACE

#Hibernate Basics.
1. define entity class and mark with @Entity
2. load config file using below line and build session factory

Configuration config = new Configuration().configure("hibernate.cfg.xml");
        config.addAnnotatedClass(Employee.class);
        return config.buildSessionFactory(new StandardServiceRegistryBuilder().
                applySettings(config.getProperties()).build());
                
3. for annotation based entity configuration add below line

config.addAnnotatedClass(Employee.class);

4. open session from sessionfactory
5. begine transaction from session
6. do session.get or save or set etc to persist or get obect
7. commit transaction. at this stage auto dirty checking is being done by Hibernate.