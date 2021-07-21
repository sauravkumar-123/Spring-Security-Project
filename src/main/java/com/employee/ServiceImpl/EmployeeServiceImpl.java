package com.employee.ServiceImpl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.employee.Dao.EmployeeRepos;
import com.employee.Model.Employee;
import com.employee.Request.EmployeeRequest;
import com.employee.Service.EmployeeService;
import com.employee.Utility.Utility;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	private static final long serialVersionUID = 1L;

	private Employee employee;
	
	
	public EmployeeServiceImpl() {

	}
	
	public EmployeeServiceImpl(Employee employee) {
		this.employee = employee;
	}


	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		SimpleGrantedAuthority simpleGrantedAuthority = new SimpleGrantedAuthority(employee.getRole());
		return List.of(simpleGrantedAuthority);
	}

	@Override
	public String getPassword() {
		return employee.getPassword();
	}

	@Override
	public String getUsername() {
		return employee.getEmployeeEmail();
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}
	
	@Autowired
	private PasswordEncoder PasswordEncoder;
	
	@Autowired
	private EmployeeRepos EmployeeRepos;
	
	@Override
	public String EmployeeRegistration(@Valid @RequestBody EmployeeRequest employeeRequest) throws ParseException {
		
		if(EmployeeRepos.existsByEmployeeEmailOrEmployeeMobno(employeeRequest.getEmployeeEmail(), employeeRequest.getEmployeeMobno()))
		{
			return "Employee Already Present";
		}
		Employee employee=EmployeeRepos.findByEmployeeEmailOrEmployeeMobno(employeeRequest.getEmployeeEmail(), employeeRequest.getEmployeeMobno());
		if(null==employee) {
			Employee emp=new Employee();
			emp.setEmployeeName(employeeRequest.getEmployeeName()==null ? null : employeeRequest.getEmployeeName());
			emp.setEmployeeEmail(employeeRequest.getEmployeeEmail()==null ? null : employeeRequest.getEmployeeEmail());
			emp.setEmployeeMobno(employeeRequest.getEmployeeMobno()==null ? null : employeeRequest.getEmployeeMobno());
			emp.setPassword(employeeRequest.getPassword()==null ? null : PasswordEncoder.encode(employeeRequest.getPassword()));
			
			Date dob = new SimpleDateFormat("dd-MM-yyyy").parse(
					       employeeRequest.getEmployeeDob().toString() == null ? null : employeeRequest.getEmployeeDob().toString());
			emp.setEmployeeDob(dob);
            emp.setEmployeeGender(employeeRequest.getEmployeeGender()==null ? null : employeeRequest.getEmployeeGender());
            emp.setRole(Utility.Role.USER.getRoleId().toString());
            emp.setEmployeeJobrole(employeeRequest.getEmployeeJobrole()==null ? null : employeeRequest.getEmployeeJobrole());
            emp.setBankAccounts(employeeRequest.getBankAccounts()==null ? null :employeeRequest.getBankAccounts());
            emp.setDepartment(employeeRequest.getDepartment()==null ? null: employeeRequest.getDepartment());
            
            EmployeeRepos.save(emp);
            return "success";
		}else {
			
			return "Employee Already Present";
		}
	}
	
}
