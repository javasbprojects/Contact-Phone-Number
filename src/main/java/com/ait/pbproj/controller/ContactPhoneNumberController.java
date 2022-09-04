package com.ait.pbproj.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ait.pbproj.binding.ContactFormData;
import com.ait.pbproj.entity.ContactNumberEntity;
import com.ait.pbproj.service.IContactPhoneNumberService;

@RestController
@RequestMapping("/contacts")
public class ContactPhoneNumberController {

	@Autowired
	private IContactPhoneNumberService service;
	
	@PostMapping("/save")
	public String saveContacts(@RequestBody ContactFormData form) {
	
		String status = service.saveContacts(form);
		
		return status;
	}
	@GetMapping("/viewall")
	public List<ContactFormData> viewAllContacts(){
	
		return service.fetchAllContact();
		
	}
	@GetMapping("/edit/{id}")
	public ContactFormData editForm(@PathVariable  Integer id) {
		return  service.updateContact(id);
	}
	 
	@DeleteMapping("/delete/{id}")
	public List<ContactFormData> deleteContact(@PathVariable Integer id){
		return service.removeContact(id);
	}
	
}
