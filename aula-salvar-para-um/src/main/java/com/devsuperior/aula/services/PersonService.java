package com.devsuperior.aula.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devsuperior.aula.DTO.PersonDepartmentDTO;
import com.devsuperior.aula.entities.Department;
import com.devsuperior.aula.entities.Person;
import com.devsuperior.aula.repositories.DepartmentRepository;
import com.devsuperior.aula.repositories.PersonRepository;

@Service
public class PersonService {
	
	@Autowired
	PersonRepository personRepository;

	@Autowired
	DepartmentRepository departmentRepository;
	
	public PersonDepartmentDTO insert(PersonDepartmentDTO personDepartmentDTO) {
		
		Person entity = new Person();
		entity.setName(personDepartmentDTO.getName());
		entity.setSalary(personDepartmentDTO.getSalary());
		
		Department dpt = departmentRepository.getReferenceById(personDepartmentDTO
				.getDepartamentDTO().getId());
		
		/* Sem a referência do objeto - o campo name fica nullo
		 * Department dpt = new Department();
		 * dpt.setId(personDepartmentDTO.getDepartamentDTO().getId());
		*/
		
		entity.setDepartment(dpt);
		
		entity = personRepository.save(entity);
		
		return new PersonDepartmentDTO(entity);
	}
}
