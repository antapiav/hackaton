package com.example.hackaton.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.hackaton.model.entity.EntityProfesor;

@Repository(value="profesorRepository")
public interface ProfesorRepository extends JpaRepository<EntityProfesor, Integer>{

}
