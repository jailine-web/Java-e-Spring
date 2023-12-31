package com.exercicio.demo.services;

import org.springframework.stereotype.Service;

import com.exercicio.demo.entities.Order;

@Service
public class ShippingService {

	public double shipment(Order order) {
		
		if(order.getBasic() > 100 && order.getBasic() < 200) {
			return 12d;
			
		}
		if(order.getBasic() < 100) {
			return 20d;
		}
		
		return 0;
	}
		
}

