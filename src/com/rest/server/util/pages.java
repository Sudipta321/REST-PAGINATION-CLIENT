package com.rest.server.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.net.URL;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.transform.stream.StreamSource;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.event.AjaxBehaviorEvent;

import com.rest.model.Employee;
import com.rest.model.EmployeeAddress;
import com.rest.model.EmployeeRecord;

@ManagedBean(name = "pages", eager = true)
@RequestScoped
public class pages {

	int endPage = 2;
	int currentPage = 0;
	final int rowCount = 1;
	ArrayList<Employee> emplist = new ArrayList<Employee>();
	ArrayList<EmployeeAddress> empAddlist = new ArrayList<>();

	public void setEmplist(ArrayList<Employee> emplist) {
		this.emplist = emplist;
	}

	public pages()

	{
System.out.println("----->>>>>HI page");
    restCall();
	}

	public  List<?> restCall(){
		try {
			Client client = ClientBuilder.newClient();
			WebTarget target = client
					.target("http://localhost:8082/REST-PAGINATION/rest/employees");
			Invocation invocation = target.request(MediaType.APPLICATION_XML)
					.buildGet();
			Response response = invocation.invoke();
			System.out.println("------>>>>" + response);
			EmployeeRecord record = response.readEntity(EmployeeRecord.class);

			for (Employee employee : record.getEmployee()) {


				this.emplist.add(employee);
			}


		} catch (Exception ex) {
			System.out.print(ex.toString());

		}

		return emplist;
	}

	public int getEndPage() {
		return endPage;
	}

	public void setEndPage(int rowCount) {
		System.out.print(endPage);
		this.endPage = rowCount;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		System.out.print(currentPage);
		this.currentPage = currentPage;
	}

	public ArrayList<Employee> getEmplist() {

		return emplist;

	}

	public int getRowCount() {
		return rowCount;
	}

	public void setpage(AjaxBehaviorEvent event) {
		int pageNum = 0;
		ExternalContext externalContext = FacesContext.getCurrentInstance()
				.getExternalContext();
		pageNum = Integer.parseInt(externalContext.getRequestParameterMap()
				.get("currentPage"));
		if (pageNum <= 0) {
			this.currentPage = pageNum;
		} else {
			this.currentPage = (pageNum * rowCount) - rowCount;
		}
		this.endPage = this.currentPage + rowCount;

		System.out.print("--" + this.currentPage + "--" + this.endPage);
	}

	public ArrayList<EmployeeAddress> getEmpAddlist() {
		return empAddlist;
	}

	public void setEmpAddlist(ArrayList<EmployeeAddress> empAddlist) {
		this.empAddlist = empAddlist;
	}


}
