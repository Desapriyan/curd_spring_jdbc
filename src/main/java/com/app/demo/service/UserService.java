package com.app.demo.service;


import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.app.demo.repository.UserRepository;
import com.app.demo.springboot.dto.SpringBoot;



@Service
public class UserService {

	@Autowired
 UserRepository userRepository;

	public void save(SpringBoot user) throws SQLException {

		userRepository.save(user);
	}

	public void deleteById(SpringBoot user) throws ClassNotFoundException, SQLException {
	
		userRepository.deleteById(user);
	}

	public void updateUser(SpringBoot user) throws SQLException {
		
		userRepository.updateUser(user);
	}

	public SpringBoot getById(Integer id) throws SQLException, ClassNotFoundException {
		 
	
		return userRepository.getById(id);
	}

	public List<SpringBoot> getAll() throws SQLException {
		
		
		return userRepository.getAll();
		
	}  
	
	
}
