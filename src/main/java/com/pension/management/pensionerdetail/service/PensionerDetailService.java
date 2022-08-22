package com.pension.management.pensionerdetail.service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.pension.management.pensionerdetail.entity.BankDetails;
import com.pension.management.pensionerdetail.entity.PensionerDetail;
import com.pension.management.pensionerdetail.exception.AadhaarNotFoundException;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class PensionerDetailService {

	public PensionerDetail getPensionDetails(String aadhaarNumber)
			throws AadhaarNotFoundException, NumberFormatException, IOException {

		log.info("{}", aadhaarNumber);
		boolean error = true;
		PensionerDetail LocalDetails = new PensionerDetail();

		FileReader fr = new FileReader(PensionerDetailService.class.getClassLoader().getResource("data.txt").getPath());

		BufferedReader br = new BufferedReader(fr);

		List<PensionerDetail> pensionerDetail = new ArrayList<>();

		String line = null;

		while ((line = br.readLine()) != null) {
			String[] data = line.split(",");
			PensionerDetail pensionerDetail1 = new PensionerDetail();
			pensionerDetail1.setAadhaarNumber(data[0].toString());
			pensionerDetail1.setName(data[1].toString());
			pensionerDetail1.setDateOfBirth(data[2].toString());
			pensionerDetail1.setPAN(data[3].toString());
			pensionerDetail1.setSalaryEarned(Double.parseDouble(data[4]));
			pensionerDetail1.setAllowances(Double.parseDouble(data[5]));
			pensionerDetail1.setPentionType(data[6].toString());
			BankDetails bankDetails1 = new BankDetails();
			bankDetails1.setAccountNumber(data[8].toString());
			bankDetails1.setBankName(data[7].toString());
			bankDetails1.setBanktype(data[9].toString());
			pensionerDetail1.setBankDetails(bankDetails1);

			pensionerDetail.add(pensionerDetail1);
		}
		for (int i = 0; i < pensionerDetail.size(); i++) {

			if (aadhaarNumber.equals(pensionerDetail.get(i).getAadhaarNumber()))// pensionerDetail.get(i).getAadhaar()))
			{
				LocalDetails = pensionerDetail.get(i);
				error = false;
			}
		}
		if (error) {
			log.error("Enter valid AadharNumber");
			throw new AadhaarNotFoundException(aadhaarNumber);
		} else if (LocalDetails != null) {
			return LocalDetails;
		} else
			return new PensionerDetail();

	}

}
