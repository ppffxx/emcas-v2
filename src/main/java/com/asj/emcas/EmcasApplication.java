package com.asj.emcas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = { "com.asj.emcas", "com.asj.emcas.servicio"})
public class EmcasApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmcasApplication.class, args);
	}

}
