package com.pension.management.pensionerdetail.entity;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
public class PensionerDetail {

	private String AadhaarNumber;
	private String Name;
	private String DateOfBirth;
	private String PAN;
	private double SalaryEarned;
	private double Allowances;
	private String PentionType;
	private BankDetails BankDetails;


	public String getAadhaarNumber() {
		return AadhaarNumber;
	}

	public void setAadhaarNumber(String aadhaarNumber) {
		AadhaarNumber = aadhaarNumber;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getDateOfBirth() {
		return DateOfBirth;
	}

	public void setDateOfBirth(String dateOfBirth) {
		DateOfBirth = dateOfBirth;
	}

	public String getPAN() {
		return PAN;
	}

	public void setPAN(String pAN) {
		PAN = pAN;
	}

	public double getSalaryEarned() {
		return SalaryEarned;
	}

	public void setSalaryEarned(double salaryEarned) {
		SalaryEarned = salaryEarned;
	}

	public double getAllowances() {
		return Allowances;
	}

	public void setAllowances(double allowances) {
		Allowances = allowances;
	}

	public String getPentionType() {
		return PentionType;
	}

	public void setPentionType(String pentionType) {
		PentionType = pentionType;
	}

	public BankDetails getBankDetails() {
		return BankDetails;
	}

	public void setBankDetails(BankDetails bankDetails) {
		BankDetails = bankDetails;
	}
	
	
	

}
