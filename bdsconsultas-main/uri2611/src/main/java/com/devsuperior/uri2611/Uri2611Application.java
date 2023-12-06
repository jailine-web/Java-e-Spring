package com.devsuperior.uri2611;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.devsuperior.uri2611.projections.MovieProjection;
import com.devsuperior.uri2611.repositories.MovieRepository;

@SpringBootApplication
public class Uri2611Application implements CommandLineRunner{
	
	@Autowired
	private MovieRepository movieRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(Uri2611Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		List<MovieProjection> list = movieRepository.searchArgs("Action");
		List<MovieDTO> result = list.stream().map(x -> new MovieDTO(x)).collect(Collectors.toList());
		
		System.out.println("\nSQL raiz");
		for(MovieDTO m : result) {
			System.out.println(m);
		}
		
		List<MovieDTO> result2 = movieRepository.searchArgsJPQL("Action");
		
		System.out.println("\nResultado da consulta JPQL");
		for(MovieDTO m : result2) {
			System.out.println(m);
		}
	}
}
