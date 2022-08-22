package de.example.mockito;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class MockitoApplication {

	public static void main(String[] args) {
		SpringApplication.run(MockitoApplication.class, args);
	}

}
