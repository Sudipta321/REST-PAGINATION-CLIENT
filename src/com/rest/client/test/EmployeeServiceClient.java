package com.rest.client.test;

import java.net.URI;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.InvocationCallback;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;

import org.glassfish.jersey.client.ClientConfig;
import org.glassfish.jersey.client.ClientResponse;

import com.rest.model.Employee;
import com.rest.model.EmployeeRecord;

public class EmployeeServiceClient {

	public static void main(String[] args) {


		initClient();

	}

	public static void initClient() {
		System.out.println("****Invoking the All Employee Service record****");

		// Obtaining the instance of Client which will be entry point to
		// invoking REST Services.
		Client client = ClientBuilder.newClient();
		// Targeting the RESTful Webserivce we want to invoke by capturing it in
		// WebTarget instance.
		WebTarget target = client
				.target("http://localhost:8082/REST-PAGINATION/rest/employees");

		//Building the request i.e a GET request to the RESTful Webservice defined
	    //by the URI in the WebTarget instance.

		Invocation invocation = target.request(MediaType.APPLICATION_XML)
				.buildGet();

		//Invoking the request to the RESTful API and capturing the Response.
		 Response response = invocation.invoke();
		 System.out.println("------>>>>"+response);

		  //As we know that this RESTful Webserivce returns the XML data which can be unmarshalled
	     //into the instance of Employee by using JAXB.

		EmployeeRecord record = response.readEntity(EmployeeRecord.class);

			    for (Employee employee : record.getEmployee()) {
			      printEmployee(employee);
			    }


	}

/*	private static String joinList(List list) {
	    StringBuilder builder = new StringBuilder();
	    for (String str : list) {
	      builder.append(str).append(",");
	    }
	    return builder.toString().substring(0, builder.length() - 1);
	  }
	*/
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


	private static URI getBaseURI() {
		return UriBuilder.fromUri("http://localhost:8082/REST-PAGINATION")
				.build();
	}

}
