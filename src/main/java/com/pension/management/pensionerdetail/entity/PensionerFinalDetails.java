package com.pension.management.pensionerdetail.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "PAYMENT")
public class PensionerFinalDetails {

	@Id

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long Id;
	private String bankname;
	private String banktype;
	private String aadhaarnumber;
	private String username;
	private String PAN;
	private double salaryearned;
	private double allowances;

	public long getId() {
		return Id;
	}

	public void setId(long id) {
		Id = id;
	}

	public String getBankname() {
		return bankname;
	}

	public void setBankname(String bankname) {
		this.bankname = bankname;
	}

	public String getBanktype() {
		return banktype;
	}

	public void setBanktype(String banktype) {
		this.banktype = banktype;
	}

	public String getAadhaarnumber() {
		return aadhaarnumber;
	}

	public void setAadhaarnumber(String aadhaarnumber) {
		this.aadhaarnumber = aadhaarnumber;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPAN() {
		return PAN;
	}

	public void setPAN(String pAN) {
		PAN = pAN;
	}

	public double getSalaryearned() {
		return salaryearned;
	}

	public void setSalaryearned(double salaryearned) {
		this.salaryearned = salaryearned;
	}

	public double getAllowances() {
		return allowances;
	}  

	public void setAllowances(double allowances) {
		this.allowances = allowances;
	}

}
