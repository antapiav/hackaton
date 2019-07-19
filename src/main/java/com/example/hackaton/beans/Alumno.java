package com.example.hackaton.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Data;

@JsonInclude(Include.NON_NULL)
@Data
public class Alumno implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Long idAlumno;
	
	private String nombre;
	
	private String apPaterno;
	
	private String apMaterno;
	
	private String codigo;
	
	private List<Curso> lstCurso = new ArrayList<>();
	
}
