package com.electricitybillgenerator.ElectricityBillGenerator.controller;

import java.time.Month;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.electricitybillgenerator.ElectricityBillGenerator.entity.CustomerBill;
import com.electricitybillgenerator.ElectricityBillGenerator.entity.TotalBill;
import com.electricitybillgenerator.ElectricityBillGenerator.service.CustomerBillService;

@RestController
@RequestMapping("/bill")
@CrossOrigin(origins = "*")
public class CustomerBillController {

	@Autowired
	CustomerBillService service;

	@PostMapping("/addBill")
	public ResponseEntity<CustomerBill> addBill(@RequestBody CustomerBill customerBill) {
		return service.addBill(customerBill);
	}

	@GetMapping("/getBill/{customerId}")
	public ResponseEntity<List<CustomerBill>> getBillByCustomerId(@PathVariable("customerId") Integer id) {
		return service.getBillByCustomerId(id);
	}

	@GetMapping("/getCustomerBillByMonth")
	public ResponseEntity<List<CustomerBill>> getBillByMonth(@RequestParam Integer id, @RequestParam Month month) {
		return service.getCustomerBillByMonth(id, month);
	}

	@GetMapping("/getBillByMonth/{month}")
	public ResponseEntity<List<CustomerBill>> getBillByMonth(@PathVariable("month") Month month) {
		return service.getBillByMonth(month);
	}

	@GetMapping("/getTotalBillOfAllCustomerByMonth/{month}")
	public ResponseEntity<TotalBill> getTotalBillOfAllCustomerByMonth(@PathVariable("month") Month month) {
		return service.getTotalBillOfAllCustomerByMonth(month);
	}
}
