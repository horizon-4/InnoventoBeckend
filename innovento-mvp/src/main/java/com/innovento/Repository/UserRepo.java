package com.innovento.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.innovento.model.JwtRequest;

@Repository
public interface UserRepo extends JpaRepository<JwtRequest, Long>{

	public JwtRequest findByUsername(String username);
	
	
	
}
