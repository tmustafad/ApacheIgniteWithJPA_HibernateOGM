package com.ignite.jpa.MainIgnite_jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.ignite.jpa.domain.Department;
import com.ignite.jpa.domain.Employee;

public class StartApp 
{
	
	
	
    public static void main( String[] args )
    {
    	 EntityManagerFactory emf = Persistence.createEntityManagerFactory("igniteWithJpa");
         EntityManager em =  emf.createEntityManager();
         em.getTransaction().begin();
         Department dept= new Department();
         dept.setName("IT");
         em.persist(dept);
//         Employee emp = new Employee();
//         emp.setName("Turkmen");
//         emp.setDepartment(dept);
//         em.persist(emp);
//         em.getTransaction().commit();
//         Long empId = emp.getId();
//         // query
//         Employee turkmen =  em.find(Employee.class, empId);
//         System.out.println("Turkmen dept  =>"+ turkmen.getName());
         em.close();
    }
}
