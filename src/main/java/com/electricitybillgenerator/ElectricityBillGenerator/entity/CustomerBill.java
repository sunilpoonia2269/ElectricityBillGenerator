package com.electricitybillgenerator.ElectricityBillGenerator.entity;

import java.time.Month;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "customer_bill")
public class CustomerBill {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	@Column(nullable = false)
	private Month month;

	@Column(nullable = false)
	private Integer unit;
	@Column(nullable = false)
	private Double totalBill;

	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
	@JoinColumn(name = "customer_id", nullable = false)
	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	private Customer customer;

	public CustomerBill() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CustomerBill(Month month, Integer unit, Customer customer) {
		super();
		this.month = month;
		this.unit = unit;
		this.customer = customer;
	}

	public Integer getId() {
		return id;
	}

	public Month getMonth() {
		return month;
	}

	public void setMonth(Month month) {
		this.month = month;
	}

	public Integer getUnit() {
		return unit;
	}

	public void setUnit(Integer unit) {
		this.unit = unit;
	}

	public Double getTotalBill() {
		return totalBill;
	}

	public void setTotalBill(Double totalBill) {
		this.totalBill = totalBill;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

}
