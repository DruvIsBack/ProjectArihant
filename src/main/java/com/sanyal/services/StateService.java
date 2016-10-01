package com.sanyal.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sanyal.models.State;
import com.sanyal.repositories.StateRepository;

@Service
@Transactional
public class StateService{
	@Autowired
	private StateRepository staterepository;
	
	public List<State> getSatesByCountryId(int countryid){
		return staterepository.findByCountryId(countryid);
	} 
}
