package com.devsuperior.aula.DTO;

import com.devsuperior.aula.entities.Department;

public class DepartmentDTO {

	private Long id;
	private String name;
	
	public DepartmentDTO(Long id, String name) {
		this.id = id;
		this.name = name;
	}

	public DepartmentDTO(Department departament) {
		id = departament.getId();
		name = departament.getName();
	}
	
	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}
	
}
