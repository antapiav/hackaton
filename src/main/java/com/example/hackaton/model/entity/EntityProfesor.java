package com.example.hackaton.model.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.example.hackaton.util.AppConstants;

import lombok.Data;

@Data
@Entity(name = AppConstants.NAME_TABLE_PROFESOR)
@Table(name = AppConstants.NAME_TABLE_PROFESOR, schema=AppConstants.SCHEMA)
public class EntityProfesor implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator=AppConstants.ID_SECUENCE_PROFESOR)
	@SequenceGenerator(name=AppConstants.ID_SECUENCE_PROFESOR, sequenceName=AppConstants.SCHEMA+ 
		AppConstants.NAME_SECUENCE_PROFESOR, allocationSize=1)
	@Column(name = "id")
	private Long idProfesor;
	
	@Column(name = "nombre")
	private String nombre;
	
	@Column(name = "a_paterno")
	private String aPaterno;
	
	@Column(name = "a_materno")
	private String aMaterno;
	
	@Column(name = "codigo")
	private String codigo;
}
