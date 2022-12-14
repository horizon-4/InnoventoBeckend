package com.innovento.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.innovento.config.JwtTokenUtil;
import com.innovento.model.JwtRequest;
import com.innovento.model.JwtResponse;
import com.innovento.model.University;
import com.innovento.service.InnoventoMVPService;

@RestController
@CrossOrigin("*")
public class JwtAuthenticationController {

	@Autowired
	private JwtTokenUtil jwtTokenUtil;
	
	@Autowired
	private PasswordEncoder encoder;
	
	@Autowired
	private InnoventoMVPService innoventoMVPService;

	@Autowired
	private UserDetailsService jwtInMemoryUserDetailsService;

	@RequestMapping(value = "/authenticate", method = RequestMethod.POST)
	public ResponseEntity<?> createAuthenticationToken(@RequestBody JwtRequest authenticationRequest) throws Exception {
		
		final UserDetails userDetails = jwtInMemoryUserDetailsService 
				.loadUserByUsername(authenticationRequest.getUsername().trim());		
		
		if(!encoder.matches(authenticationRequest.getPassword(), userDetails.getPassword())) {
			throw new BadCredentialsException("Password Mismatch ");
		}

		final String token = jwtTokenUtil.generateToken(userDetails);
		
		return ResponseEntity.ok(new JwtResponse(token,userDetails.getUsername()));
	}


	@RequestMapping(value = "/university/authenticate", method = RequestMethod.POST)
	public ResponseEntity<?> createUniversityAuthenticationToken(@RequestBody University universityObj) throws Exception {

		final UserDetails userDetails = jwtInMemoryUserDetailsService
				.loadUserByUsername(universityObj.getName().trim());		
	
		if(!encoder.matches(universityObj.getPassword(), userDetails.getPassword())) {
			throw new BadCredentialsException("Password Mismatch ");
		}
		
		final String token = jwtTokenUtil.generateToken(userDetails);
		
		return ResponseEntity.ok(new JwtResponse(token,userDetails.getUsername()));
	}

	@GetMapping("/university/getListWithName")
	public List<Object> getUniversityListWithName() {
		return innoventoMVPService.getUniversityName();		
	}
	
	
}
