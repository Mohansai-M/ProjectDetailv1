package com.pension.management.pensionerdetail.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pension.management.pensionerdetail.entity.PensionerFinalDetails;
import com.pension.management.pensionerdetail.repository.PensionDetailRepository;


@Service
public class ProcessDetailSubmission {

	@Autowired
	PensionDetailRepository pensionDetailRepository;
	
	public PensionerFinalDetails submitDetail(PensionerFinalDetails penFinalDetails)
	{
		return pensionDetailRepository.save(penFinalDetails);
	}
}
