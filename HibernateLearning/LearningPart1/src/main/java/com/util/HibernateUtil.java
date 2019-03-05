package com.util;

import com.entity.Employee;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;


public class HibernateUtil {
    private static final SessionFactory sessionFactory = buildSessionFactory();

    private static SessionFactory buildSessionFactory(){
        Configuration config = new Configuration().configure("hibernate.cfg.xml");
        config.addAnnotatedClass(Employee.class);
        return config.buildSessionFactory(new StandardServiceRegistryBuilder().
                applySettings(config.getProperties()).build());
    }

    public static SessionFactory getSessionFactory(){
        return sessionFactory;
    }
}
