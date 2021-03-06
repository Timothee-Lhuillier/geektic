package com.bugsprod.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;

import org.codehaus.jackson.annotate.JsonBackReference;


@Entity
public class Interest implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "interest_generator", sequenceName = "interest_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "interest_generator")
	private long id;
	private String interest;
	
	@ManyToMany(mappedBy = "interests")
	@JsonBackReference("interests")
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

	@Override
	public String toString() {
		return this.interest;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == this) {
			return true;
		} else if (obj == null || obj.getClass() != this.getClass()
				&& obj.getClass() != "".getClass()) {
			return false;
		} else if (obj.getClass() == this.getClass()) {
			return this.interest.equals(((Interest) obj).interest);
		} else {
			return this.interest.equals((String) obj);
		}
	}

	@Override
	public int hashCode() {
		return this.interest.hashCode();
	}
}
