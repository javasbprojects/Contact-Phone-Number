package com.ait.pbproj.binding;

import java.time.LocalDate;

import lombok.Data;

@Data
public class ContactFormData {
	
	
	
	private Integer pid;
	
	private Long pnumber;
	private String name;
	private String email;
	
	private String activesw;
	
	
	private LocalDate currentdate;
	private LocalDate updateddate;

}
