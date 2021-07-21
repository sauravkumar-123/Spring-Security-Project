package com.employee.Utility;

import org.springframework.beans.factory.annotation.Autowired;

import com.employee.Dao.EmployeeRepos;

public class Utility {

	@Autowired
	private EmployeeRepos employeeRepos;
	
	public static enum Role{
		ADMIN(1,"admin"), USER(2,"user"),AGENT(3,"agent");
		
		private final Integer roleId;
		private final String roleName;

		private Role(Integer roleid, String rolename) {
			this.roleId = roleid;
			this.roleName = rolename;
		}

		public Integer getRoleId() {
			return roleId;
		}

		public String getRoleName() {
			return roleName;
		}
	}
}
