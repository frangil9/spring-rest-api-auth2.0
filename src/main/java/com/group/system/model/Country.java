package com.group.system.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="country")
public class Country implements Serializable{

	private static final long serialVersionUID = 1L;
	private Integer counrtyId;
	private String name;
	private String description;
	private int code;
	private Date lastUpdate;
	private List<City> cities = new ArrayList<City>();
	
	public Country() {
	}

	public Country(Integer counrtyId, String name, String description, int code, Date lastUpdate, List<City> cities) {
		super();
		this.counrtyId = counrtyId;
		this.name = name;
		this.description = description;
		this.code = code;
		this.lastUpdate = lastUpdate;
		this.cities = cities;
	}

	@Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="country_id", nullable=false)
	public Integer getCounrtyId() {
		return counrtyId;
	}

	public void setCounrtyId(Integer counrtyId) {
		this.counrtyId = counrtyId;
	}

	@Column(name="name")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name="description")
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Column(name="code")
	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	@Column(name="last_update")
	public Date getLastUpdate() {
		return lastUpdate;
	}

	public void setLastUpdate(Date lastUpdate) {
		this.lastUpdate = lastUpdate;
	}

	@OneToMany(fetch=FetchType.LAZY, mappedBy="country")
    @JsonIgnore
	public List<City> getCities() {
		return cities;
	}

	public void setCities(List<City> cities) {
		this.cities = cities;
	}
	
}
