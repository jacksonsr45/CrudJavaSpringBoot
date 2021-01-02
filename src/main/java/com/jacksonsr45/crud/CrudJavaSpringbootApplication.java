package com.jacksonsr45.crud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication(scanBasePackages = "com.jacksonsr45.crud")
@EntityScan(basePackages = "com.jacksonsr45.crud.domain.model")
public class CrudJavaSpringbootApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrudJavaSpringbootApplication.class, args);
	}

}
