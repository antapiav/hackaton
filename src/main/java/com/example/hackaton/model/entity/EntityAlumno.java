package com.example.hackaton.model.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import com.example.hackaton.util.AppConstants;

import lombok.Data;

@Data
@Entity(name = AppConstants.NAME_ENTITY_ALUMNO)
@Table(name = AppConstants.NAME_TABLE_ALUMNO, schema=AppConstants.SCHEMA)
public class EntityAlumno implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "id_alumno")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator= AppConstants.ID_SECUENCE_ALUMNO )
	@SequenceGenerator(name = AppConstants.ID_SECUENCE_ALUMNO, sequenceName =AppConstants.SCHEMA+
		AppConstants.NAME_SECUENCE_ALUMNO, allocationSize = 1)
	private Long idAlumno;
	
	@Column(name = "nombre")
	private String nombre;
	
	@Column(name = "ap_paterno")
	private String apPaterno;
	
	@Column(name = "ap_materno")
	private String apMaterno;
	
	@Column(name = "codigo")
	private String codigo;
	
	@OneToMany(mappedBy = "entityAlumno")
	private List<EntityAlumnoEntityCurso> lstCurso = new ArrayList<>();
	
}
