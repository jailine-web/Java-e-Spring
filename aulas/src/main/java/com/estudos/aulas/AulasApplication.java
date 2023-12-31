package com.estudos.aulas;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.estudos.aulas.entities.Employee;
import com.estudos.aulas.services.SalaryService;

@SpringBootApplication
public class AulasApplication implements CommandLineRunner {

	@Autowired
	private SalaryService salaryService;

	public static void main(String[] args) {
		SpringApplication.run(AulasApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Employee employee = new Employee("Maria", 4000.00);
		System.out.println("Net salary:"+ salaryService.netSalary(employee));
	}

}
