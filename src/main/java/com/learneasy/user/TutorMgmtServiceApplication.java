package com.learneasy.user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//@ComponentScan(basePackages = {"com.learneasy.user.infrastructure.mapper"})
public class TutorMgmtServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(TutorMgmtServiceApplication.class, args);
	}

}
