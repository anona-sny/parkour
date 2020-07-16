package com.anona.parkour;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
public class ParkourApplication {

	public static void main(String[] args) {
		SpringApplication.run(ParkourApplication.class, args);
	}

}
