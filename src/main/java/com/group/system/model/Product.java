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
@Table(name="product")
public class Product implements Serializable {
    
	private static final long serialVersionUID = 1L;
	
	@Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="product_id", nullable=false)
    private Integer productoId;
	
    @ManyToOne
    @JoinColumn(name="category_id", nullable=false)
    private Category category;
    
    @Column(name="name")
    private String name;
    
    @Column(name="price")
    private double price;
    
    @Column(name="coste")
    private double coste;
    
    @Column(name="stock")
    private int stock;
    
    @Column(name="stock_min")
    private int stockMin;
    
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="created", length=19)
    private Date created;
    
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="updated", length=19)
    private Date updated;
    
    @Column(name="active")
    private boolean active;
    
    @OneToMany(fetch=FetchType.LAZY, mappedBy="product")
    @JsonIgnore
    private List<BillProduct> billProducts = new ArrayList<BillProduct>();

	public Product() {
		super();
	}

	public Product(Integer productoId, Category category, String name, double price, double coste, int stock,
			int stockMin, Date created, Date updated, boolean active, List<BillProduct> billProducts) {
		super();
		this.productoId = productoId;
		this.category = category;
		this.name = name;
		this.price = price;
		this.coste = coste;
		this.stock = stock;
		this.stockMin = stockMin;
		this.created = created;
		this.updated = updated;
		this.active = active;
		this.billProducts = billProducts;
	}

	public Integer getProductoId() {
		return productoId;
	}

	public void setProductoId(Integer productoId) {
		this.productoId = productoId;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public double getCoste() {
		return coste;
	}

	public void setCoste(double coste) {
		this.coste = coste;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public int getStockMin() {
		return stockMin;
	}

	public void setStockMin(int stockMin) {
		this.stockMin = stockMin;
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

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public List<BillProduct> getBillProducts() {
		return billProducts;
	}

	public void setBillProducts(List<BillProduct> billProducts) {
		this.billProducts = billProducts;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
    
}
