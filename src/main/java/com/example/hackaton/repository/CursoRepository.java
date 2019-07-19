package com.example.hackaton.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.hackaton.model.entity.EntityCurso;

@Repository(value="cursoRepository")
public interface CursoRepository extends JpaRepository<EntityCurso, Long>{

}
