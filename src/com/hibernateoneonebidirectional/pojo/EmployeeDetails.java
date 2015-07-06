package com.hibernateoneonebidirectional.pojo;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@Entity
@Table(name = "EMPLOYEEDETAILS", catalog = "mydb")
public class EmployeeDetails implements java.io.Serializable {

	private static final long serialVersionUID = 8803931364501211179L;

	@Id  
    @GenericGenerator(name="eIdGen", strategy="foreign", parameters=@Parameter(value="employee", name = "property"))
    @GeneratedValue(generator="eIdGen")  
	@Column(name = "EID", unique = true, nullable = false)
	private Integer eId;
	
	@Column(name = "LOCATION")
	private String location;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "DOJ")
	private Date doj;
	
	@OneToOne(cascade = CascadeType.ALL, fetch=FetchType.LAZY)
	@PrimaryKeyJoinColumn
	private Employee employee;

	public EmployeeDetails() {
	}

	public EmployeeDetails(Integer eId, String location, Date doj) {
		this.eId = eId;
		this.location = location;
		this.doj = doj;
	}

	public Integer geteId() {
		return eId;
	}

	public void seteId(Integer eId) {
		this.eId = eId;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public Date getDoj() {
		return doj;
	}

	public void setDoj(Date doj) {
		this.doj = doj;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	
}
