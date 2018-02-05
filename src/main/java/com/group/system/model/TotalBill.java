package com.group.system.model;

public class TotalBill {

	private double total;

	public TotalBill() {
		
	}
	public TotalBill(double total) {
		this.total = total;
	}
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("TotalFactura [total=");
		builder.append(total);
		builder.append("]");
		return builder.toString();
	}
	
}
