package com.crm.crm.model;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.net.URISyntaxException;
import java.util.Collection;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:3000/")
public class ContactsController {
    private ContactRepository contactRepository;

    public ContactsController(ContactRepository contactRepository) {
        this.contactRepository = contactRepository;
    }

    @GetMapping("/contacts")
    public Collection<Contact> contacts()
    {
        return (Collection<Contact>)this.contactRepository.findAll();
    }

    @PostMapping("/contacts")
    public ResponseEntity<Contact> createContact(@Validated @RequestBody Contact contact) throws URISyntaxException
    {
        Contact result = contactRepository.save(contact);
        return ResponseEntity.ok().body(result);
    }
}
