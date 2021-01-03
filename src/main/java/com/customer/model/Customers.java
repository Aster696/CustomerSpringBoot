package com.customer.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "customers")
public class Customers {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Id")
	private int custId;
	@Column(name = "Name")
	private String custName;
	@Column(name = "Email")
	private String custEmail;
	@Column(name = "Address")
	private String custAddr;
	@Column(name = "Password")
	private String password;
	
	public Customers() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Customers(int custId, String custName, String custEmail, String custAddr, String password) {
		super();
		this.custId = custId;
		this.custName = custName;
		this.custEmail = custEmail;
		this.custAddr = custAddr;
		this.password = password;
	}

	public int getCustId() {
		return custId;
	}
	public void setCustId(int custId) {
		this.custId = custId;
	}
	public String getCustName() {
		return custName;
	}
	public void setCustName(String custName) {
		this.custName = custName;
	}
	public String getCustEmail() {
		return custEmail;
	}
	public void setCustEmail(String custEmail) {
		this.custEmail = custEmail;
	}
	public String getCustAddr() {
		return custAddr;
	}
	public void setCustAddr(String custAddr) {
		this.custAddr = custAddr;
	}
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "Customers [custId=" + custId + ", custName=" + custName + ", custEmail=" + custEmail + ", custAddr="
				+ custAddr + ", password=" + password + "]";
	}
	
}
