package com;

import com.entity.Address;
import com.entity.Employee;
import com.entity.PersonalDetails;
import com.entity.Skills;
import com.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        Main mn = new Main();
        mn.createEmployee();

        System.err.println("Employee Saved! lets see the record");

        mn.showEmployee(112L);
    }

    public void createEmployee(){
        Session ses = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = ses.beginTransaction();

        Employee emp = new Employee("Shuva12","Basu12",112L,"9903246300");
        Address address = new Address("700116","15","");
        PersonalDetails personalDetails = new PersonalDetails("l662008",new Date(),"test","test");
        personalDetails.setAddress(address);

        Skills skills1 = new Skills( 3L, "JAVA1");
        Skills skills2 = new Skills(4L, ".NET2");


        emp.getSkills().add(skills1);
        emp.getSkills().add(skills2);

        emp.setPersonalDetails(personalDetails);

        //noe save the whole obect graph
        ses.persist(emp);

        tx.commit();
        ses.close();
    }

    public void showEmployee(Long Id){
        Session ses = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = ses.beginTransaction();

        Employee emp = ses.get(Employee.class,112L);

        System.err.println(emp);
    }
}
