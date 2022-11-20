package com.electricitybillgenerator.ElectricityBillGenerator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
@EnableJpaRepositories
public class ElectricityBillGeneratorApplication implements CommandLineRunner {

	@Autowired
	private PasswordEncoder passwordEncoder;

	public static void main(String[] args) {
		SpringApplication.run(ElectricityBillGeneratorApplication.class, args);
	}

	//// username - suni@dev.in passoword - 123 encpassword -
	//// $2a$10$Te66xAF2mHVfJfuviLWvt.dLGgXgLu9wOykQhi1iDpqqq37pBS5Ga
	//// username - vishal@dev.in password - 789 encPassword -
	//// $2a$10$GU8hMwnvmDdEaNlKYD05R.O.Sjn7nPupbe5hHw92MoT4MtBCFGjQi
	@Override
	public void run(String... args) throws Exception {
		System.out.println(this.passwordEncoder.encode("789"));
	}

}
