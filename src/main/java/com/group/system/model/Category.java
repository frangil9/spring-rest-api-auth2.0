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
@Table(name="category")
public class Category implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private Integer categoryId;
	private String name;
	private String description;
	private boolean active;
	private Date created;
	private Date updated;
	private List<Product> categoryList = new ArrayList<Product>();
	
	public Category() {
	}

	public Category(Integer categoryId, String name, String description, boolean active, Date created, Date updated,
			List<Product> categoryList) {
		super();
		this.categoryId = categoryId;
		this.name = name;
		this.description = description;
		this.active = active;
		this.created = created;
		this.updated = updated;
		this.categoryList = categoryList;
	}

	@Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="category_id", nullable=false)
	public Integer getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
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

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "category")
    @JsonIgnore
	public List<Product> getNdCategorySists() {
		return categoryList;
	}

	public void setNdCategorySists(List<Product> categoryList) {
		this.categoryList = categoryList;
	}

}
