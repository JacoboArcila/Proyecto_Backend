package com.example.arcila_jacobo_backend;

import org.apache.log4j.PropertyConfigurator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.apache.log4j.*;

@SpringBootApplication
public class ArcilaJacoboBackendApplication {

	public static void main(String[] args) {
		PropertyConfigurator.configure("log4j.properties");
		SpringApplication.run(ArcilaJacoboBackendApplication.class, args);
	}

}
