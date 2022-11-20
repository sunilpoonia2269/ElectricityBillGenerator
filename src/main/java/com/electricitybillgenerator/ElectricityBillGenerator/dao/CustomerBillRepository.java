package com.electricitybillgenerator.ElectricityBillGenerator.dao;

import java.time.Month;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.electricitybillgenerator.ElectricityBillGenerator.entity.CustomerBill;

public interface CustomerBillRepository extends JpaRepository<CustomerBill, Integer> {

	@Query("SELECT bill FROM CustomerBill bill WHERE bill.customer.id=?1")
	public List<CustomerBill> findByCustomerId(Integer id);

	@Query("SELECT bill FROM CustomerBill bill WHERE bill.month=?1")
	public List<CustomerBill> findByMonth(Month month);

	@Query("SELECT SUM(bill.totalBill) From CustomerBill bill WHERE bill.month=?1")
	public Double findTotalBillOfAllCustomerByMonth(Month month);

	@Query("SELECT bill FROM CustomerBill bill WHERE bill.customer.id=?1 AND bill.month=?2")
	public List<CustomerBill> findCustomerByMonth(Integer id, Month month);
}
