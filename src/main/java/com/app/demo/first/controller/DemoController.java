package com.app.demo.first.controller;
import java.sql.SQLException;
import java.util.List;

import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.demo.service.UserService;
import com.app.demo.springboot.dto.GenericRespon;
import com.app.demo.springboot.dto.SpringBoot;


@RestController
@RequestMapping("/demo")
public class DemoController {
	@Autowired
	private UserService userservice;
	
	@PostMapping(value ="/post" )
	public GenericRespon<User> createUser (@RequestBody SpringBoot user) throws SQLException {
		userservice.save(user);
		GenericRespon<User> response = new GenericRespon<User>();
		response.setStatus(" Created  Successfully");
		response.setMaessage("Successfully");
		response.setDataList(null);
		response.setData(user);
		 System.out.println("send Successfully");
		return response;	
		
	}
	@DeleteMapping(value ="/delete" )
	public GenericRespon<User> deleteUser (@RequestBody SpringBoot user) throws ClassNotFoundException, SQLException {
		userservice.deleteById(user);
		GenericRespon<User> response = new GenericRespon<User>();
		response.setStatus(" Deleted  Successfully");
		response.setMaessage("Successfully");
		response.setDataList(null);
		response.setData(user);
		return response;
	
	}
	
    @PutMapping(value ="/update")
    public GenericRespon<User> updateUser (@RequestBody SpringBoot user) throws ClassNotFoundException, SQLException {
	userservice.updateUser(user);
	GenericRespon<User> response = new GenericRespon<User>();
	response.setStatus(" put  Successfully");
	response.setMaessage("Successfully");
	response.setDataList(null);
	response.setData(user);
	return response;
}
    @GetMapping(value ="/get/{id}" )
	public GenericRespon<User> getById (@PathVariable Integer id) throws ClassNotFoundException, SQLException {
    	SpringBoot user= userservice.getById(id);
		GenericRespon<User> response = new GenericRespon<User>();
		response.setStatus(" Get  Successfully");
		response.setMaessage("Successfully");
		response.setDataList(null);
		response.setData(user);
		return response;
    
}

	@GetMapping(value ="/get" )
	public GenericRespon<User> getAll () throws SQLException {
	List<SpringBoot>obj=userservice.getAll();
		GenericRespon<User> response = new GenericRespon<User>();
		response.setStatus(" getAll  Successfully");
		response.setMaessage("Successfully");
		response.setDataList(obj);
		response.setData(null);
		return response;
    	

}
}