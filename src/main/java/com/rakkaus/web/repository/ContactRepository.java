package com.rakkaus.web.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.rakkaus.web.domain.Contact;

public interface ContactRepository extends CrudRepository<Contact, Long>{
	
	public List<Contact> findByFirstName(String firsName);
}
