package com.devsuperior.aula.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devsuperior.aula.DTO.CategoryDTO;
import com.devsuperior.aula.DTO.ProductDTO;
import com.devsuperior.aula.entities.Category;
import com.devsuperior.aula.entities.Product;
import com.devsuperior.aula.repositories.CategoryRepository;
import com.devsuperior.aula.repositories.ProductRepository;

@Service
public class ProductService {
	
	@Autowired
	ProductRepository productRepository;
	
	@Autowired
	CategoryRepository categoryRepository;
	
	public ProductDTO insert(ProductDTO productDTO) {
		
		Product entity = new Product();
		
		
		//entity.setId(productDTO.getId());
		entity.setName(productDTO.getName());
		entity.setPrice(productDTO.getPrice());
		
		for(CategoryDTO catDTO : productDTO.getCategories()) {
			//Category cat = new Category();
			Category cat = categoryRepository.getReferenceById(catDTO.getId());
			cat.setId(catDTO.getId());
			entity.getCategories().add(cat);
		}
		
		entity = productRepository.save(entity);
		
		return new ProductDTO(entity);
	}

}
