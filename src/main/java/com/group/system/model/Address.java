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
@Table(name="address")
public class Address implements Serializable {

	private static final long serialVersionUID = 1L;
	private Integer addressId;
	private Country country;
	private City city;
	private Departament departament;
	private String address1;
	private String address2;
	private int code;
	private Date lastUpdate;
	private List<Customer> customerList = new ArrayList<Customer>();
	
	public Address() {
		super();
	}

	public Address(Integer addressId, Country country, City city, Departament departament, String address1,
			String address2, int code, Date lastUpdate, List<Customer> customerList) {
		super();
		this.addressId = addressId;
		this.country = country;
		this.city = city;
		this.departament = departament;
		this.address1 = address1;
		this.address2 = address2;
		this.code = code;
		this.lastUpdate = lastUpdate;
		this.customerList = customerList;
	}

	@Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="address_id", nullable=false)
	public Integer getAddressId() {
		return addressId;
	}

	public void setAddressId(Integer addressId) {
		this.addressId = addressId;
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

	@ManyToOne
    @JoinColumn(name="departament_id", nullable=false)
	public Departament getDepartament() {
		return departament;
	}

	public void setDepartament(Departament departament) {
		this.departament = departament;
	}

	@Column(name="address1")
	public String getAddress1() {
		return address1;
	}

	public void setAddress1(String address1) {
		this.address1 = address1;
	}

	@Column(name="address2")
	public String getAddress2() {
		return address2;
	}

	public void setAddress2(String address2) {
		this.address2 = address2;
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

	@OneToMany(fetch=FetchType.LAZY, mappedBy="address")
    @JsonIgnore
	public List<Customer> getCustomerList() {
		return customerList;
	}

	public void setCustomerList(List<Customer> customerList) {
		this.customerList = customerList;
	}
	
}
