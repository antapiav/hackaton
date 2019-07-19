package com.example.hackaton.beans;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@JsonInclude(Include.NON_NULL)
@Data
@ToString
@EqualsAndHashCode
public class Pagination implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long page;
	
	private Long limit;
	
	private String filters;

}
