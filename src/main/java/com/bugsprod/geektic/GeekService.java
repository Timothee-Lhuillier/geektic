package com.bugsprod.geektic;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GeekService {

	@Autowired
	private GeekDao gDao;
	
	public GeekService() {
		super();
	}
	
	public GeekService(GeekDao gDao) {
		super();
		this.gDao = gDao;
	}
	
	public List<Geek> getAllGeeks(){
		return gDao.findAll();
	}
	
	public Geek getGeek(Long id){
		return gDao.findById(id);
	}
	
	public List<Geek> searchGeek(boolean gender, List<Interest> interests, String cities) {
		return gDao.find(gender, interests, cities);
	}

}