package com.electricitybillgenerator.ElectricityBillGenerator.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.electricitybillgenerator.ElectricityBillGenerator.entity.Admin;

public interface AdminRepository extends JpaRepository<Admin, String> {
}
