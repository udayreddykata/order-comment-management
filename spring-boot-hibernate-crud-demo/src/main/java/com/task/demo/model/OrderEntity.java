package com.task.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ORDERS")
public class OrderEntity {

	@Id
	@Column(name = "orderid")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long orderID;

	@Column(name = "ordered_by")
	private String orderBy;
	
	@Column(name = "order_product")
	private String orderProduct;
	
	@Column(name = "order_type")
	private String orderType;

	public Long getOrderID() {
		return orderID;
	}

	public void setOrderID(Long orderID) {
		this.orderID = orderID;
	}

	public String getOrderBy() {
		return orderBy;
	}

	public void setOrderBy(String orderBy) {
		this.orderBy = orderBy;
	}

	public String getOrderProduct() {
		return orderProduct;
	}

	public void setOrderProduct(String orderProduct) {
		this.orderProduct = orderProduct;
	}

	public String getOrderType() {
		return orderType;
	}

	public void setOrderType(String orderType) {
		this.orderType = orderType;
	}
	
	
	
}
