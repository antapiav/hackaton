package com.example.hackaton.util;

import com.example.hackaton.beans.Alumno;
import com.example.hackaton.model.entity.EntityAlumno;

public class AppConverter {
	
	public static Alumno convertEntityAlumnoToAlumno(EntityAlumno entity) {
			Alumno alumno = new Alumno();
			alumno.setIdAlumno(entity.getIdAlumno());
			alumno.setNombre(entity.getNombre());
			alumno.setApPaterno(entity.getApPaterno());
			alumno.setApMaterno(entity.getApMaterno());
			alumno.setCodigo(entity.getCodigo());
		return alumno;
	}
	
	public static EntityAlumno convertAlumnoToEntityAlumno(Alumno alumno) {
			EntityAlumno entityAlumno = new EntityAlumno();
			entityAlumno.setIdAlumno(alumno.getIdAlumno());
			entityAlumno.setNombre(alumno.getNombre());
			entityAlumno.setApPaterno(alumno.getApPaterno());
			entityAlumno.setApMaterno(alumno.getApMaterno());
			entityAlumno.setCodigo(alumno.getCodigo());
		return entityAlumno;
	}
}
