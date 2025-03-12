package io.swipepay.cryptoservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CryptoServiceApplication {
	
	//TODO: have to implement logging (AWS CloudWatch ?!?!?)
	
	public static void main(String[] args) {
		SpringApplication.run(CryptoServiceApplication.class, args);
	}
}