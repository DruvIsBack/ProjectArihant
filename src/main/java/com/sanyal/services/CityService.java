package com.sanyal.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sanyal.models.City;
import com.sanyal.repositories.CityRepository;

@Service
@Transactional
public class CityService{
	@Autowired
	private CityRepository cityrepository;
	
	public List<City> getCitiesByStateId(int stateid){
		return cityrepository.findByStateId(stateid);
	} 
}
