package com.bugsprod.geektic;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bugsprod.model.City;
import com.bugsprod.model.Geek;
import com.bugsprod.model.Interest;


@Controller
public class GeekAPI {
	
	@Autowired
	private GeekService gServ;
	
	@RequestMapping(value="/api/geeks", method=RequestMethod.GET)
	public @ResponseBody List<Geek> allGeeks(){
		return gServ.getAllGeeks();
	}
	
	@RequestMapping(value="/api/geek/{id}", method=RequestMethod.GET)
	public @ResponseBody Geek geekById(@PathVariable("id") Long id, HttpServletRequest request){
		return gServ.findGeekById(id, request.getRemoteAddr());
	}
	
	@RequestMapping(value="/api/findGeeks/gender/{gender}/interests/{interests}/cities/{cities}", method=RequestMethod.GET)
	public @ResponseBody List<Geek> findGeeks(@PathVariable("gender") String gender,
			@PathVariable("interests") String interests,
			@PathVariable("cities") String cities){
		return gServ.findGeeks(gender, interests, cities);
	}
	
	@RequestMapping(value="/api/findLuckyGeek/gender/{gender}/interests/{interests}/cities/{cities}", method=RequestMethod.GET)
	public @ResponseBody Geek findLuckyGeek(@PathVariable("gender") String gender,
			@PathVariable("interests") String interests,
			@PathVariable("cities") String cities,
			HttpServletRequest request){
		return gServ.findLuckyGeek(gender, interests, cities, request.getRemoteAddr());
	}
	
	@RequestMapping(value="/api/cities", method=RequestMethod.GET)
	public @ResponseBody List<City> allCities(){
		return gServ.getAllCities();
	}
	
	@RequestMapping(value="/api/interests", method=RequestMethod.GET)
	public @ResponseBody List<Interest> allInterests(){
		return gServ.getAllInterests();
	}
}
