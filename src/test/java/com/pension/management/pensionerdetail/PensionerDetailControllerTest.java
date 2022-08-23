package com.pension.management.pensionerdetail;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.pension.management.pensionerdetail.controller.PensionerDetailController;
import com.pension.management.pensionerdetail.entity.BankDetails;
import com.pension.management.pensionerdetail.entity.PensionerDetail;
import com.pension.management.pensionerdetail.entity.PensionerFinalDetails;
import com.pension.management.pensionerdetail.proxy.AuthorizationProxy;
import com.pension.management.pensionerdetail.service.PensionerDetailService;
import com.pension.management.pensionerdetail.service.ProcessDetailSubmission;

import lombok.extern.slf4j.Slf4j;

@WebMvcTest(PensionerDetailController.class)
@Slf4j
public class PensionerDetailControllerTest {

	String url = "/PensionerDetailByAadhaar/{aadhaarNumber}";

	String token = "eyJhbGciOiJIUzI1NiJ9";
	
	@Autowired
	MockMvc mockMvc;

	PensionerDetailService mockPensionerDetailService = mock(PensionerDetailService.class);

	/*
	 * LocalTime ls; DateTimeFormatter ds; LocalDateTime d =
	 * LocalDateTime.parse("15/09/2000", DateTimeFormatter.ISO_DATE);
	 * 
	 */
	
	@MockBean
	AuthorizationProxy mockProxy;
	
	@MockBean
	ProcessDetailSubmission localSubmit;

	@Test
	public void retrievePensionDetails_basic() throws Exception {

		String aadhaarNumber = "345633244137";
		PensionerDetail checkPension = new PensionerDetail("345633244137", "Mohansai", "15-09-2000", "3ACD243178",
				1237.0, 56.0, "Self", new BankDetails("Union", "1293", "public"));

		when(mockPensionerDetailService.getPensionDetails(aadhaarNumber)).thenReturn(checkPension);

		
		RequestBuilder req = MockMvcRequestBuilders.get(url, aadhaarNumber).accept(MediaType.APPLICATION_JSON)
				.header("Authorization", "Bearer " + token);

		when(mockProxy.validateAndReturnUser(token)).thenReturn(true);
		

		mockMvc.perform(req)
		        .andExpect(status().isOk()).andExpect(content().json(
				"{aadhaarNumber:\"345633244137\",name:\"Mohansai\",pentionType:\"Self\",salaryEarned:1237.0,allowances:56.0,pan:\"3ACD243178\",dateOfBirth:\"15-09-2000\",bankDetails:{bankName:\"Union\",accountNumber:\"1293\",banktype:\"public\"}}"))
				.andReturn();
	}

	@Test
	public void pensionerDetailsNullCheck() throws Exception {
		String token = "eyJhbGciOiJIUzI1NiJ9";
		String aadhaarNumber = "345633244837";
		when(mockPensionerDetailService.getPensionDetails(aadhaarNumber)).thenReturn(null);

		when(mockProxy.validateAndReturnUser(token)).thenReturn(true);
		
		RequestBuilder req = MockMvcRequestBuilders.get(url, aadhaarNumber).accept(MediaType.APPLICATION_JSON)
				.header("Authorization", "Bearer " + token);

		mockMvc.perform(req).andExpect(status().is(404)).andExpect(content().string("")).andReturn();
	}
	

}
