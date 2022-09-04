package com.ait.pbproj.repo;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ait.pbproj.entity.ContactNumberEntity;

public interface IContactPhoneNnumberRepo extends JpaRepository<ContactNumberEntity, Serializable> {

}
