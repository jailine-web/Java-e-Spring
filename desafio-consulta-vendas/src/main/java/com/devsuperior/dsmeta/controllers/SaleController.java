package com.devsuperior.dsmeta.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.devsuperior.dsmeta.dto.SaleMinDTO;
import com.devsuperior.dsmeta.dto.SellerReduzidoDTO;
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
			Pageable pageable){
			
		    	
	Page<SaleMinDTO> sales = service.findReport(dateMin, dateMax, name, pageable);
		
		return ResponseEntity.ok().body(sales);
	}

	
	@GetMapping(value = "/summary")
	public ResponseEntity<List<SellerReduzidoDTO>> getSummary(
			@RequestParam(value = "dataInicial", defaultValue = "") String dataInicial,
			@RequestParam(value = "dataFinal"  , defaultValue = "") String dataFinal) {
		
		List<SellerReduzidoDTO> result = service.findSumary(dataInicial, dataFinal);
		
		return ResponseEntity.ok().body(result);
	}
	
	
}
