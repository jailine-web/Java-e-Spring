package com.devsuperior.dsmeta.dto;

import com.devsuperior.dsmeta.projections.SellerProjection;

public class SellerDTO {
	
	private Long id;
	private String name;
	private String email;
	private String phone;
	private Double quantia;
	
	public SellerDTO(Long id, String name, String email, String phone) {
		this.id = id;
		this.name = name;
		this.email = email;
		this.phone = phone;
	}
	
	public SellerDTO(SellerProjection seller) {
		name = seller.getName();
		quantia = seller.getQuantia();
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Double getQuantia() {
		return quantia;
	}

	public void setQuantia(Double quantia) {
		this.quantia = quantia;
	}

	@Override
	public String toString() {
		return "SellerDTO [name=" + name + ", quantia=" + quantia + "]";
	}

	
}
