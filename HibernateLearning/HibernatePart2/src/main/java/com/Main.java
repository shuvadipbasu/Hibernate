package com;

import com.entity.Department;
import com.entity.Employee;
import com.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.LinkedList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        Session ses = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = ses.beginTransaction();


//        Department dpt = new Department("Test");
//        Employee emp = new Employee("Shuva1","Basu1",1L,"9903246300");
//        emp.setDepartment(dpt);

        //Employee emp = new Employee("Shuvadip1","Basu",Long.valueOf(3),"9903246300");
//        Department dpt = new Department("Test1");
//        Employee emp = new Employee("Shuva1","Basu1",11L,"9903246300");
//        emp.setDepartment(dpt);
//
//        List<Employee> emps = new LinkedList<Employee>();
//        emps.add(emp);
//        dpt.setEmployees(emps);
        Employee emp = ses.get(Employee.class,1L);
        Department dpt = ses.get(Department.class,3L);

        emp.setDepartment(dpt);
        ses.save(emp);
        tx.commit();
        ses.close();

    }
}
