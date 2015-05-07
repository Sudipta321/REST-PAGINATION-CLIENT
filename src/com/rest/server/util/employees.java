package com.rest.server.util;


import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


import java.util.List;

@ManagedBean
@ApplicationScoped

@XmlRootElement(name = "employees")
public class employees
{
    private List<employee> emplists = null;

    public List<employee> getEmployees() {
        return emplists;
    }

    public void setEmployees(List<employee> employees) {
        this.emplists = employees;
    }
}