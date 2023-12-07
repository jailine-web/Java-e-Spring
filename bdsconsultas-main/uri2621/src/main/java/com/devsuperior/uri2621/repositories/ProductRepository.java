package com.devsuperior.uri2621.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.devsuperior.uri2621.entities.Product;
import com.devsuperior.uri2621.projections.ProductProjection;

public interface ProductRepository extends JpaRepository<Product, Long> {

	@Query(nativeQuery = true, value = "SELECT p.name "
			+ "	FROM products as p "
			+ "	INNER JOIN providers as pr "
			+ "	ON p.id_providers = pr.id "
			+ "	WHERE pr.name LIKE CONCAT(:beginName, '%') AND (amount BETWEEN :min AND :max)")
	
	List<ProductProjection> searchProducts(Integer min, Integer max, String beginName);
	
	
	
	
}
