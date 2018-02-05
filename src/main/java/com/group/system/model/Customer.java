package com.group.system.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by fran.
 */

@Entity
@Table(name="customer")
public class Customer implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="customer_id", nullable=false)
    private Integer customerId;
    
    @Column(name="document")
    private String document;
    
    @Column(name="name")
    private String name;
    
    @Column(name="last_name")
    private String last_name;
    
    @ManyToOne
    @JoinColumn(name="address_id", nullable=false)
    private Address address;
    
    @Column(name="phone")
    private String phone;
    
    @Column(name="email")
    private String email;
    
    @Column(name="active")
    private boolean active;
    
    @Column(name="created")
    private Date created;
    
    @Column(name="updated")
    private Date updated;
    
    @OneToMany(fetch=FetchType.LAZY, mappedBy="customer")
    @JsonIgnore
    private List<Bill> bills = new ArrayList<Bill>();

	public Customer() {
		super();
	}

	public Customer(Integer customerId, String document, String name, String last_name, Address address, String phone,
			String email, boolean active, Date created, Date updated, List<Bill> bills) {
		super();
		this.customerId = customerId;
		this.document = document;
		this.name = name;
		this.last_name = last_name;
		this.address = address;
		this.phone = phone;
		this.email = email;
		this.active = active;
		this.created = created;
		this.updated = updated;
		this.bills = bills;
	}

	public Integer getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}

	public String getDocument() {
		return document;
	}

	public void setDocument(String document) {
		this.document = document;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	public Date getUpdated() {
		return updated;
	}

	public void setUpdated(Date updated) {
		this.updated = updated;
	}

	public List<Bill> getBills() {
		return bills;
	}

	public void setBills(List<Bill> bills) {
		this.bills = bills;
	}

   }

	