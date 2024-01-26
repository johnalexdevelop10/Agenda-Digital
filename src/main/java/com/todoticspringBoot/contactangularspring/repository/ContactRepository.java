package com.todoticspringBoot.contactangularspring.repository;

import com.todoticspringBoot.contactangularspring.entity.Contact;
import org.springframework.data.repository.CrudRepository;

public interface ContactRepository extends CrudRepository<Contact,Integer> {

}
