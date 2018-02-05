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
@Table(name="bill")
public class Bill implements Serializable {
    
	private static final long serialVersionUID = 1L;
    private Integer billId; 
    private double total; 
    private double tax;  
    private Date created;   
    private Customer customer;
    private MethodPayment methodPayment;
    private List<BillProduct> billProducts = new ArrayList<BillProduct>();
    
	public Bill() {
		super();
	}

	public Bill(Integer billId, double total, double tax, Date created, Customer customer, MethodPayment methodPayment,
			List<BillProduct> billProducts) {
		super();
		this.billId = billId;
		this.total = total;
		this.tax = tax;
		this.created = created;
		this.customer = customer;
		this.methodPayment = methodPayment;
		this.billProducts = billProducts;
	}

	@Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="bill_id", nullable=false)
	public Integer getBillId() {
		return billId;
	}

	public void setBillId(Integer billId) {
		this.billId = billId;
	}

	@Column(name="total")
	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	@Column(name="tax")
	public double getTax() {
		return tax;
	}

	public void setTax(double tax) {
		this.tax = tax;
	}

	@Column(name="created")
	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	@ManyToOne
    @JoinColumn(name = "customer_id")
	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	@ManyToOne
    @JoinColumn(name = "method_payment_id")
	public MethodPayment getMethodPayment() {
		return methodPayment;
	}

	public void setMethodPayment(MethodPayment methodPayment) {
		this.methodPayment = methodPayment;
	}

	@OneToMany(fetch=FetchType.LAZY, mappedBy="bill", cascade = CascadeType.ALL)
    @JsonIgnore
	public List<BillProduct> getBillProducts() {
		return billProducts;
	}

	public void setBillProducts(List<BillProduct> billProducts) {
		this.billProducts = billProducts;
	}
    
}
