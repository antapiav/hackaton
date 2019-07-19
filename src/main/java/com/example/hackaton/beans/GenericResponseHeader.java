package com.example.hackaton.beans;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Data;

@JsonInclude(Include.NON_NULL)
@Data
public class GenericResponseHeader implements Serializable{
	
	private static final long serialVersionUID = 1L;

	private Integer numPagina;
	private Integer totalPagina;
}
