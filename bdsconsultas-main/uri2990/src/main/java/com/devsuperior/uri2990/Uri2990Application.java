package com.devsuperior.uri2990;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.devsuperior.uri2990.dto.EmpregadoDeptDTO;
import com.devsuperior.uri2990.projections.EmpregadoDeptProjection;
import com.devsuperior.uri2990.repositories.EmpregadoRepository;

@SpringBootApplication
public class Uri2990Application implements CommandLineRunner {

	@Autowired
	private EmpregadoRepository repository;
	
	public static void main(String[] args) {
		SpringApplication.run(Uri2990Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		List<EmpregadoDeptProjection> list = repository.search();
		List<EmpregadoDeptDTO>  result = list.stream().map(x -> new EmpregadoDeptDTO(x)).collect(Collectors.toList());
		
		System.out.println("\n\nConsulta SQL Raiz - comando NOT IN");
		for(EmpregadoDeptDTO emp: result) {
			System.out.println(emp);
		}
		
		
		List<EmpregadoDeptDTO> result2 = repository.searchJPQL();
		
		System.out.println("\n\nConsulta JPQL");
		for(EmpregadoDeptDTO emp: result2) {
			System.out.println(emp);
		}
		
		List<EmpregadoDeptProjection> list2 = repository.searchSQLeft();
		List<EmpregadoDeptDTO>  result3 = list2.stream().map(x -> new EmpregadoDeptDTO(x))
				.collect(Collectors.toList());
		
		System.out.println("\n\nConsulta SQL com o comando left");
		for(EmpregadoDeptDTO emp: result3) {
			System.out.println(emp);
		}
		
	}
}
