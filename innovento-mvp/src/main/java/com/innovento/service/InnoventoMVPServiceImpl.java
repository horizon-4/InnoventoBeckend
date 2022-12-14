package com.innovento.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.innovento.Repository.AcademicYearRepo;
import com.innovento.Repository.CapitalExpenditureAmountRepo;
import com.innovento.Repository.ConsultingProjectDetailsRepo;
import com.innovento.Repository.OperationExpenditureAmountRepo;
import com.innovento.Repository.PG_2yearRepo;
import com.innovento.Repository.PhdGraduatedRepo;
import com.innovento.Repository.PhdPersuingRepo;
import com.innovento.Repository.ProgramMasterRepo;
import com.innovento.Repository.ProgramTimeRepo;
import com.innovento.Repository.ResearchDetailsRepo;
import com.innovento.Repository.SactionIntakeRepo;
import com.innovento.Repository.SponsoredResearchDetailsRepo;
import com.innovento.Repository.TotalStudentRepo;
import com.innovento.Repository.UG_4yearRepo;
import com.innovento.Repository.UniversityRepo;
import com.innovento.Repository.UserRepo;
import com.innovento.model.AcademicYear;
import com.innovento.model.CapitalExpenditureAmount;
import com.innovento.model.ConsultingProjectDetails;
import com.innovento.model.JwtRequest;
import com.innovento.model.OperationExpenditureAmount;
import com.innovento.model.PG_2year;
import com.innovento.model.Phd_graduated_student;
import com.innovento.model.Phd_persuingTill2021;
import com.innovento.model.ProgramMaster;
import com.innovento.model.ProgramTime;
import com.innovento.model.ResearchDetails;
import com.innovento.model.SactionIntakeMaster;
import com.innovento.model.SponsoredResearchDetails;
import com.innovento.model.TotalStudentStrength;
import com.innovento.model.UG_4year;
import com.innovento.model.University;

@Service
public class InnoventoMVPServiceImpl implements InnoventoMVPService, UserDetailsService {

	@Autowired
	private UserRepo userRepo;

	@Autowired
	private ProgramMasterRepo programMasterRepo;

	@Autowired
	private UniversityRepo universityRepo;

	@Autowired
	private SactionIntakeRepo sactionIntakeRepo;

	@Autowired
	private TotalStudentRepo totalStudentRepo;

	@Autowired
	private PhdGraduatedRepo phdGraduatedRepo;
	
	@Autowired
	private PhdPersuingRepo phdPersuingRepo;
	
	@Autowired
	private ProgramTimeRepo programTimeRepo;
	
	@Autowired
	private ResearchDetailsRepo researchDetailsRepo;
	
	@Autowired
	private SponsoredResearchDetailsRepo sponsoredResearchDetailsRepo;
	
	@Autowired
	private ConsultingProjectDetailsRepo consultingProjectDetailsRepo;

	@Autowired
	private CapitalExpenditureAmountRepo capitalExpenditureAmountRepo;
	
	@Autowired
	private OperationExpenditureAmountRepo operationExpenditureAmountRepo;
	
	@Autowired
	private AcademicYearRepo academicYearRepo;
	
	
	@Autowired
	private UG_4yearRepo ug_4yearRepo;
	
	@Autowired
	private PG_2yearRepo pg_2yearRepo;
	
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		JwtRequest jwtRequest = userRepo.findByUsername(username);
//		System.out.println(username);
		University university= universityRepo.findByName(username);
//		System.out.println(universityRepo.findByName(username));
			if (jwtRequest !=null && jwtRequest.getUsername().equals(username)) {
				return new User(jwtRequest.getUsername(),jwtRequest.getPassword(),
						new ArrayList<>());
			} else 	if (university !=null && university.getName().equals(username)) {
				return new User(university.getName(),university.getPassword(),
						new ArrayList<>());
			} else {
				throw new UsernameNotFoundException(username+" Not Found");
			}
	
	}

	@Override
	public ProgramMaster getProgramFromId(long id) {
		return programMasterRepo.findById(id).get();
	}
	@Override
	public List<ProgramMaster> getProgramList() {
		return programMasterRepo.findAll();
	}


	@Override
	public List<SactionIntakeMaster> getsactionApprovedList() {
		return sactionIntakeRepo.findAll();
	}

	@Override
	public List<TotalStudentStrength> getTotalStudentList() {
		return totalStudentRepo.findAll();
	}

	@Override
	@Transactional
	public void addSactionApprovedList(List<SactionIntakeMaster> intakeMastersList) {
			sactionIntakeRepo.saveAll(intakeMastersList);
	}

	@Override
	@Transactional
	public void addTotalStudentList(List<TotalStudentStrength> totalStudentList) {
			totalStudentRepo.saveAll(totalStudentList);
	}

	@Override
	public List<Object> getSactionApprovedListWithProgram() {
		return sactionIntakeRepo.findSactionApprovedListWithPrograms();
	}

	@Override
	public List<Object> getUniversityName() {
		return universityRepo.getUniversityNamesList();
	}

	@Override
	public List<Phd_graduated_student> getPhdGraduatedStudentsList() {
		return phdGraduatedRepo.findAll();
	}

	@Override
	public void addPhdGraduatedStudentsList(List<Phd_graduated_student> phd_graduated_studentsList) {
		phdGraduatedRepo.saveAll(phd_graduated_studentsList);
	}

	@Override
	public List<Phd_persuingTill2021> getPhdPersuingStudentsList() {
		return phdPersuingRepo.findAll();
	}

	@Override
	public void addPhdPersuingStudentsList(List<Phd_persuingTill2021> phd_persuingStudentsList) {
		phdPersuingRepo.saveAll(phd_persuingStudentsList);
	}

	@Override
	public ProgramTime getProgramTimeById(long id) {
		return programTimeRepo.findById(id).get();
	}

	@Override
	public ResearchDetails getResearchDetailsById(long id) {
		return researchDetailsRepo.findById(id).get();
	}


	@Override
	public List<SponsoredResearchDetails> getSponsoredResearchDetailsList() {
		return sponsoredResearchDetailsRepo.findAll();
	}

	@Override
	public void addSponsoredResearchDetailsList(List<SponsoredResearchDetails> sponsoredResearchDetails) {
		sponsoredResearchDetailsRepo.saveAll(sponsoredResearchDetails);
	}

	@Override
	public List<ConsultingProjectDetails> getConsultingProjectDetailsList() {
		return consultingProjectDetailsRepo.findAll();
	}

	@Override
	public void addConsultingProjectDetailsList(List<ConsultingProjectDetails> consultingProjectDetailsList) {
		consultingProjectDetailsRepo.saveAll(consultingProjectDetailsList);
	}

	@Override
	public List<CapitalExpenditureAmount> getCapitalExpenditureAmountList() {
		return capitalExpenditureAmountRepo.findAll();
	}

	@Override
	public void addCapitalExpenditureAmountList(List<CapitalExpenditureAmount> capitalExpenditureAmountList) {
		capitalExpenditureAmountRepo.saveAll(capitalExpenditureAmountList);
	}

	@Override
	public List<OperationExpenditureAmount> getOperationExpenditureAmountList() {
		return operationExpenditureAmountRepo.findAll();
	}

	@Override
	public void addOperationExpenditureAmountList(List<OperationExpenditureAmount> operationExpenditureAmountsList) {
		operationExpenditureAmountRepo.saveAll(operationExpenditureAmountsList);
	}

	@Override
	public AcademicYear getAcademicYearFromId(long id) {
		return academicYearRepo.findById(id).get();
	}
	@Override
	public List<AcademicYear> getAcademicYearList() {
		return academicYearRepo.findAll();
	}

	@Override
	public List<UG_4year> getUG_4yearList() {
		return ug_4yearRepo.findAll();
	}

	@Override
	public void addUG_4yearList(List<UG_4year> ug_4yearsList) {
		ug_4yearRepo.saveAll(ug_4yearsList);
	}

	@Override
	public List<PG_2year> getPG_2yearList() {
		return pg_2yearRepo.findAll();
	}

	@Override
	public void addPG_2yearList(List<PG_2year> pg_2yearList) {
		pg_2yearRepo.saveAll(pg_2yearList);
	}

	

	
	
}