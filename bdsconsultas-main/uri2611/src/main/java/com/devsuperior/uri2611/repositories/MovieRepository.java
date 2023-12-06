package com.devsuperior.uri2611.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.devsuperior.uri2611.MovieDTO;
import com.devsuperior.uri2611.entities.Movie;
import com.devsuperior.uri2611.projections.MovieProjection;

public interface MovieRepository extends JpaRepository<Movie, Long>{

	@Query(nativeQuery = true , value = 
			"SELECT m.id, m.name "
			+ "FROM movies as m "
			+ "INNER JOIN genres as g "
			+ "ON m.id_genres= g.id "
			+ "WHERE g.description = :genreName")
	
	List<MovieProjection> searchArgs(String genreName);

	
	@Query("SELECT new com.devsuperior.uri2611.MovieDTO(obj.id, obj.name) "
					+ "FROM Movie obj "
					+ "WHERE obj.genre.description = :genreName")
	
	List<MovieDTO> searchArgsJPQL(String genreName);
	

}
