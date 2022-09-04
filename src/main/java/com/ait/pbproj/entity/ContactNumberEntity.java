package com.ait.pbproj.entity;

import java.time.LocalDate;

import javax.annotation.Generated;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="contactnumber")
public class ContactNumberEntity {

	@Id
	@GeneratedValue
	private Integer pid;
	
	private Long pnumber;
	private String name;
	private String email;
	
	private String activesw;
	
	@CreationTimestamp
	private LocalDate currentdate;
	@UpdateTimestamp
	private LocalDate updateddate;
	
}
