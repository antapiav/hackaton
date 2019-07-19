package com.example.hackaton.model.entity;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

import com.example.hackaton.util.AppConstants;

import lombok.Data;

@Data
@Entity(name=AppConstants.NAME_TABLE_ALUMNO_CURSO)
@Table(name=AppConstants.NAME_TABLE_ALUMNO_CURSO, schema=AppConstants.SCHEMA)
public class EntityAlumnoEntityCurso implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@EmbeddedId
	private EntityAlumnoEntityCursoId entityAlumnoEntityCurso;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @MapsId(value="idAlumno")
	private EntityAlumno entityAlumno;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @MapsId(value="idCurso")
	private EntityCurso entityCurso;
	
}
