package com.example.hackaton.model.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.Data;

@Data
@Embeddable
public class EntityAlumnoEntityCursoId implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Column(name="id_alumno")
	private Long idAlumno;
	
	@Column(name="id_curso")
	private Long idCurso;

}
