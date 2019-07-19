package com.example.hackaton.beans;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Data;

@JsonInclude(Include.NON_NULL)
@Data
public class Profesor implements Serializable{

	private static final long serialVersionUID = 1L;

	private Long idProfesor;
	
	private String nombre;
	
	private String aPaterno;
	
	private String aMaterno;
	
	private String codigo;
	
}
