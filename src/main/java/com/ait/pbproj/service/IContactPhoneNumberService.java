package com.ait.pbproj.service;

import java.util.List;

import com.ait.pbproj.binding.ContactFormData;
import com.ait.pbproj.entity.ContactNumberEntity;

public interface IContactPhoneNumberService {
	
	public String saveContacts(ContactFormData form);
	public ContactFormData updateContact(Integer pid);
	public List<ContactFormData> fetchAllContact();
	public List<ContactFormData> removeContact(Integer pid);

}
