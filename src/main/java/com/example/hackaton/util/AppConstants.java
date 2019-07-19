package com.example.hackaton.util;

public interface AppConstants {
	String SCHEMA = "crud";
	
	String NAME_ENTITY_ALUMNO = "EntityAlumno";
	String NAME_TABLE_ALUMNO = "alumno";
	String NAME_TABLE_PROFESOR = "profesor";
	String NAME_TABLE_CURSO = "curso";
	String NAME_TABLE_ALUMNO_PROFESOR = "alumno_profesor";
	String NAME_TABLE_ALUMNO_CURSO = "alumno_curso";
	
	String ID_SECUENCE_ALUMNO = "id_alumno";
	String ID_SECUENCE_PROFESOR = "id_profesor";
	String ID_SECUENCE_CURSO = "id_curso";
	String ID_SECUENCE_ALUMNO_PROFESOR = "id_alumno_profesor";
	String ID_SECUENCE_ALUMNO_CURSO = "id_alumno_curso";
	
	String NAME_SECUENCE_ALUMNO = "seq_alumno";
	String NAME_SECUENCE_PROFESOR = "seq_profesor";
	String NAME_SECUENCE_CURSO = "seq_curso";
	String NAME_SECUENCE_ALUMNO_PROFESOR = "seq_alumno_profesor";
	String NAME_SECUENCE_ALUMNO_CURSO = "seq_alumno_curso";
	
	String ID = "/{id}";
	String MAPPING_CONTROLLER_ALUMNO = "/alumno";
	String MAPPING_INSERTAR = "/insertar";
	String MAPPING_ACTUALIZAR = "/actualizar";
	String MAPPING_ELIMINAR = "/eliminar"+ID;
	String MAPPING_SELECCIONAR = "/seleccionar"+ID;
	String MAPPING_LISTAR_PAGIANDO = "/listar_paginado";
	String MAPPING_LISTAR_FUNCTION = "/listar_function";
	
	String NOT_FOUND_KEY = "notFoundKey";
	String PARAM_RESPONSE_CODE = "code";
	String PARAM_RESPONSE_MESSAGE = "message";

	
}
