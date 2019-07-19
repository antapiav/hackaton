package com.example.hackaton.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.hackaton.beans.Alumno;
import com.example.hackaton.beans.GenericResponse;
import com.example.hackaton.beans.GenericResponseHeader;
import com.example.hackaton.beans.Pagination;
import com.example.hackaton.model.dao.AlumnoDao;
import com.example.hackaton.model.entity.EntityAlumno;
import com.example.hackaton.repository.AlumnoRepository;
import com.example.hackaton.services.AlumnoService;
import com.example.hackaton.util.AppConverter;
import com.example.hackaton.util.AppMessages;

import com.example.hackaton.exception.AppInternalException;

@Service(value="alumnoServiceImpl")
@Transactional
public class AlumnoServiceImpl implements AlumnoService {
	
	private static final Logger log = LoggerFactory.getLogger(AlumnoServiceImpl.class);
	
	@Autowired
	private AlumnoDao alumnoDao;
	
	@Autowired
	@Qualifier(value="alumnoRepository")
	private AlumnoRepository alumnoRepository;

	@Override
	public GenericResponse<List<Alumno>> findAlumnosPaginado(Pagination pagination) {
		return alumnoDao.findAlumnosPaginado(pagination);
	}
	
	@Override
	public GenericResponse<List<Alumno>> lstAlumnoPaginado(Pageable pageable, String filtro, String dato) {
		GenericResponse<List<Alumno>> response = new GenericResponse<>();
		Page<EntityAlumno> pageEntityAlumno;
		switch(filtro) {
			case "name":
				pageEntityAlumno = alumnoRepository.findAllNamePaginate(pageable, dato);
				break;
			case "apPaterno":
				pageEntityAlumno = alumnoRepository.findAllNamePaginateNative(pageable, dato);
				break;
			default:
				pageEntityAlumno = alumnoRepository.findAll(pageable);
				break;
		}
		
		List<Alumno> lstAlumno = new ArrayList<>();
		for(EntityAlumno entityAlumno : pageEntityAlumno.getContent()) {
			Alumno alumno = new Alumno();
			alumno = AppConverter.convertEntityAlumnoToAlumno(entityAlumno);
			lstAlumno.add(alumno);
		}
		GenericResponseHeader headerResponse = new GenericResponseHeader();
		headerResponse.setNumPagina(pageEntityAlumno.getNumber());
		headerResponse.setTotalPagina(pageEntityAlumno.getNumberOfElements());
		response.setHeader(headerResponse);
		response.setBody(lstAlumno);
		return response;
	}

	@Override
	public GenericResponse<Alumno> alumnoById(Long idAlumno) throws AppInternalException{
		GenericResponse<Alumno> response = new GenericResponse<>();
		boolean exist = alumnoRepository.findById(idAlumno).isPresent();
		if(!exist) {
			response.setCode(HttpStatus.NO_CONTENT.value());
			response.setMessage(AppMessages.GENERIC_RESPONSE_NOT_EXIST);
		}else {
			EntityAlumno entityAlumno = alumnoRepository.findById(idAlumno)
					.orElseThrow(() -> new AppInternalException(HttpStatus.NOT_FOUND, AppMessages.GENERIC_RESPONSE_ERROR));
			response.setCode(HttpStatus.OK.value());
			response.setMessage(AppMessages.GENERIC_RESPONSE_OK);
			response.setBody(AppConverter.convertEntityAlumnoToAlumno(entityAlumno));
		}
		return response;
	}

	@Override
	public GenericResponse<Alumno> insertAlumno(Alumno alumno) {
		GenericResponse<Alumno> response = new GenericResponse<>();
		response.setBody(AppConverter.convertEntityAlumnoToAlumno(alumnoRepository.save(AppConverter.convertAlumnoToEntityAlumno(alumno))));
		return response;
	}

	@Override
	public GenericResponse<Alumno> updateAlumno(Alumno alumno) throws AppInternalException {
		GenericResponse<Alumno> response = new GenericResponse<>();
		boolean exist = alumnoRepository.findById(alumno.getIdAlumno()).isPresent();
		if (!exist) {
			response.setCode(HttpStatus.NO_CONTENT.value());
			response.setMessage(AppMessages.GENERIC_RESPONSE_NOT_EXIST);
		}else {
			EntityAlumno entityAlumno = alumnoRepository.findById(alumno.getIdAlumno())
					.map(mapper->{
						mapper.setIdAlumno(alumno.getIdAlumno());
						mapper.setCodigo(alumno.getCodigo());
						mapper.setNombre(alumno.getNombre());
						mapper.setApPaterno(alumno.getApPaterno());
						mapper.setApMaterno(alumno.getApMaterno());
						return alumnoRepository.save(mapper);
					}).orElseThrow(() -> new AppInternalException(HttpStatus.NOT_FOUND, AppMessages.GENERIC_RESPONSE_ERROR));	
			response.setCode(HttpStatus.OK.value());
			response.setMessage(AppMessages.GENERIC_RESPONSE_OK);
			response.setBody(AppConverter.convertEntityAlumnoToAlumno(entityAlumno));
		}
		return response;
	}

	@Override
	public GenericResponse<Alumno> deleteAlumno(Long idAlumno)  throws AppInternalException {
		GenericResponse<Alumno> response = new GenericResponse<>();
		boolean exist = alumnoRepository.findById(idAlumno).isPresent();
		if(!exist) {
			response.setCode(HttpStatus.NO_CONTENT.value());
			response.setMessage(AppMessages.GENERIC_RESPONSE_NOT_EXIST);
		}else {
			Boolean delete = alumnoRepository.findById(idAlumno)
				.map(mapper->{
					alumnoRepository.delete(mapper);
					return true;
				}).orElseThrow(() -> new AppInternalException(HttpStatus.NOT_FOUND, AppMessages.GENERIC_RESPONSE_ERROR, true));	
			if(delete.equals(true)) {
				response.setCode(HttpStatus.OK.value());
				response.setMessage(AppMessages.GENERIC_RESPONSE_OK);
			}
		}       
        return response;
	}
}
