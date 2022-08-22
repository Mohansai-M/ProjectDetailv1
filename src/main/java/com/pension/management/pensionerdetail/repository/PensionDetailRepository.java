package com.pension.management.pensionerdetail.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pension.management.pensionerdetail.entity.PensionerFinalDetails;
@Repository
public interface PensionDetailRepository extends JpaRepository<PensionerFinalDetails,Long>{

	PensionerFinalDetails save(PensionerFinalDetails pensionerFinalDetails);

	
}
