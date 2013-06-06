package com.bugsprod.geektic;

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

	public List<Geek> findAll(){
		String query="select g from Geek g";
		TypedQuery<Geek> q = entityManager.createQuery(query, Geek.class);
		return q.getResultList();
	}
	
	public Geek findById(Long id){
		return entityManager.find(Geek.class, id);
	}
	
	public List<Geek> find(boolean gender, String interests, String cities){
		String query="select g from Geek g join g.insterests i where g.gender = :gender and :interests = i.interest";
		TypedQuery<Geek> q = entityManager.createQuery(query, Geek.class);
		q.setParameter("gender", gender);
		q.setParameter("interests", interests);
		return q.getResultList();
	}
	
	public List<Geek> findByGender(boolean gender){
		String query="select g from Geek g where g.gender = :gender";
		TypedQuery<Geek> q = entityManager.createQuery(query, Geek.class);
		q.setParameter("gender", gender);
		return q.getResultList();
	}
	
	public void persist(Geek newGeek){
		entityManager.persist(newGeek);
	}
}
