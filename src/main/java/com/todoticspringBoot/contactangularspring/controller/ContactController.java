package com.todoticspringBoot.contactangularspring.controller;


import com.todoticspringBoot.contactangularspring.dto.ContactDTO;
import com.todoticspringBoot.contactangularspring.entity.Contact;
import com.todoticspringBoot.contactangularspring.repository.ContactRepository;
import com.todoticspringBoot.contactangularspring.service.ContacService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;


@CrossOrigin
@AllArgsConstructor
@RequestMapping("/api/contacts")
@RestController
public class ContactController {
    @Autowired
    //private ContactRepository contactRepository;
     private final ContacService contacService;



    @GetMapping
   public Iterable<Contact>list(){
        return contacService.findAll();
    }

    //@GetMapping("{id}")
    //public Contact get(@PathVariable Integer id){
        //return contactRepository.findById(id).orElse(null);
    //}



    @GetMapping("{id}")
    public Contact get(@PathVariable Integer id){
    return contacService.findById(id);
    }


    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public Contact create(@RequestBody ContactDTO contactDTO){
        return contacService.create(contactDTO);

    }

    @PutMapping("{id}")
    public Contact udDate(@PathVariable Integer id, @RequestBody ContactDTO contactDTO){
        return contacService.upDate(id,contactDTO);
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @DeleteMapping("{id}")
    public void delete(@PathVariable Integer id){
        contacService.delete(id);
    }


    //@PutMapping("{id}")
    //public Contact upDate(@PathVariable Integer id, @RequestBody Contact form){
        //Contact contactFromDb = contactRepository.findById(id).orElse(null);

        //contactFromDb.setName(form.getName());
        //contactFromDb.setEmail(form.getEmail());

        //return contactRepository.save(contactFromDb);
    //}



    //@DeleteMapping("{id}")
    //public void delete(@PathVariable Integer id){
        //Contact contactFromDb = contactRepository.findById(id).orElse(null);
        //contactRepository.delete(contactFromDb);
    //}

}
