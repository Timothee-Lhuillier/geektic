package com.bugsprod.geektic;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
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
	private Date dateOfBirth;
	
	@ManyToMany
	@JoinTable(name = "GEEK_INTEREST",
		joinColumns = @JoinColumn(name = "ID_GEEK"),
		inverseJoinColumns = @JoinColumn(name = "ID_INTEREST"))
	private List<Interest> interests;
	
	@ManyToOne
	@JoinColumn(name = "ID_CITY", referencedColumnName = "id")
	private City city;

	public Geek() {
		super();
	}

	public Geek(long id, String name, String firstname) {
		this.id = id;
		this.name = name;
		this.firstname = firstname;
	}

	public long getId() {
		return id;
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

	public List<Interest> getInterests() {
		return interests;
	}

	public void setInterests(List<Interest> insterests) {
		this.interests = insterests;
	}

	public boolean getGender() {
		return gender;
	}
	
	public String getGenderString() {
		if (gender){
			return "geek";
		} else {
			return "geekette";
		}
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

	public City getCity() {
		return city;
	}

	public void setCity(City city) {
		this.city = city;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}
	
	public String getFrDateOfBirth() {
		String[] date = dateOfBirth.toString().split("-");
		return date[2]+"/"+date[1]+"/"+date[0];
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	
}
