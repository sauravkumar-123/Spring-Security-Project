package com.employee.Service;

import java.text.ParseException;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import com.employee.Request.EmployeeRequest;

@Service
public interface EmployeeService extends UserDetails{

	public String EmployeeRegistration(EmployeeRequest employeeRequest) throws ParseException;
}
