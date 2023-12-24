package com.devsuperior.dsmeta.dto;

import com.devsuperior.dsmeta.projections.SellerProjection;

public class SellerReduzidoDTO {
	
	private String name;
	private Double quantia;
	
	public SellerReduzidoDTO(String name, Double quantia) {
		this.name = name;
		this.quantia = quantia;
	}
	
	public SellerReduzidoDTO(SellerProjection seller) {
		name = seller.getName();
		quantia = seller.getQuantia();
		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	
	public Double getQuantia() {
		return quantia;
	}

	public void setQuantia(Double quantia) {
		this.quantia = quantia;
	}

	@Override
	public String toString() {
		return "SellerDTO [Name:" + name + ", Quantia:" + quantia + "]";
	}

	
}
