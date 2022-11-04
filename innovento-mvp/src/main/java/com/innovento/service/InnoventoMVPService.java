package com.innovento.service;

import java.util.List;

import com.innovento.model.ProgramMaster;
import com.innovento.model.TotalStudentStrength;
import com.innovento.model.SactionIntakeMaster;

public interface InnoventoMVPService {
	
	public ProgramMaster getProgramFromId(long id);

	public List<SactionIntakeMaster> getsactionApprovedList();
	
	public List<TotalStudentStrength> getTotalStudentList();
	
	public void addSactionApprovedList(List<SactionIntakeMaster> intakeMastersList) ;

	public void addTotalStudentList(List<TotalStudentStrength> totalStudentList);
	
	public List<Object> getSactionApprovedListWithProgram();
	
	public List<Object> getUniversityName();
}