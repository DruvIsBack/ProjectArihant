package com.sanyal.controllers;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.sanyal.models.City;
import com.sanyal.models.State;
import com.sanyal.models.User;
import com.sanyal.services.CityService;
import com.sanyal.services.CountryService;
import com.sanyal.services.GenderService;
import com.sanyal.services.StateService;
import com.sanyal.services.UserService;

@RestController
public class RegistrationController{

	@SuppressWarnings("unused")
	private Logger logger=Logger.getLogger(RegistrationController.class);
	 
	 @Autowired
	 CountryService countryService = new CountryService();
	 @Autowired
	 StateService stateService = new StateService();
	 @Autowired
	 CityService cityService = new CityService();
	 @Autowired
	 GenderService GenderService = new GenderService();
	 @Autowired
	 UserService userService = new UserService();
 
	 @RequestMapping(value="/",method=RequestMethod.GET)
	 public ModelAndView index(ModelMap model) throws FileNotFoundException, IOException, ParseException
	 {
		model.addAttribute("countryList",this.countryService.getCountryList());
		model.addAttribute("genderList",this.GenderService.getGenderList());
		return new ModelAndView("home","user",new User());
	 }
	@SuppressWarnings("unchecked")
	@RequestMapping(value="/getStatesByCountry", method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
	 public List<JSONObject> getStatesByCountry(Model model,@RequestParam int countryid){
		List<State> states = stateService.getSatesByCountryId(countryid);
		
		List<JSONObject> entities = new ArrayList<JSONObject>();
		
		for (State n : states) {
	        JSONObject entity = new JSONObject();
	        entity.put("id", n.getId());
	        entity.put("name", n.getName());
	        entities.add(entity);
	    }
		return  entities;
	}
	@SuppressWarnings("unchecked")
	@RequestMapping(value="/getCitiesByState", method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
	 public List<JSONObject> getCitiesByState(Model model,@RequestParam int stateid){
		List<City> cities = cityService.getCitiesByStateId(stateid);
		
		List<JSONObject> entities = new ArrayList<JSONObject>();
		
		for (City n : cities) {
	        JSONObject entity = new JSONObject();
	        entity.put("id", n.getId());
	        entity.put("name", n.getName());
	        entities.add(entity);
	    }
		return  entities;
	}	
	
	@RequestMapping(value="/validUsername", method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
	 public String validUsername(Model model,@RequestParam String username){
		User u = userService.getUserList(username);
		String  str;
	        if(u==null){
	        	str="false";
	        }else
	        {
	        	str="true";
	        }
		return  str;
	}
	@RequestMapping(value="/submitRegForm", method=RequestMethod.POST,produces=MediaType.APPLICATION_JSON_VALUE)
	 public String submitRegForm(Model model,MultipartHttpServletRequest request, HttpServletResponse response){
		MultipartFile mpf = request.getFile("photo");
		System.out.println("Photo :- "+mpf.getOriginalFilename());
		System.out.println("Name :- "+request.getParameter("name"));
		return  "hi";
	}
}
