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

	public List<Geek> getAllGeeks() {
		return gDao.findAllGeeks();
	}

	public Geek findGeekById(Long id, String ip) {
		Geek geek = gDao.findGeekById(id);
		gDao.addView(new View(geek, ip));
		return geek;
	}

	public List<Geek> findGeeks(String gender, String interests, String cities) {
		return gDao.findGeeks(
						Boolean.valueOf(gender),
						interests == null || interests.equals("") ? null : interests.split(", "),
						cities == null || cities.equals("") ? null : cities.split(", "));
	}

	public List<City> getAllCities() {
		return gDao.findAllCities();
	}

	public List<Interest> getAllInterest() {
		return gDao.findAllInterests();
	}

}