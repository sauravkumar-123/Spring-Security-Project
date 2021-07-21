package com.employee.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@Table(name = "Department")
@Entity
public class Department {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="Department_ID")
	private Integer departmentid;

	@Column(name="Department_Name",length =50)
	private String departmentName;
	
	@Column(name="Company_Name",length =50)
	private String companyName;
	
	@Column(name="Administration_Name",length =50)
	private String departmentAdminName;
	
	@Column(name="Department_Bussiness_Email",length =50)
	private String departmentEmail;
	
	@Column(name="Department_Mobile_Number",length =15)
	private String departmentMobno;
	
	@OneToOne
	@JoinColumn(name ="employeeId")
	private Employee employee;
}
