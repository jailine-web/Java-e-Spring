package com.devsuperior.dsmeta.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.devsuperior.dsmeta.dto.SaleMinDTO;
import com.devsuperior.dsmeta.services.SaleService;

@RestController
@RequestMapping(value = "/sales")
public class SaleController {

	@Autowired
	private SaleService service;
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<SaleMinDTO> findById(@PathVariable Long id) {
		SaleMinDTO dto = service.findById(id);
		return ResponseEntity.ok(dto);
	}

	@GetMapping(value = "/report")
	public ResponseEntity<Page<SaleMinDTO>> getReport(
			@RequestParam(value = "minDate"  , defaultValue = "") String dateMin, 
			@RequestParam(value = "maxDate"  , defaultValue = "") String dateMax, 
			@RequestParam(value = "name"     , defaultValue = "") String name, 
			@RequestParam(value = "page", defaultValue = "0") Integer page,
		    @RequestParam(value = "size", defaultValue = "10") Integer size) {
		
		PageRequest pageRequest = PageRequest.of(page, size);
		    	
	Page<SaleMinDTO> sales = service.findReport(dateMin, dateMax, name, pageRequest);
		
		return ResponseEntity.ok().body(sales);
	}

	@GetMapping(value = "/summary")
	public ResponseEntity<SaleMinDTO> getSummary() {
		// TODO
		return null;
	}
}
