package com.electricitybillgenerator.ElectricityBillGenerator.dao;

import org.springframework.data.repository.CrudRepository;

import com.electricitybillgenerator.ElectricityBillGenerator.entity.Customer;

public interface CustomerRepository extends CrudRepository<Customer,Integer>{

}
