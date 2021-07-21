package com.employee.Model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
@Table(name = "EmployeeDatabase")
@Entity
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="Employee_ID")
	private Integer employeeId;

	@Column(name="Employee_Name",length =50)
	private String employeeName;
	
	@Column(name="Bussiness_Email",length =50)
	private String employeeEmail;
	
	@Column(name="Password")
	private String password;
	
	@Column(name="Mobile_Number",length =15)
	private String employeeMobno;
	
	@Column(name="DOB",length =20)
	@Temporal(TemporalType.TIMESTAMP)
	private Date employeeDob;
	
	@Column(name="Employee_Gender",length =50)
	private String employeeGender;
	
	@Column(name="Employee_Jobrole",length =20)
	private String employeeJobrole;
	
	@Column(name="Authorities_Role",length =20)
	private String role;
	
	@OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY,mappedBy = "employee")
	private List<BankAccount> bankAccounts=new ArrayList<>();
	
	@OneToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY,mappedBy = "employee")
	private Department department;
}
