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

import com.innovento.Repository.ProgramMasterRepo;
import com.innovento.Repository.SactionIntakeRepo;
import com.innovento.Repository.TotalStudentRepo;
import com.innovento.Repository.UniversityRepo;
import com.innovento.Repository.UserRepo;
import com.innovento.model.JwtRequest;
import com.innovento.model.ProgramMaster;
import com.innovento.model.SactionIntakeMaster;
import com.innovento.model.TotalStudentStrength;
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

		for (SactionIntakeMaster intakeMaster : intakeMastersList) {
			if (sactionIntakeRepo.findByProgramId(intakeMaster.getProgramId()) != null) {
				intakeMaster.setId(sactionIntakeRepo.findByProgramId(intakeMaster.getProgramId()).getId());
			}
			sactionIntakeRepo.save(intakeMaster);
		}
	}

	@Override
	@Transactional
	public void addTotalStudentList(List<TotalStudentStrength> totalStudentList) {

		for (TotalStudentStrength totalStudent : totalStudentList) {
			if (totalStudentRepo.findByProgramId(totalStudent.getProgramId()) != null) {
				totalStudent.setId(totalStudentRepo.findByProgramId(totalStudent.getProgramId()).getId());
			}
			totalStudentRepo.save(totalStudent);
		}
	}

	@Override
	public List<Object> getSactionApprovedListWithProgram() {
		return sactionIntakeRepo.findSactionApprovedListWithPrograms();
	}

	@Override
	public List<Object> getUniversityName() {
		return universityRepo.getUniversityNamesList();
	}

}