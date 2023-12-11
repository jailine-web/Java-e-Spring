package com.devsuperior.uri2990.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.devsuperior.uri2990.entities.Empregado;
import com.devsuperior.uri2990.projections.EmpregadoDeptProjection;

public interface EmpregadoRepository extends JpaRepository<Empregado, Long> {

	@Query(nativeQuery = true, value = "SELECT e.cpf, e.enome, d.dnome "
			+ "FROM empregados as e "
			+ "INNER JOIN departamentos as d "
			+ "ON e.dnumero = d.dnumero "
			+ "WHERE e.cpf NOT IN ("
			+ "	SELECT e.cpf "
			+ "    FROM empregados "
			+ "    INNER JOIN trabalha ON trabalha.cpf_emp = e.cpf "
			+ ") "
			+ "order by e.cpf")
	List<EmpregadoDeptProjection> search();
	
}
