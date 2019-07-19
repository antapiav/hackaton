package com.example.hackaton.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.example.hackaton.model.entity.EntityAlumnoEntityCurso;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Data;

@JsonInclude(Include.NON_NULL)
@Data
public class Curso implements Serializable{

	private static final long serialVersionUID = 1L;

	private Long idCurso;
	
	private Long id;

	private String nombre;
	
	private String codigo;
	
	private List<EntityAlumnoEntityCurso> entityAlumnoEntityCurso = new ArrayList<>();

}
