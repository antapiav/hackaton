package com.example.hackaton.beans;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Data;

@JsonInclude(Include.NON_NULL)
@Data
public class GenericResponse<T> implements Serializable {

		private static final long serialVersionUID = 1L;

		private Integer code;
		
		private String message;
		
		private GenericResponseHeader header;
		
		private T body;
}
