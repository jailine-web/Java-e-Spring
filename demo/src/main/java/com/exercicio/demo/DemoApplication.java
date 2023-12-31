package com.exercicio.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.exercicio.demo.entities.Order;
import com.exercicio.demo.services.OrderService;
import com.exercicio.demo.services.ShippingService;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner{
	
	@Autowired
	private OrderService orderService;
	
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Order o1 = new Order(1034, 800d , 10d);
		Double total = orderService.total(o1);
		System.out.println("Código do pedido: "+ o1.getCode());
		System.out.println("Total: "+total);
	}

}
