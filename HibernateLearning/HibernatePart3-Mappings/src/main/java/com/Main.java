package com;

import com.entity.*;
import com.entity.compositKey.ChildClass;
import com.entity.compositKey.CompositKeys;
import com.entity.compositKey.ParentClass;
import com.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        Main mn = new Main();
        //mn.createEmployee();
        //System.err.println("Employee Saved! lets see the record");
        //mn.showEmployee(114L);

        mn.tesetCompositeKey();

        System.err.println("Parent and child got saved !!");
    }

    public void createEmployee(){
        Session ses = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = ses.beginTransaction();

        Employee emp = new Employee("Shuva12","Basu12",114L,"9903246300");
        Address address = new Address("700118","15","");
        PersonalDetails personalDetails = new PersonalDetails("l662010",new Date(),"test","test");
        personalDetails.setAddress(address);

        Skills skills1 = new Skills( 7L, "JAVA1");
        Skills skills2 = new Skills(8L, ".NET2");

        List<String> access = Arrays.asList("ODC1","ODC2");
        emp.setAccssibleODC(access);


        emp.getSkills().add(skills1);
        emp.getSkills().add(skills2);

        emp.setPersonalDetails(personalDetails);
        emp.setEmployeeStatus(EmployeeStatus.FULL_TIME);

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

    public void tesetCompositeKey(){
        Session ses = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = ses.beginTransaction();

        CompositKeys compositKeys = new CompositKeys(1L,"HELLO");
        ParentClass parentClass = new ParentClass(compositKeys,"some Name");

        ChildClass childClass = new ChildClass("child",parentClass);

        ses.persist(childClass);

        tx.commit();
        ses.close();
    }


}
