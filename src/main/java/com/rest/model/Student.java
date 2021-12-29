package com.rest.model;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student implements Serializable {
	
	private static final long serialVersionUID = -1405274148539263049L;
	
	private Integer studentId;
	private String stdName;
	private Double stdFee;

}
