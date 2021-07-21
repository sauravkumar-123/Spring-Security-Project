package com.employee.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.ManyToAny;

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
@Table(name = "BankAccount")
@Entity
public class BankAccount {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="Bank_AccountID")
	private Integer bankAccountid;

	@Column(name="Banker_Name",length =50)
	private String bankerName;
	
	@Column(name="Bank_AccountNo",length =50)
	private String bankAccountNo;
	
	@Column(name="Bank_Name",length =50)
	private String bankName;
	
	@Column(name="Bank_IFSC",length =50)
	private String ifscCode;
	
	@Column(name="Branch_Name",length =50)
	private String branchName;
	
	@ManyToOne
	@JoinColumn(name ="employeeId")
	private Employee employee;
}
