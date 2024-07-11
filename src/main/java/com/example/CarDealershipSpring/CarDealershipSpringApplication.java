package com.example.CarDealershipSpring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication
public class CarDealershipSpringApplication implements CommandLineRunner {
	@Autowired
	private UserInterface userInterface;

	public static void main(String[] args) {
		SpringApplication.run(CarDealershipSpringApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		userInterface.display();
	}
}
