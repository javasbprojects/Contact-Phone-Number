package com.ait.pbproj.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ait.pbproj.binding.ContactFormData;
import com.ait.pbproj.entity.ContactNumberEntity;
import com.ait.pbproj.repo.IContactPhoneNnumberRepo;
import com.ait.pbproj.service.IContactPhoneNumberService;

import ch.qos.logback.core.joran.util.beans.BeanUtil;

@Service
public class ContactPhoneNumberServiceImpl implements IContactPhoneNumberService {
	
	@Autowired
	private IContactPhoneNnumberRepo crepo;

	@Override
	public String saveContacts(ContactFormData form) {
		 
		ContactNumberEntity entity = new ContactNumberEntity();
		entity.setActivesw("Y"); 
		BeanUtils.copyProperties(form, entity);
		 entity = crepo.save(entity);
	 	 
		 if(entity.getPid()!=null) {
			 
			 return "contacts saved";
		 }
		 
		return "contacts not saved";
	}

	@Override
	public ContactFormData updateContact(Integer id) {
		Optional<ContactNumberEntity> findby =  crepo.findById(id);
		if(findby.isPresent()) {
			ContactNumberEntity entity =  findby.get();
			ContactFormData form = new ContactFormData();
			BeanUtils.copyProperties(entity,form);
			
			return form;
		}
		return null;
	}
 
	 

	//public String removeContact(Integer pid) {
	//	crepo.deleteById(pid);
	//	return "record deleted";
	//}

	@Override
	public List<ContactFormData> fetchAllContact() {
		
		List<ContactFormData> datalist = new ArrayList<>();
		List<ContactNumberEntity> findAll = crepo.findAll();
		
		for(ContactNumberEntity entity:findAll) {
			ContactFormData form = new ContactFormData();
			BeanUtils.copyProperties(entity, form);
			datalist.add(form);
		}
		
		return datalist;
	}

	@Override
	public List<ContactFormData> removeContact(Integer pid) {
		
		crepo.deleteById(pid);
		
		List<ContactFormData> datalist = new ArrayList<>();
		List<ContactNumberEntity> findAll = crepo.findAll();
		
		for( ContactNumberEntity entity : findAll) {
			ContactFormData form = new ContactFormData();
			BeanUtils.copyProperties(entity, form);
			datalist.add(form);
		}
		return datalist;
	}

	

}
