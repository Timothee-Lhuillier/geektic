package com.bugsprod.geektic;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class GeekDao {

	@PersistenceContext
	private EntityManager em;

	public GeekDao() {
		super();
	}

	public GeekDao(EntityManager em) {
		super();
		this.em = em;
	}

	public List<Geek> findAllGeeks() {
		String query = "select g from Geek g order by g.city";
		TypedQuery<Geek> q = em.createQuery(query, Geek.class);
		return q.getResultList();
	}

	public Geek findGeekById(Long id) {
		return em.find(Geek.class, id);
	}

	public String interestsToQuery(String[] interests) {
		String query = "";
		if (interests != null) {
			for (int i = 0; i < (interests.length); i++) {
				query += " and :interest" + String.valueOf(i)
						+ " in (select i.interest from g.interests i)";
			}
		}
		return query;
	}
	
	public String citiesToQuery(String[] cities) {
		String query = "";
		if (cities != null) {
			query += " and g.city.city in (";
			for (int i = 0; i < (cities.length); i++) {
				if (i > 0) {
					query += ", ";
				}
				query += ":city" + String.valueOf(i);
			}
			query += ")";
		}
		return query;
	}
	
	public void setParams(TypedQuery<Geek> q, String nameParams, String[] params) {
		if (params != null) {
			for (int i = 0; i < params.length; i++) {
				q.setParameter(nameParams + String.valueOf(i), params[i]);
			}
		}
	}
	
	public TypedQuery<Geek> queryFindGeek(boolean gender, String[] interests, String[] cities) {
		String query = "select g from Geek g where " + "g.gender = :gender";
		query += interestsToQuery(interests);
		query += citiesToQuery(cities);
		query += " order by (select count(*) from View v where v.geek=g)*1 desc";
		TypedQuery<Geek> q = em.createQuery(query, Geek.class);
		q.setParameter("gender", gender);
		setParams(q, "interest", interests);
		setParams(q, "city", cities);
		return q;
	}
	
	public List<Geek> findGeeks(boolean gender, String[] interests, String[] cities) {
		TypedQuery<Geek> q = queryFindGeek(gender, interests, cities);
		return q.getResultList();
	}

	public Geek findLuckyGeek(boolean gender, String[] interests, String[] cities) {
		TypedQuery<Geek> q = queryFindGeek(gender, interests, cities);
		return q.getSingleResult();
	}

	public List<City> findAllCities() {
		String query = "select c from City c";
		TypedQuery<City> q = em.createQuery(query, City.class);
		return q.getResultList();
	}

	public List<Interest> findAllInterests() {
		String query = "select i from Interest i";
		TypedQuery<Interest> q = em.createQuery(query, Interest.class);
		return q.getResultList();
	}
	
	@Transactional(propagation=Propagation.REQUIRED)
	public void addView(View view) {
		em.persist(view);
	}
}
