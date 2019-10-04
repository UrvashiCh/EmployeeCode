package com.cg.beans;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Employee Code is a bean that contains various properties,getter and setter methods and toString method.
 * @author Hemnath V
 * @author Urvashi Chaudhary
 * @author Sakshi Agrawal
 * @author Archit Khandelwal
 * @author Vikrant Bhardwaj
 * @author Karshni Mitra
 * @author Abhishek Sonavane
 * @author Venkata Surya Reddy
 *
 */

@Entity
@Table(name="employee_code")
public class EmployeeCode 
{
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id",length=5)
	private int empId;
	
	@Column(name="name",length=20)
	private String empName;
	
	@Column(name="pan",length=10)
	private String empPAN;
	
	@Column(name="designation",length=20)
	private String empDesg;
	
	@Column(name="domain",length=20)
	private String empDomain;
	
	@Column(name="DOJ")
	private Date empDOJ;
	
	@Column(name="DOB")
	private Date empDOB;
	
	@Column(name="salary",length=10)
	private float empSal;
	
	@Column(name="mail",length=25)
	private String empMail;
	
	@Column(name="password",length=15)
	private String empPassword;
	
	
	
	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public String getEmpPAN() {
		return empPAN;
	}
	public void setEmpPAN(String empPAN) {
		this.empPAN = empPAN;
	}
	public String getEmpDesg() {
		return empDesg;
	}
	public void setEmpDesg(String empDesg) {
		this.empDesg = empDesg;
	}
	public String getEmpDomain() {
		return empDomain;
	}
	public void setEmpDomain(String empDomain) {
		this.empDomain = empDomain;
	}
	public Date getEmpDOJ() {
		return empDOJ;
	}
	public void setEmpDOJ(Date empDOJ) {
		this.empDOJ = empDOJ;
	}
	public Date getEmpDOB() {
		return empDOB;
	}
	public void setEmpDOB(Date empDOB) {
		this.empDOB = empDOB;
	}
	public float getEmpSal() {
		return empSal;
	}
	public void setEmpSal(float empSal) {
		this.empSal = empSal;
	}
	public String getEmpMail() {
		return empMail;
	}
	public void setEmpMail(String empMail) {
		this.empMail = empMail;
	}
	public String getEmpPassword() {
		return empPassword;
	}
	public void setEmpPassword(String empPassword) {
		this.empPassword = empPassword;
	}
	@Override
	public String toString() {
		return "EmployeeCode [empId=" + empId + ", empName=" + empName + ", empPAN=" + empPAN + ", empDesg=" + empDesg
				+ ", empDomain=" + empDomain + ", empDOJ=" + empDOJ + ", empDOB=" + empDOB + ", empSal=" + empSal
				+ ", empMail=" + empMail + ", empPassword=" + empPassword + "]";
	}
	public EmployeeCode(int empId, String empName, String empPAN, String empDesg, String empDomain, Date empDOJ,
			Date empDOB, float empSal, String empMail, String empPassword) {
		super();
		this.empId = empId;
		this.empName = empName;
		this.empPAN = empPAN;
		this.empDesg = empDesg;
		this.empDomain = empDomain;
		this.empDOJ = empDOJ;
		this.empDOB = empDOB;
		this.empSal = empSal;
		this.empMail = empMail;
		this.empPassword = empPassword;
	}
	public EmployeeCode() 
	{
		super();
		
	}
	

	
	
	

}
