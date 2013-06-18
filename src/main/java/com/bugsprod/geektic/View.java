package com.bugsprod.geektic;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class View implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@ManyToOne
	@JoinColumn(name = "ID_GEEK", referencedColumnName = "id")
	Geek geek;
	@Id
	Timestamp timestampView;
	@Id
	String ip;

	public View() {
	}
	
	public View(Geek geek, String ip) {
		this.geek = geek;
		this.ip = ip;
		Date currentTime = new Date();
		this.timestampView = new Timestamp(currentTime.getTime());
	}

	public Timestamp getTimestampView() {
		return timestampView;
	}

	public void setTimestampView(Timestamp timestampView) {
		this.timestampView = timestampView;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}
}
