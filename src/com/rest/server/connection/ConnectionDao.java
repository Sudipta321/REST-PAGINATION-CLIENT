package com.rest.server.connection;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import javax.ws.rs.GET;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Configuration;
import javax.ws.rs.core.MediaType;

import com.rest.model.Employee;
import com.rest.model.EmployeeRecord;

public class ConnectionDao  {
	

	
	ConnectionFactory conn =ConnectionFactory.getInstance();
	
	@GET
	@Produces(MediaType.APPLICATION_XML + ";charset=utf-8")
	public List<Employee> viewAllEmployees(
			@QueryParam("offset") Integer offset, 
			@QueryParam("limit") Integer limit)
	{
		EmployeeRecord record = conn.initClient().readEntity(EmployeeRecord.class);
		 if(offset != null){
			
			 }
		return null;     
    }
	
	
	 
   /* for (Employee employee : record.getEmployee()) {
      //printEmployee(employee);
    }*/
	
	
	private static void printEmployee( Employee employee ) {
	    System.out.println("Employee Name : " + employee.getName());
	    System.out.println("Employee Id : " + employee.getId());
	    System.out.println("Employee Age :" + employee.getAge());
	    System.out.println("Employee Organization : " + employee.getOrganization());
	    System.out.println("Employee Exp : " + employee.getExperience());
	    System.out.println("Employee Skill : " + employee.getSkill());
	    System.out.println("Employee Address : " + employee.getAddress());
	    
	    /*System.out.println("Reviews: ");
	    for (Review review : book.reviews) {
	      System.out.println(review.content + " by " + review.author + " posted on " + review.getPostedOn());
	    }*/
	  }



}
