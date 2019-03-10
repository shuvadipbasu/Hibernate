package com.util;

import com.entity.Employee;
import com.entity.PersonalDetails;
import com.entity.Skills;
import com.entity.compositKey.ChildClass;
import com.entity.compositKey.ParentClass;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;


public class HibernateUtil {
    private static final SessionFactory sessionFactory = buildSessionFactory();

    private static SessionFactory buildSessionFactory(){
        Configuration config = new Configuration().configure("hibernate.cfg.xml");
        config.addAnnotatedClass(Skills.class);
        config.addAnnotatedClass(PersonalDetails.class);
        config.addAnnotatedClass(Employee.class);
        config.addAnnotatedClass(ParentClass.class);
        config.addAnnotatedClass(ChildClass.class);
       // config.addAnnotatedClass(Skills.class);
        return config.buildSessionFactory(new StandardServiceRegistryBuilder().
                applySettings(config.getProperties()).build());
    }

    public static SessionFactory getSessionFactory(){
        return sessionFactory;
    }
}
