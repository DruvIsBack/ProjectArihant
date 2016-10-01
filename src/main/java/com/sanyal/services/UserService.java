package com.sanyal.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sanyal.models.User;
import com.sanyal.repositories.UserRepository;

@Service
@Transactional
public class UserService{
	@Autowired
	private UserRepository userrepository;
	
	public User getUserList(String u){
		return userrepository.findByUsername(u);
	} 
}
