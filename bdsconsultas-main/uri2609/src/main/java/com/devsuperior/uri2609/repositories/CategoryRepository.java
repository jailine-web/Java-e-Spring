package com.devsuperior.uri2609.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.devsuperior.uri2609.entities.Category;
import com.devsuperior.uri2609.projections.CategorySumProjection;

public interface CategoryRepository extends JpaRepository<Category, Long> {

	@Query(nativeQuery = true, value = "Select c.name, sum(p.amount) as sum\n"
			+ "from products as p "
			+ "inner join categories as c "
			+ "on p.id_categories = c.id "
			+ "group by c.name;")
	
	List<CategorySumProjection> search();
}
