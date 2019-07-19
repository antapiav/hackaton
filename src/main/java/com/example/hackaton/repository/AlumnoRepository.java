package com.example.hackaton.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.hackaton.model.entity.EntityAlumno;

@Repository(value="alumnoRepository")
public interface AlumnoRepository extends JpaRepository<EntityAlumno, Long> {
	@Query("SELECT p FROM EntityAlumno p WHERE UPPER(p.nombre) like UPPER(concat('%',:dato,'%'))")
	Page<EntityAlumno> findAllNamePaginate (Pageable pageable, 
			@Param("dato") String dato);
	
	@Query(value = "SELECT * FROM crud.alumno ", 
			  nativeQuery = true)
	Page<EntityAlumno> findAllNamePaginateNative (Pageable pageable, 
			String dato);
}
