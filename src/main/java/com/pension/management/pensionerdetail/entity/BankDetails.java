package com.pension.management.pensionerdetail.entity;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public class BankDetails {

	public String getBankName() {
		return BankName;
	}
	public void setBankName(String bankName) {
		BankName = bankName;
	}
	public String getAccountNumber() {
		return AccountNumber;
	}
	public void setAccountNumber(String accountNumber) {
		AccountNumber = accountNumber;
	}
	public String getBanktype() {
		return Banktype;
	}
	public void setBanktype(String banktype) {
		Banktype = banktype;
	}
	private String BankName;
	private String AccountNumber;
	private String Banktype;
}
