package com.rest.server.util;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@ManagedBean
@ApplicationScoped
public class employee {
private int id;
private String name;
private float salary;

@XmlAttribute(name="id")
public int getId() {
    return id;
}
public void setId(int id) {
    this.id = id;
}
@XmlElement(name="name")
public String getName() {
    return name;
}
public void setName(String name) {
    this.name = name;
}
@XmlElement(name="salary")
public float getSalary() {
    return salary;
}
public void setSalary(float salary) {
    this.salary = salary;
}
}