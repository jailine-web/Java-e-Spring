package com.devsuperior.aula.DTO;

import com.devsuperior.aula.entities.Person;

public class PersonDepartmentDTO {

	private Long id;
	private String name;
	private Double salary;
	
	DepartmentDTO departmentDTO;

	public PersonDepartmentDTO(Long id, String name, Double salary, 
			DepartmentDTO departmentDTO) {
		this.id = id;
		this.name = name;
		salary = salary;
		this.departmentDTO = departmentDTO;
	}

	public PersonDepartmentDTO(Person person) {
		id = person.getId();
		name = person.getName();
		salary = person.getSalary();
		departmentDTO = new DepartmentDTO(person.getDepartment());
	}
	
	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public Double getSalary() {
		return salary;
	}

	public DepartmentDTO getDepartmentDTO() {
		return departmentDTO;
	}
	
}
