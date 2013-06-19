package com.bugsprod.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;


@Entity
public class City implements Serializable, Comparable<City> {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "city_generator", sequenceName = "city_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "city_generator")
	private long id;
	private String city;

	@OneToMany(mappedBy = "city")
	private Set<Geek> geeks;

	public City() {
		super();
	}

	public City(long id, String city) {
		super();
		this.id = id;
		this.city = city;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	@Override
	public String toString() {
		return this.city;
	}

	@Override
	public int compareTo(City arg0) {
		return this.city.compareTo(arg0.city);
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == this) {
			return true;
		} else if (obj == null || obj.getClass() != this.getClass()
				&& obj.getClass() != "".getClass()) {
			return false;
		} else if (obj.getClass() == this.getClass()) {
			return this.city.equals(((City) obj).city);
		} else {
			return this.city.equals((String) obj);
		}
	}

	@Override
	public int hashCode() {
		return this.city.hashCode();
	}
}
