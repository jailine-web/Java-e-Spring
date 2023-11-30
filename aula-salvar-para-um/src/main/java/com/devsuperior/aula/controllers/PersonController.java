package com.devsuperior.aula.controllers;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.devsuperior.aula.DTO.PersonDepartmentDTO;
import com.devsuperior.aula.services.PersonService;

@RestController
@RequestMapping(value="/people")
public class PersonController {

	@Autowired
	private PersonService personService;
	
	@PostMapping
	public ResponseEntity<PersonDepartmentDTO> insertProduct(@RequestBody PersonDepartmentDTO person) {
		person = personService.insert(person);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(person.getId()).toUri();
		return ResponseEntity.created(uri).body(person);
	}
	
}
