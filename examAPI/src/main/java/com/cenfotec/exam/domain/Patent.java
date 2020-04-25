package com.cenfotec.exam.domain;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;

public class Patent {

	@Id
	private String id;
	private String guid;
	private String spice_name;
	private String discovered_name;
	private Date entry_date;
	private String microorganism;

	@Transient
	private SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");

	public Patent() {

	}

	public Patent(String spice_name, String discovered_name, String micro) {
		this.spice_name = spice_name;
	 this.guid = UUID.randomUUID().toString();
		this.discovered_name = discovered_name;
		this.microorganism = micro;
		this.entry_date = new Date();
	}



	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setMicroorganism(String microorganism) {
		this.microorganism = microorganism;
	}

	public String getCreatedAsShort() {
		return format.format(entry_date);
	}

	public void setGuid(String guid) {
		this.guid = guid;
	}

	public String getGuid() {
		return this.guid;
	}

	public String getSpice_name() {
		return spice_name;
	}

	public void setSpice_name(String spice_name) {
		this.spice_name = spice_name;
	}

	public String getDiscovered_name() {
		return discovered_name;
	}

	public void setDiscovered_name(String discovered_name) {
		this.discovered_name = discovered_name;
	}

	public Date getEntry_date() {
		return entry_date;
	}

	public void setEntry_date(Date entry_date) {
		this.entry_date = entry_date;
	}


	public SimpleDateFormat getFormat() {
		return format;
	}

	public void setFormat(SimpleDateFormat format) {
		this.format = format;
	}

}
