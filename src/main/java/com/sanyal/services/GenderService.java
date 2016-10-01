package com.sanyal.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sanyal.models.Gender;
import com.sanyal.repositories.GenderRepository;

@Service
@Transactional
public class GenderService{
	@Autowired
	private GenderRepository genderrepository;
	
	public List<Gender> getGenderList(){
		return genderrepository.findAll();
	} 
}
