package com.employee.Dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.employee.Model.BankAccount;

public interface BankAccountRepos extends JpaRepository<BankAccount, Integer>{

}
