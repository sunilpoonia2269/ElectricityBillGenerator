package com.electricitybillgenerator.ElectricityBillGenerator.service;

import java.time.Month;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.electricitybillgenerator.ElectricityBillGenerator.dao.CustomerBillRepository;
import com.electricitybillgenerator.ElectricityBillGenerator.entity.CustomerBill;
import com.electricitybillgenerator.ElectricityBillGenerator.entity.TotalBill;

@Service
public class CustomerBillService {

	@Autowired
	CustomerBillRepository billRepository;

	// Get bill of a customer by id
	public ResponseEntity<List<CustomerBill>> getBillByCustomerId(Integer id) {
		try {
			List<CustomerBill> customerBills = billRepository.findByCustomerId(id);

			if (customerBills.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}

			return new ResponseEntity<>(customerBills, HttpStatus.OK);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	// Get bill of a particular customer by month
	public ResponseEntity<List<CustomerBill>> getCustomerBillByMonth(Integer id, Month month) {
		try {

			List<CustomerBill> customerBills = billRepository.findCustomerByMonth(id,
					month);

			if (customerBills.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}

			return new ResponseEntity<>(customerBills, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	// Get bill of all customer by month
	public ResponseEntity<List<CustomerBill>> getBillByMonth(Month month) {
		try {

			List<CustomerBill> customerBills = billRepository.findByMonth(month);

			if (customerBills.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}

			return new ResponseEntity<>(customerBills, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	// Get total bill of all customers
	public ResponseEntity<TotalBill> getTotalBillOfAllCustomerByMonth(Month month) {
		try {

			Double totalCustomerBill = billRepository.findTotalBillOfAllCustomerByMonth(month);

			return new ResponseEntity<>(new TotalBill(totalCustomerBill), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	public ResponseEntity<CustomerBill> addBill(CustomerBill customerBill) {
		try {
			customerBill.setTotalBill(this.calculateTotalBill(customerBill.getUnit()));
			CustomerBill savedBill = billRepository.save(customerBill);
			return new ResponseEntity<>(savedBill, HttpStatus.CREATED);

		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	private Double calculateTotalBill(Integer units) {
		Double totalBill = 0.0;

		if (units <= 100)
			totalBill = units * 0.5;

		if (units >= 101 && units <= 150)
			totalBill = (100 * 0.5) + ((units - 100) * 0.75);

		if (units > 150)
			totalBill = (100 * 0.5) + (50 * 0.75) + ((units - 150) * 1);
		return totalBill;
	}

}
