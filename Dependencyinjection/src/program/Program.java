package program;

import java.util.Locale;
import java.util.Scanner;

import entities.Employee;
import services.PensionService;
import services.SalaryService;
import services.TaxService;

public class Program {

	public static void main(String[] args) {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		TaxService taxService = new TaxService();
		PensionService pensionService = new PensionService();
		
		System.out.print("Name: ");
		String name = sc.next();
		System.out.print("Gross salary: ");
		double grossSalary = sc.nextDouble();
		
		Employee employee = new Employee(name, grossSalary);
		
		SalaryService salaryService = new SalaryService(taxService, pensionService);
		
		double netSalary = salaryService.netSalary(employee);
		
		System.out.printf("Net Salary: %.2f",netSalary);
		
		sc.close();
		
	}

}
