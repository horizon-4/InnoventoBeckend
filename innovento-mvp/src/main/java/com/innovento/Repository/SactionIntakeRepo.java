package com.innovento.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.innovento.model.SactionIntakeMaster;

@Repository
public interface SactionIntakeRepo extends JpaRepository<SactionIntakeMaster, Long> {

	public SactionIntakeMaster findByProgramId(long acedamicId);

//	@Query("SELECT program_master.program_name,saction_approved_intake_master.2015_16_count,saction_approved_intake_master.2016_17_count,saction_approved_intake_master.2017_18_count,saction_approved_intake_master.2018_19_count,saction_approved_intake_master.2019_20_count,saction_approved_intake_master.2020_21_count from program_master,saction_approved_intake_master  \r\n"
//			+ "where saction_approved_intake_master.program_id=program_master.id")
//	@Query("SELECT * FROM program_master",na)
//	@Query(value = "SELECT program_master.program_name,saction_approved_intake_master.2015_16_count,saction_approved_intake_master.2016_17_count,saction_approved_intake_master.2017_18_count,saction_approved_intake_master.2018_19_count,saction_approved_intake_master.2019_20_count,saction_approved_intake_master.2020_21_count from program_master,saction_approved_intake_master"+
//		"where saction_approved_intake_master.program_id=program_master.id", nativeQuery = true)
//	@Query(value = "SELECT p.program_name,s.2015_16_count,s.2016_17_count,s.2017_18_count,s.2018_19_count,s.2019_20_count,s.2020_21_count from program_master p,saction_approved_intake_master"
//			+ "where p.id = s.program_id", nativeQuery = true)	
//	@Query(value = "SELECT p.program_name,s.2015_16_count,s.2016_17_count,s.2017_18_count,s.2018_19_count,s.2019_20_count,s.2020_21_count from program_master p,saction_approved_intake_master"
//			+ "where program_master.id = 1", nativeQuery = true)

	@Query(value = "SELECT p.id,p.program_name,s.2015_16_count,s.2016_17_count,s.2017_18_count,s.2018_19_count,s.2019_20_count,s.2020_21_count from program_master p,saction_approved_intake_master s "
			+ "where p.id=s.program_id"
			, nativeQuery = true)
	public List<Object> findSactionApprovedListWithPrograms();

}
