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
@Table(name="departament")
public class Departament implements Serializable{

	private static final long serialVersionUID = 1L;
	private Integer departamentId;
	private String name;
	private Country country;
	private City city;
	private String description;
	private int code;
	private Date lastUpdate;
	private List<Address> addressList = new ArrayList<Address>();
	
	public Departament() {
		super();
	}

	public Departament(Integer departamentId, String name, Country country, City city, String description, int code,
			Date lastUpdate, List<Address> addressList) {
		super();
		this.departamentId = departamentId;
		this.name = name;
		this.country = country;
		this.city = city;
		this.description = description;
		this.code = code;
		this.lastUpdate = lastUpdate;
		this.addressList = addressList;
	}

	@Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="departament_id", nullable=false)
	public Integer getDepartamentId() {
		return departamentId;
	}

	public void setDepartamentId(Integer departamentId) {
		this.departamentId = departamentId;
	}

	@Column(name="name")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@ManyToOne
    @JoinColumn(name="country_id", nullable=false)
	public Country getCountry() {
		return country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}

	@ManyToOne
    @JoinColumn(name="city_id", nullable=false)
	public City getCity() {
		return city;
	}

	public void setCity(City city) {
		this.city = city;
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

	@OneToMany(fetch=FetchType.LAZY, mappedBy="departament")
    @JsonIgnore
	public List<Address> getAddressList() {
		return addressList;
	}

	public void setAddressList(List<Address> addressList) {
		this.addressList = addressList;
	}
	
}
