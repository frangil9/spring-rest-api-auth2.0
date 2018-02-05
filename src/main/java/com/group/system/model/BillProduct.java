package com.group.system.model;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by fran.
 */
@Entity
@Table(name="bill_product")
public class BillProduct implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="bill_product_id", nullable=false)
    private Integer billProductId;
	
    @ManyToOne
    @JoinColumn(name = "bill_id")
    private Bill bill;
    
    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;
    
    @Column(name="quanty")
    private int quanty;
    
    @Column(name="price")
    private double price;
    
    @Column(name="total")
    private double total;

	public BillProduct() {
		super();
	}

	public BillProduct(Integer billProductId, Bill bill, Product product, int quanty, double price, double total) {
		super();
		this.billProductId = billProductId;
		this.bill = bill;
		this.product = product;
		this.quanty = quanty;
		this.price = price;
		this.total = total;
	}

	public Integer getBillProductId() {
		return billProductId;
	}

	public void setBillProductId(Integer billProductId) {
		this.billProductId = billProductId;
	}

	public Bill getBill() {
		return bill;
	}

	public void setBill(Bill bill) {
		this.bill = bill;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public int getQuanty() {
		return quanty;
	}

	public void setQuanty(int quanty) {
		this.quanty = quanty;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

    }
