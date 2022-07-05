package com.example.HibernateDemo.Dao;

import com.example.HibernateDemo.Entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class EmployeeDao {


    @Autowired
    private SessionFactory sessionFactory;

    public Session getSession()
    {
        Session session= sessionFactory.getCurrentSession();
        if(session==null)
        {
            sessionFactory.openSession();
        }
        return  session;

    }




    // Save New Employee
    public void addNewEmployee(Employee employee)
    {
        Session session = getSession();
        session.save(employee);
    }

//    get All Employee

    public List<Employee> getAllEmployee()
    {
     Session session=   getSession();
        List employees = session.createCriteria(Employee.class).list();
        return employees;

    }

//    //get Employee by Id
//    public Employee getEmployeeById(Integer eid)
//    {
//
//    }



}
