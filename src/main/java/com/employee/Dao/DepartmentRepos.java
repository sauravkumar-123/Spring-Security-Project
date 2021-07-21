package com.employee.Dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.employee.Model.Department;

public interface DepartmentRepos extends JpaRepository<Department, Integer> {

}
