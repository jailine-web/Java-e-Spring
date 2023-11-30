package com.devsuperior.aula.controllers;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.devsuperior.aula.DTO.ProductDTO;
import com.devsuperior.aula.services.ProductService;

@RestController
@RequestMapping(value="/products")
public class ProductController {

	@Autowired
	private ProductService productService;
	
	@PostMapping
	public ResponseEntity<ProductDTO> insertProduct(@RequestBody ProductDTO product) {
		product = productService.insert(product);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(product.getId()).toUri();
		return ResponseEntity.created(uri).body(product);
	}
}
