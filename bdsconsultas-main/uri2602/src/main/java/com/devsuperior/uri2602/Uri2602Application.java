package com.devsuperior.uri2602;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.devsuperior.uri2602.DTO.CustomerDTO;
import com.devsuperior.uri2602.projections.CustomerProjection;
import com.devsuperior.uri2602.repositories.CustomerRepository;

@SpringBootApplication
public class Uri2602Application implements CommandLineRunner{

	@Autowired
	private CustomerRepository repository;
	
	public static void main(String[] args) {
		SpringApplication.run(Uri2602Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		List<CustomerProjection> list = repository.searchName("rs");
		List<CustomerDTO> result1 = list.stream().map(x -> new CustomerDTO(x))
				.collect(Collectors.toList());
		
		System.out.println("Resultado SQL Raiz: ");
		for(CustomerDTO c: result1) {
			System.out.println(c);
			
		}
		
		System.out.println("\n \n");

		List<CustomerDTO> list2 = repository.searchNameViaJPQL("rs");
		
		System.out.println("Resultado JPQL: ");
		
		for(CustomerDTO c: list2) {
			System.out.println(c);
			
		}
	}
}
