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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="method_payment")
public class MethodPayment implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private Integer methodPaymentId;
	private String name;
	private boolean active;
	private Date created;
	private Date updated;
	private List<Bill> bills = new ArrayList<Bill>();
	
	public MethodPayment() {
		super();
	}

	public MethodPayment(Integer methodPaymentId, String name, boolean active, Date created, Date updated,
			List<Bill> bills) {
		super();
		this.methodPaymentId = methodPaymentId;
		this.name = name;
		this.active = active;
		this.created = created;
		this.updated = updated;
		this.bills = bills;
	}

	@Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="method_payment_id", nullable=false)
	public Integer getMethodPayment() {
		return methodPaymentId;
	}

	public void setMethodPayment(Integer methodPaymentId) {
		this.methodPaymentId = methodPaymentId;
	}

	@Column(name="name")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name="active")
	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	@Temporal(TemporalType.TIMESTAMP)
    @Column(name="created", length=19)
	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	@Temporal(TemporalType.TIMESTAMP)
    @Column(name="updated", length=19)
	public Date getUpdated() {
		return updated;
	}

	public void setUpdated(Date updated) {
		this.updated = updated;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "methodPayment")
    @JsonIgnore
	public List<Bill> getBills() {
		return bills;
	}

	public void setBills(List<Bill> bills) {
		this.bills = bills;
	}

}
