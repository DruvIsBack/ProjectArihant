package com.sanyal.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.sanyal.models.Country;
import com.sanyal.repositories.CountryRepository;

@Service
@Transactional
public class CountryService{
	
	@Autowired
	private CountryRepository countryrepository;
	
	public List<Country> getCountryList(){
		return countryrepository.findAll();
	}
	
}
