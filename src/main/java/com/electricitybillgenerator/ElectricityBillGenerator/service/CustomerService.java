package com.electricitybillgenerator.ElectricityBillGenerator.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.electricitybillgenerator.ElectricityBillGenerator.dao.CustomerRepository;
import com.electricitybillgenerator.ElectricityBillGenerator.entity.Customer;

@Service
public class CustomerService {

	@Autowired
	CustomerRepository crud;
	
	public ResponseEntity<List<Customer>> getAll(){
			
			try {
				List<Customer> customers = new ArrayList<>();
				crud.findAll().forEach(customers::add);
	
				if (customers.isEmpty()) {
					return new ResponseEntity<>(HttpStatus.NO_CONTENT);
				}
	
				return new ResponseEntity<>(customers, HttpStatus.OK);
			}
			catch(Exception e) {
				return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}
		

	public ResponseEntity<Customer> addCustomer(@RequestBody Customer customer) {
		try {
				Customer savedcustomer = crud.save(customer);
				return new ResponseEntity<>(savedcustomer,HttpStatus.CREATED);
				
		}
		catch(Exception e) {
			return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}	
