package com.bugsprod.geektic;

import java.util.Arrays;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

@Repository
public class GeekDao {

	@PersistenceContext
	private EntityManager entityManager;

	public GeekDao() {
		super();
	}

	public List<Geek> findAll() {
		String query = "select g from Geek g";
		TypedQuery<Geek> q = entityManager.createQuery(query, Geek.class);
		return q.getResultList();
	}

	public Geek findById(Long id) {
		return entityManager.find(Geek.class, id);
	}

	public List<Geek> find(boolean gender, String[] interests, String[] cities) {
		String query = "select g from Geek g where " +
				"g.gender = :gender";
		for (int i = 0; i < (interests.length); i++) {
			query += " and :interest"+String.valueOf(i)+" in (select i.interest from g.interests i)";
		}
		if (cities.length>0 && cities[0]!="") {
			query += " and g.city.city in (";
			for (int i = 0; i < (cities.length); i++) {
				if (i>0){
					query += ", ";
				}
				query += ":city"+String.valueOf(i);
			}
			query += ")";
		}
		TypedQuery<Geek> q = entityManager.createQuery(query, Geek.class);
		q.setParameter("gender", gender);
		for (int i = 0; i < interests.length; i++) {
			q.setParameter("interest"+String.valueOf(i), interests[i]);
		}
		if (cities.length>0 && cities[0]!="") {
			for (int i = 0; i < cities.length; i++) {
				q.setParameter("city"+String.valueOf(i), cities[i]);
			}
		}
		return q.getResultList();
	}

	public List<Geek> findByGender(boolean gender) {
		String query = "select g from Geek g where g.gender = :gender";
		TypedQuery<Geek> q = entityManager.createQuery(query, Geek.class);
		q.setParameter("gender", gender);
		return q.getResultList();
	}
	
	public List<City> findAllCities() {
		String query = "select c from City c";
		TypedQuery<City> q = entityManager.createQuery(query, City.class);
		return q.getResultList();
	}

	public void persist(Geek newGeek) {
		entityManager.persist(newGeek);
	}
}
