package com.devsuperior.dsmeta;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.devsuperior.dsmeta.dto.SaleMinDTO;
import com.devsuperior.dsmeta.repositories.SaleRepository;

@SpringBootApplication
public class DsmetaApplication implements CommandLineRunner {

	@Autowired
	private SaleRepository repository;
	
	private Pageable pageable;
	
	public static void main(String[] args) {
		SpringApplication.run(DsmetaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Page<SaleMinDTO> page = repository.searchReportJpql(LocalDate.parse("2022-05-01"), 
				LocalDate.parse("2022-05-30"), "odinson", pageable);
		
		System.out.println("Início da consulta JPQL");
		
		for(SaleMinDTO s : page) {
			System.out.println(s);
		}
		System.out.println("Fim da consulta JPQL");
	}

}
