package com.example.demo.model;


import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class DateCalc {
	

	private int id;
	@NotBlank(message = "入力してください" )
	private String name;
	@NotNull
	private int plusYear;
	@NotNull
	private int plusMonth;
	@NotNull
	private int plusDay;
	
	
	
}
