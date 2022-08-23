package com.pension.management.pensionerdetail.entity;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class PensionerFinalDetailsTest {

	PensionerFinalDetails mockPensionerDetails = new PensionerFinalDetails();

	@Test
	public void testSetAadhaarNumber() {
		String aadharNumber = "345633244137";
		mockPensionerDetails.setAadhaarnumber(aadharNumber);
		assertTrue(mockPensionerDetails.getAadhaarnumber() == aadharNumber);
	}

	@Test
	public void testPAN() {
		String panNumber = "ACD243178";
		mockPensionerDetails.setPAN(panNumber);
		assertTrue(mockPensionerDetails.getPAN() == panNumber);
	}

	@Test
	public void testSalary() {
		double Salary = 1273;
		mockPensionerDetails.setSalaryearned(Salary);
		assertTrue(mockPensionerDetails.getSalaryearned() == Salary);
	}

	@Test
	public void testBankName() {
		String BankName = "AndhraBank";
		mockPensionerDetails.setBankname(BankName);
		assertTrue(mockPensionerDetails.getBankname() == BankName);
	}

	@Test
	public void testBankType() {
		String BankType = "private";
		mockPensionerDetails.setBanktype(BankType);
		assertTrue(mockPensionerDetails.getBanktype() == BankType);
	}

	@Test
	public void testAllowances() {
		double Allowance = 56;
		mockPensionerDetails.setAllowances(Allowance);
		assertTrue(mockPensionerDetails.getAllowances() == Allowance);
	}
}
