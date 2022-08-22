package com.pension.management.pensionerdetail;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.io.IOException;

import org.junit.jupiter.api.Test;

import com.pension.management.pensionerdetail.entity.BankDetails;
import com.pension.management.pensionerdetail.entity.PensionerDetail;
import com.pension.management.pensionerdetail.exception.AadhaarNotFoundException;
import com.pension.management.pensionerdetail.service.PensionerDetailService;


public class PensionerDetailServiceTest {

	@Test
	public void CheckPensionerDetailServiceTest() throws AadhaarNotFoundException, NumberFormatException, IOException
	{
	PensionerDetailService mockPensionerDetailService = mock(PensionerDetailService.class);
	
	 mockPensionerDetailService.getPensionDetails("345633244137");
	 
	 PensionerDetail checkPension =  new PensionerDetail("345633244137", "Mohansai",
				"15-09-2000", "3ACD243178", 1237.0, 56.0, "Self", new BankDetails("Union", "1293", "public"));

	 when(mockPensionerDetailService.getPensionDetails("345633244137")).thenReturn(checkPension);
	}
	
	@Test
	public void PensionerDetailServiceTest_Fail() throws IOException
	{
	PensionerDetailService mockPensionerDetailService = mock(PensionerDetailService.class);
	
	 mockPensionerDetailService.getPensionDetails("3456332448198");


	 when(mockPensionerDetailService.getPensionDetails("345633244199")).thenReturn(null);
	}
}
