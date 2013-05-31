package com.bugsprod.geektic;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;

@Entity
public class Interest implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@SequenceGenerator(name="interest_generator", sequenceName="interest_seq", allocationSize=1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "interest_generator")
	private long id;
	private String interest;
	
	@ManyToMany(mappedBy = "insterests")
	private Set<Geek> geeks;

	public Interest() {
		super();
	}

	public Interest(long id, String interest) {
		super();
		this.id = id;
		this.interest = interest;
	}

	public String getInterest() {
		return interest;
	}

	public void setInterest(String interest) {
		this.interest = interest;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	
}
