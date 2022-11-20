package com.electricitybillgenerator.ElectricityBillGenerator.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.electricitybillgenerator.ElectricityBillGenerator.dao.AdminRepository;
import com.electricitybillgenerator.ElectricityBillGenerator.entity.Admin;

@Service
public class CustomUserDetailService implements UserDetailsService {

    @Autowired
    private AdminRepository repository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Admin admin = this.repository.findById(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));
        return admin;
    }

}
