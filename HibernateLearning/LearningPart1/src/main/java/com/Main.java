package com;

import com.entity.Employee;
import com.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class Main {
    public static void main(String[] args) {

        Session ses = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = ses.beginTransaction();

        Employee emp = new Employee("Shuvadip1","Basu",Long.valueOf(3),"9903246300");

        ses.save(emp);
        tx.commit();
        ses.close();

    }
}
