package com.employee.Controller;

import java.text.ParseException;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.employee.Request.EmployeeRequest;
import com.employee.Responce.MessageResponce;
import com.employee.Service.EmployeeService;

@RestController
@RequestMapping("/api/employee")
public class EmployeeController {

	@Autowired
	private EmployeeService EmployeeService;
	
	@PostMapping("/employee-registration")
	public ResponseEntity<MessageResponce> registerEmployee(@Valid @RequestBody EmployeeRequest employeeRequest)
			throws ParseException {
		String result = EmployeeService.EmployeeRegistration(employeeRequest);
		if (result.equals("success")) {
			return new ResponseEntity<>(new MessageResponce(true, "Employee Successfully Registered", result), HttpStatus.OK);
		} else if (result.contains("Already Present")) {
			return new ResponseEntity<>(new MessageResponce(false, "Employee Already Exist", result), HttpStatus.NOT_ACCEPTABLE);
		} else {
			return new ResponseEntity<>(new MessageResponce(false, "Please Fill Proper Data", result), HttpStatus.BAD_REQUEST);
		}

	}

}
