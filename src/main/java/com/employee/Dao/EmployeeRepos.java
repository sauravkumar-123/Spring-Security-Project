package com.employee.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.employee.Model.Employee;

@Repository
public interface EmployeeRepos extends JpaRepository<Employee, Integer> {

	public Boolean existsByEmployeeEmailOrEmployeeMobno(String employeeEmail, String employeeMobno);
	public Employee findByEmployeeEmailOrEmployeeMobno(String employeeEmail, String employeeMobno);
	public Employee getEmployeeByEmployeeEmail(String EmployeeEmail);
}
