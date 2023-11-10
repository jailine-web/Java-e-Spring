package com.exercicio.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exercicio.demo.entities.Order;

@Service
public class OrderService {

	@Autowired
	private ShippingService shippingService;
	
	public double total (Order order) {
		
		double total = shippingService.shipment(order);
		
		double porce  = order.getBasic() - 
				(order.getBasic() * order.getDiscount())/100;  
		
		double result = porce + total;
		return result;
	}
}
