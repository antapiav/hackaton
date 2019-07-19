package com.example.hackaton.model.dao;

import java.util.List;

import com.example.hackaton.beans.Alumno;
import com.example.hackaton.beans.GenericResponse;
import com.example.hackaton.beans.Pagination;


public interface AlumnoDao {
	GenericResponse<List<Alumno>> findAlumnosPaginado(Pagination pagination);
}
