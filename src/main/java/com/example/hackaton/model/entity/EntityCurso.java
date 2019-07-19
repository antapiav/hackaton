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
@Entity(name = AppConstants.NAME_TABLE_CURSO)
@Table(name = AppConstants.NAME_TABLE_CURSO, schema=AppConstants.SCHEMA)
public class EntityCurso implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator=AppConstants.ID_SECUENCE_CURSO)
	@SequenceGenerator(name=AppConstants.ID_SECUENCE_CURSO, 
		sequenceName=AppConstants.SCHEMA+AppConstants.NAME_SECUENCE_CURSO, allocationSize = 1)
	@Column(name = "id")
	private Long idCurso;
	
	@Column(name = "nombre")
	private String nombre;
	
	@Column(name = "codigo")
	private String codigo;
	
	@OneToMany(mappedBy = "entityCurso")
	private List<EntityAlumnoEntityCurso> entityAlumnoEntityCurso = new ArrayList<>();
}
