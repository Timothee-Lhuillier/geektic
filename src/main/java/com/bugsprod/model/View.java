package com.bugsprod.model;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.codehaus.jackson.annotate.JsonBackReference;


@Entity
public class View implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@ManyToOne
	@JoinColumn(name = "ID_GEEK", referencedColumnName = "id")
	@JsonBackReference("views")
	Geek geek;
	@Id
	Timestamp timestampView;
	@Id
	String ip;

	public View() {
	}
	
	public View(Geek geek, String ip) {
		setGeek(geek);
		this.ip = ip;
		Date currentTime = new Date();
		this.timestampView = new Timestamp(currentTime.getTime());
	}

	public View(Geek geek, String ip, Timestamp timestamp) {
		setGeek(geek);
		this.ip = ip;
		this.timestampView = timestamp;
	}

	public Timestamp getTimestamp() {
		return timestampView;
	}

	public void setTimestamp(Timestamp timestampView) {
		this.timestampView = timestampView;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public void setGeek(Geek newGeek) {
		if (this.geek!=null) {
			this.geek.getViews().remove(this);
		}
		if (newGeek!=null) {
			if (newGeek.getViews()==null) {
				newGeek.setViews(new ArrayList<View>());
			}
			newGeek.getViews().add(this);
		}
		this.geek = newGeek;
	}

	public Geek getGeek() {
		return this.geek;
	}
}
