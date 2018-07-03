package br.com.uds.traine.pizzaria.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "br.com.uds")
public class PizzariaApplication {
	public static void main(String[] args) {
		SpringApplication.run(PizzariaApplication.class, args);
	}
}
