package com.todoticspringBoot.contactangularspring.service;


import com.todoticspringBoot.contactangularspring.dto.ContactDTO;
import com.todoticspringBoot.contactangularspring.entity.Contact;
import com.todoticspringBoot.contactangularspring.repository.ContactRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.LocalDateTime;

@AllArgsConstructor
@Service
public class ContacService {


    private final ContactRepository contactRepository;

    public Iterable<Contact> findAll() {
        return contactRepository.findAll();
    }

    public Contact findById(Integer id){
        return contactRepository.findById(id).orElse(null);
    }

    public Contact create(ContactDTO contactDTO){

        ModelMapper modelMapper = new ModelMapper();
        Contact contact = new Contact();
        contact.setName(contactDTO.getName());
        contact.setEmail(contactDTO.getEmail());
        contact.setCreateAt(LocalDateTime.now());
        return contactRepository.save(contact);

    }

    public Contact upDate(Integer id, ContactDTO contactDTO){

        Contact contactFromDb = findById(id);

        contactFromDb.setName(contactDTO.getName());
        contactFromDb.setEmail(contactDTO.getEmail());
        return contactRepository.save(contactFromDb);
    }

    public void delete (Integer id){
        Contact contactFromDb = findById(id);
        contactRepository.delete(contactFromDb);
    }




}
