package com.devsuperior.uri2602.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.devsuperior.uri2602.DTO.CustomerDTO;
import com.devsuperior.uri2602.entities.Customer;
import com.devsuperior.uri2602.projections.CustomerProjection;

public interface CustomerRepository extends JpaRepository<Customer, Long>{

	@Query(nativeQuery = true, value = 
			""" 
			SELECT name 
			FROM customers 
			WHERE UPPER(state) = UPPER(:state) """)
	List<CustomerProjection> searchName(String state);
	
	@Query(""" 
			SELECT new com.devsuperior.uri2602.DTO.CustomerDTO(obj.name)  
			FROM Customer obj 
			WHERE UPPER(obj.state) = UPPER(:state) """)
	List<CustomerDTO> searchNameViaJPQL(String state);
	

}