package com.employee.ServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.employee.Dao.EmployeeRepos;
import com.employee.Model.Employee;

@Service
public class EmployeeDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private EmployeeRepos EmployeeRepos;
	
	//find employee from DB.
	@Override
	public UserDetails loadUserByUsername(String employeeEmail) throws UsernameNotFoundException {
		Employee employee=EmployeeRepos.getEmployeeByEmployeeEmail(employeeEmail);
		if(null==employee) {
			throw new UsernameNotFoundException("Couldn't find any Employee");
		}
		return new EmployeeServiceImpl(employee);
	}

}
