package com.rest.model;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@ManagedBean
@RequestScoped
@XmlType(propOrder = { "city", "pin", "state", "country" })
public class EmployeeAddress  {

	private String city;
	private String state;
	private long pin;
	private String country;

	public String getCity() {
		return city;
	}
    @XmlElement(name="CITY")
	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}
	@XmlElement(name="STATE")
	public void setState(String state) {
		this.state = state;
	}

	public long getPin() {
		return pin;
	}
	@XmlElement(name="PIN")
	public void setPin(long pin) {
		this.pin = pin;
	}

	public String getCountry() {
		return country;
	}
	@XmlElement(name="COUNTRY")
	public void setCountry(String country) {
		this.country = country;
	}
	@Override
	public String toString() {
		return "EmployeeAddress [city=" + city + ", state=" + state + ", pin="
				+ pin + ", country=" + country + "]";
	}


}
