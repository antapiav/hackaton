package com.example.hackaton.model.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.hackaton.beans.Alumno;
import com.example.hackaton.beans.GenericResponse;
import com.example.hackaton.beans.Pagination;
import com.example.hackaton.model.dao.AlumnoDao;

@Repository(value="alumnoDaoImpl")
public class AlumnoDaoImpl implements AlumnoDao{

	@Override
	public GenericResponse<List<Alumno>> findAlumnosPaginado(Pagination pagination) {
		// TODO Auto-generated method stub
		return null;
	}

}
