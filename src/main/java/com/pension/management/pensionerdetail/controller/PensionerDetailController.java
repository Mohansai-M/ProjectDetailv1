package com.pension.management.pensionerdetail.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.pension.management.pensionerdetail.entity.PensionerDetail;
import com.pension.management.pensionerdetail.entity.PensionerFinalDetails;
import com.pension.management.pensionerdetail.proxy.AuthorizationProxy;
import com.pension.management.pensionerdetail.repository.PensionDetailRepository;
import com.pension.management.pensionerdetail.service.PensionerDetailService;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class PensionerDetailController {

	PensionerDetail pensionerDetail = new PensionerDetail();

	@Autowired
	AuthorizationProxy authorizationProxy;

	@Autowired
	PensionDetailRepository pensionDetailRepository;
	PensionerDetailService pensionerDetailService = new PensionerDetailService();

	@GetMapping("/sample")
	public String dockercheeck() {
		return ("ok Success");
	}

	@GetMapping("/PensionerDetailByAadhaar/{aadhaarNumber}")
	public PensionerDetail retrievingPensionerDetails(@RequestHeader("Authorization") String token,
			@PathVariable String aadhaarNumber) throws IOException {

		authorizationProxy.validateAndReturnUser(token);
		return pensionerDetailService.getPensionDetails(aadhaarNumber);
	}

	@PostMapping("/SavePensionDetails")
	public boolean savePensionerDetails(//@RequestHeader("Authorization") String token,
			@RequestBody PensionerFinalDetails pensionerFinalDetails) throws Exception {
		//authorizationProxy.validateAndReturnUser(token);
		if (pensionerFinalDetails != null) {
			pensionDetailRepository.save(pensionerFinalDetails);
			return true;
		} else {
			throw new Exception("Please provide valid Pensioner Deials");
		}
	}
}
