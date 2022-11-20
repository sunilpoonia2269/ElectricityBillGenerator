package com.electricitybillgenerator.ElectricityBillGenerator.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.electricitybillgenerator.ElectricityBillGenerator.entity.Customer;
import com.electricitybillgenerator.ElectricityBillGenerator.service.CustomerService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/customer")
public class CustomerController {

	@Autowired
	CustomerService service;

	@GetMapping("/getAll")
	public ResponseEntity<List<Customer>> getAll() {
		return service.getAll();
	}

	@PostMapping("/addCustomer")
	public ResponseEntity<Customer> addCustomer(@RequestBody Customer customer) {
		return service.addCustomer(customer);
	}

}
