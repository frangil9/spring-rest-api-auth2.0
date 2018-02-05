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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="city")
public class City implements Serializable{

	private static final long serialVersionUID = 1L;
	private Integer cityId;
	private Country country;
	private String name;
	private String description;
	private int code;
	private Date lastUpdate;
	private List<Departament> departament = new ArrayList<Departament>();
	
	public City() {
	}

	public City(Integer cityId, Country country, String name, String description, int code, Date lastUpdate,
			List<Departament> departament) {
		super();
		this.cityId = cityId;
		this.country = country;
		this.name = name;
		this.description = description;
		this.code = code;
		this.lastUpdate = lastUpdate;
		this.departament = departament;
	}

	@Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="city_id", nullable=false)
	public Integer getCityId() {
		return cityId;
	}

	public void setCityId(Integer cityId) {
		this.cityId = cityId;
	}

	@ManyToOne
    @JoinColumn(name="country_id", nullable=false)
	public Country getCountry() {
		return country;
	}

	public void setCountry(Country country) {
		this.country = country;
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

	@OneToMany(fetch=FetchType.LAZY, mappedBy="city")
    @JsonIgnore
	public List<Departament> getDepartament() {
		return departament;
	}

	public void setDepartament(List<Departament> districts) {
		this.departament = districts;
	}
	
}
