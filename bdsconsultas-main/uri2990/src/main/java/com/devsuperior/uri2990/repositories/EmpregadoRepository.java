package com.devsuperior.uri2990.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.devsuperior.uri2990.dto.EmpregadoDeptDTO;
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
	
	
	@Query("SELECT new com.devsuperior.uri2990.dto.EmpregadoDeptDTO(obj.cpf, obj.enome, obj.departamento.dnome) "
			+ "FROM Empregado obj "
			+ "WHERE obj.cpf NOT IN ( "
			+ "	SELECT obj.cpf "
			+ "   FROM Empregado obj "
			+ "   INNER JOIN obj.projetosOndeTrabalha "
			+ ") "
			+ "ORDER BY obj.cpf ")
	List<EmpregadoDeptDTO> searchJPQL();
	

	@Query(nativeQuery = true, value = "SELECT e.cpf, e.enome, d.dnome "
			+ "FROM empregados as e "
			+ "INNER JOIN departamentos as d "
			+ "ON e.dnumero = d.dnumero "
			+ "LEFT JOIN trabalha as t  "
			+ "ON t.cpf_emp = e.cpf "
			+ "WHERE t.cpf_emp IS NULL "
			+ "ORDER BY e.cpf ")
	List<EmpregadoDeptProjection> searchSQLeft();
}
