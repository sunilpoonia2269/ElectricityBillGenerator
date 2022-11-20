package com.electricitybillgenerator.ElectricityBillGenerator.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.electricitybillgenerator.ElectricityBillGenerator.enums.CustomerType;

@Entity
@Table(name = "customer_detail")
public class Customer {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String name;
	private CustomerType type;

	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Customer(String name, CustomerType type) {
		super();
		this.name = name;
		this.type = type;
	}

	public Customer(int id) {
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public CustomerType getType() {
		return type;
	}

	public void setType(CustomerType type) {
		this.type = type;
	}

}
