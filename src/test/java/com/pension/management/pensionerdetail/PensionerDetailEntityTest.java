package com.pension.management.pensionerdetail;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import com.pension.management.pensionerdetail.entity.BankDetails;
import com.pension.management.pensionerdetail.entity.PensionerDetail;

public class PensionerDetailEntityTest {

	PensionerDetail mockPensionerDetails = new PensionerDetail();
	BankDetails mockBankDetails = new BankDetails();

	/*
	 * 15-09-2000,3ACD243178,1237,56,Self,Union,1293,public private String PAN;
	 * private double SalaryEarned; private double Allowances; private String
	 * PentionType; private BankDetails BankDetails;
	 */
	@Test
	public void testSetAadhaarNumber() {
		String aadharNumber = "345633244137";
		mockPensionerDetails.setAadhaarNumber(aadharNumber);
		assertTrue(mockPensionerDetails.getAadhaarNumber() == aadharNumber);
	}

	@Test
	public void testName() {
		String name = "Mohan";
		mockPensionerDetails.setName(name);
		assertTrue(mockPensionerDetails.getName() == name);
	}

	@Test
	public void testDateOfBirth() {
		String dob = "15-09-2000";
		mockPensionerDetails.setDateOfBirth(dob);
		assertTrue(mockPensionerDetails.getDateOfBirth() == dob);
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
		mockPensionerDetails.setSalaryEarned(Salary);
		assertTrue(mockPensionerDetails.getSalaryEarned() == Salary);
	}
	
	@Test
	public void testSalaryget() {
		double Salary = 1273;
		mockPensionerDetails.setSalaryEarned(Salary);
		assertTrue(mockPensionerDetails.getSalaryEarned() == Salary);
	}

	@Test
	public void testAllowances() {
		double Allowance = 56;
		mockPensionerDetails.setAllowances(Allowance);
		assertTrue(mockPensionerDetails.getAllowances() == Allowance);
	}

	@Test
	public void testPensionType() {
		String pensionType = "Self";
		mockPensionerDetails.setPentionType(pensionType);
		assertTrue(mockPensionerDetails.getPentionType() == pensionType);
	}

	@Test
	public void testBankTest() {
		BankDetails TestBankDetails = new BankDetails("Union", "1293", "public");
		mockPensionerDetails.setBankDetails(TestBankDetails);
		assertTrue(mockPensionerDetails.getBankDetails().getAccountNumber() == "1293");
		assertTrue(mockPensionerDetails.getBankDetails().getBankName() == "Union");
		assertTrue(mockPensionerDetails.getBankDetails().getBanktype() == "public");
	}

	@Test
	public void testBankName() {
		String BankName = "AndhraBank";
		mockBankDetails.setBankName(BankName);
		assertTrue(mockBankDetails.getBankName() == BankName);
	}

	@Test
	public void testBankType() {
		String BankType = "private";
		mockBankDetails.setBanktype(BankType);
		assertTrue(mockBankDetails.getBanktype() == BankType);
	}

	@Test
	public void testAccountNumber() {
		String AccountNumber = "128934";
		mockBankDetails.setAccountNumber(AccountNumber);
		assertTrue(mockBankDetails.getAccountNumber() == AccountNumber);
	}

	@Test
	public void ConstructorTest()
	{
		new PensionerDetail();
		new BankDetails();
	}
	@Test
	public void Parameter_PDConstructorTest()
	{
		
		PensionerDetail pd = new PensionerDetail("345633244137","Mohan","15-09-2000","3ACD243178",1237.0,56.0,"Self",new BankDetails("Union","1293","public"));
		assertEquals("345633244137", pd.getAadhaarNumber());
		assertEquals("Mohan",pd.getName());
		assertEquals("15-09-2000", pd.getDateOfBirth());
		assertEquals("3ACD243178", pd.getPAN());
		assertEquals(1237.0, pd.getSalaryEarned());
		assertEquals(56.0,pd.getAllowances());
		assertEquals("Self", pd.getPentionType());
		BankDetails sampleBank = new BankDetails("Union","1293","public");
		assertEquals(pd.getBankDetails().getAccountNumber(), sampleBank.getAccountNumber());
		assertEquals(pd.getBankDetails().getBanktype(), sampleBank.getBanktype());
		assertEquals(pd.getBankDetails().getBankName(), sampleBank.getBankName());
	}
	
	@Test
	public void Parameter_BDConstructorTest()
	{
		
		BankDetails sampleBank = new BankDetails("Union","1293","public");
		assertEquals(sampleBank.getBankName(),"Union");
		assertEquals(sampleBank.getAccountNumber(),"1293");
		assertEquals(sampleBank.getBanktype(),"public");
	}
}
	