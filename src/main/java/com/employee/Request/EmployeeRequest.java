package com.employee.Request;

import java.util.List;

import com.employee.Model.BankAccount;
import com.employee.Model.Department;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeRequest {

	private String employeeName;
	private String employeeEmail;
	private String password;
	private String employeeMobno;
	private String employeeDob;
	private String employeeGender;
	private String employeeJobrole;
	
	/*private String bankerName;
	private String bankAccountNo;
	private String bankName;
	private String ifscCode;
	private String branchName;*/
	private List<BankAccount> bankAccounts;
	private Department department;
	/*private String departmentName;
	private String companyName;
	private String departmentAdminName;
	private String departmentEmail;
	private String departmentMobno;*/
}
