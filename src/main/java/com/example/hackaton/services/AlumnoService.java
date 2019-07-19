package com.example.hackaton.services;

import java.util.List;

import org.springframework.data.domain.Pageable;

import com.example.hackaton.beans.Alumno;
import com.example.hackaton.beans.GenericResponse;
import com.example.hackaton.beans.Pagination;
import com.example.hackaton.exception.AppInternalException;

public interface AlumnoService {
	GenericResponse<List<Alumno>> findAlumnosPaginado(Pagination pagination);
	GenericResponse<List<Alumno>> lstAlumnoPaginado(Pageable pageable, String filtro, String dato);
	GenericResponse<Alumno> alumnoById(Long idAlumno) throws AppInternalException;
	GenericResponse<Alumno> insertAlumno(Alumno alumno);
	GenericResponse<Alumno> updateAlumno(Alumno alumno) throws AppInternalException;
	GenericResponse<Alumno> deleteAlumno(Long idAlumno) throws AppInternalException;
}
