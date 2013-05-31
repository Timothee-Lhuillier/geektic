package com.bugsprod.geektic;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;

@Entity
public class Geek implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@SequenceGenerator(name="geek_generator", sequenceName="geek_seq", allocationSize=1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "geek_generator")
	private long id;
	private String name;
	private String firstname;
	private boolean gender;
	private String mail;
	private String city;
	
	@ManyToMany
	@JoinTable(name = "GEEK_INTEREST",
		joinColumns = @JoinColumn(name = "ID_GEEK"),
		inverseJoinColumns = @JoinColumn(name = "ID_INTERESTS"))
	private Set<Interest> insterests;

	public Geek() {
		super();
	}

	public Geek(long id, String name, String firstname) {
		this.id = id;
		this.name = name;
		this.firstname = firstname;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public Set<Interest> getInsterests() {
		return insterests;
	}

	public void setInsterests(Set<Interest> insterests) {
		this.insterests = insterests;
	}

	public boolean getGender() {
		return gender;
	}

	public void setGender(boolean gender) {
		this.gender = gender;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}
	
}
