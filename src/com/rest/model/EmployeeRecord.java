package com.rest.model;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@ManagedBean
@RequestScoped
@XmlRootElement(name="EMPLOYEE_RECORD")
public class EmployeeRecord implements Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = -1968717262529207603L;


	private List<Employee> employee;

	public List<Employee> getEmployee() {
		return employee;
	}
	@XmlElement(name="EMPLOYEE")
	public void setEmployee(List<Employee> employee) {
		this.employee = employee;
	}

}
