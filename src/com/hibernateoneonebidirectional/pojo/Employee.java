package com.hibernateoneonebidirectional.pojo;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "employee", catalog = "mydb")
public class Employee implements java.io.Serializable {

	private static final long serialVersionUID = -3896276677876765446L;

	@Id
	@GeneratedValue
	@Column(name = "EID", unique = true, nullable = false)
	private Integer eId;

	@Column(name = "ENAME", unique = true, nullable = false)
	private String eName;
	
	@OneToOne(mappedBy="employee", cascade=CascadeType.ALL, fetch=FetchType.LAZY)  
    private EmployeeDetails employeeDetails;  

	public Employee() {
	}

	public Employee(String eName) {
		super();
		this.eName = eName;
	}

	public Integer geteId() {
		return eId;
	}

	public void seteId(Integer eId) {
		this.eId = eId;
	}

	public String geteName() {
		return eName;
	}

	public void seteName(String eName) {
		this.eName = eName;
	}

	public EmployeeDetails getEmployeeDetails() {
		return employeeDetails;
	}

	public void setEmployeeDetails(EmployeeDetails employeeDetails) {
		this.employeeDetails = employeeDetails;
	}

}
