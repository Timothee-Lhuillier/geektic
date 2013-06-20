package com.bugsprod.geektic;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bugsprod.model.City;
import com.bugsprod.model.Geek;
import com.bugsprod.model.GeekDao;
import com.bugsprod.model.Interest;
import com.bugsprod.model.View;

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
				split(interests),
				split(cities));
	}

	public Timestamp maxTimestamp(Geek geek) {
		Timestamp maxTimestamp = new Timestamp(0);
		for (View view : geek.getViews()) {
			if (view.getTimestamp().compareTo(maxTimestamp)>0) {
				maxTimestamp = view.getTimestamp();
			}
		}
		return maxTimestamp;
	}
	
	public String[] split(String string) {
		return string == null || string.equals("") ? null : string.split(", ");
	}
	
	public Geek findLuckyGeek(String gender, String interests, String cities, String ip) {
		List<Geek> findedGeeks = gDao.findGeeks(
				Boolean.valueOf(gender),
				split(interests),
				split(cities));
		Geek resultGeek = findedGeeks.get(0);
		Timestamp minMaxTimestamp = new Timestamp((new Date()).getTime());
		Timestamp tmpMaxTimestamp;
		for (Geek geek : findedGeeks) {
			tmpMaxTimestamp = maxTimestamp(geek);
			if (tmpMaxTimestamp.compareTo(minMaxTimestamp)<0) {
				minMaxTimestamp = tmpMaxTimestamp;
				resultGeek = geek;
			}
		}
		gDao.addView(new View(resultGeek, ip));
		return resultGeek;
	}

	public List<City> getAllCities() {
		return gDao.findAllCities();
	}

	public List<Interest> getAllInterests() {
		return gDao.findAllInterests();
	}

}