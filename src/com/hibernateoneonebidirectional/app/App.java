package com.hibernateoneonebidirectional.app;

import java.util.Calendar;

import  com.hibernateoneonebidirectional.pojo.Employee;
import  com.hibernateoneonebidirectional.pojo.EmployeeDetails;
import  com.hibernateoneonebidirectional.util.HibernateUtil;

import org.hibernate.Session;

public class App {

	public static void main(String[] args) {
		System.out.println(" ********************* Hibernate One-One Bidirectional (Annotation) *** START ******************* ");
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		Employee employee = new Employee("hanuma");
		EmployeeDetails employeeDetails = new EmployeeDetails();
		employeeDetails.setLocation("kishkinda");
		employeeDetails.setDoj(Calendar.getInstance().getTime());
		employeeDetails.setEmployee(employee);
		employee.setEmployeeDetails(employeeDetails);
		session.save(employee);
		session.getTransaction().commit();
		session.close();
		System.out.println(" ********************* Hibernate One-One Bidirectional (Annotation) *** END ********************* ");
	}

}
