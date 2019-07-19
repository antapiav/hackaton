package com.example.hackaton.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.hackaton.beans.Alumno;
import com.example.hackaton.beans.GenericResponse;
import com.example.hackaton.beans.Pagination;
import com.example.hackaton.exception.AppInternalException;
import com.example.hackaton.services.AlumnoService;
import com.example.hackaton.util.AppConstants;
import com.example.hackaton.util.AppMessages;

@RestController
@RequestMapping(value = AppConstants.MAPPING_CONTROLLER_ALUMNO)
public class AlumnoController extends AbstractController{
	
	private AlumnoService alumnoService;
	
	@Autowired
	public void setAlumnoService(AlumnoService alumnoService) {
		this.alumnoService = alumnoService;
	}
	
	@PostMapping(value=AppConstants.MAPPING_LISTAR_FUNCTION)
	public GenericResponse<List<Alumno>> findAlumnosPaginado(@RequestBody Pagination pagination) {
		return alumnoService.findAlumnosPaginado(pagination);
	}
	
	@GetMapping(value=AppConstants.MAPPING_LISTAR_PAGIANDO)
	public GenericResponse<List<Alumno>> lstAlumnoPaginado(Pageable pageable, 
			@RequestParam("filtro") String filtro, 
			@RequestParam("dato") String dato) {
		GenericResponse<List<Alumno>> response = alumnoService.lstAlumnoPaginado(pageable, 
				filtro, dato);
		response.setCode(HttpStatus.OK.value());
		response.setMessage(getValueMessage(AppMessages.GENERIC_RESPONSE_OK));
		return response;
	}
	
	@PostMapping(value=AppConstants.MAPPING_INSERTAR)
	public GenericResponse<Alumno> insertAlumno(@Valid @RequestBody Alumno req) {
		GenericResponse<Alumno> response = alumnoService.insertAlumno(req);
		response.setCode(HttpStatus.OK.value());
		response.setMessage(getValueMessage(AppMessages.GENERIC_RESPONSE_OK));
		return response;
	}
	
	@GetMapping(value=AppConstants.MAPPING_SELECCIONAR)
	public GenericResponse<Alumno> alumnoById(@PathVariable Long id) throws AppInternalException{
		GenericResponse<Alumno> response = alumnoService.alumnoById(id);
		response.setMessage(getValueMessage(response.getMessage()));
		return response;
	}
	
	@PutMapping(value=AppConstants.MAPPING_ACTUALIZAR)
	public GenericResponse<Alumno> updateAlumno(@Valid @RequestBody Alumno req) throws AppInternalException{
		GenericResponse<Alumno> response = alumnoService.updateAlumno(req);
		response.setMessage(getValueMessage(response.getMessage()));
		return response;
	} 
	
	@DeleteMapping(value=AppConstants.MAPPING_ELIMINAR)
	public GenericResponse<Alumno> deleteAlumno(@PathVariable Long id) throws AppInternalException{
		GenericResponse<Alumno> response = alumnoService.deleteAlumno(id);
		response.setMessage(getValueMessage(response.getMessage()));
		return response;
	} 
	
}
