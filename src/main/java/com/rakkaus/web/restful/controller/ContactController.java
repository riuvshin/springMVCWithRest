package com.rakkaus.web.restful.controller;

import com.rakkaus.web.domain.Contact;
import com.rakkaus.web.domain.Contacts;
import com.rakkaus.web.service.ContactService;

import org.joda.time.DateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(value = "/contact")
public class ContactController {
    final Logger logger = LoggerFactory.getLogger(ContactController.class);

    @Autowired
    private ContactService contactService;

    @RequestMapping(value = "/all-contacts", method = RequestMethod.GET)
    @ResponseBody
    public Contacts getAllContacts() {
        return new Contacts(contactService.findAll());
    }

    @RequestMapping(value = "/get-contact-by-id/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Contact getContactById(@PathVariable Long id) {
        return contactService.findById(id);
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    @ResponseBody
    public Contact createNewContact(
            @PathVariable("firstName") String firstName,
            @PathVariable("lastName") String lastName,
            @PathVariable("role") String role,
            @PathVariable("birthDate") DateTime birthDate) {
        Contact contact = new Contact(firstName, lastName, role, birthDate);
        logger.info("Creating contact: " + contact);
        contactService.save(contact);
        logger.info("Contact created successfully with info: " + contact);
        return contact;
    }

    @RequestMapping(value = "update-contact/{id}", method = RequestMethod.PUT)
    @ResponseBody
    public void update(@RequestBody Contact contact, @PathVariable Long id) {
        logger.info("Updating contact: " + contact);
        contactService.save(contact);
        logger.info("Contact updatet successfully with info: " + contact);
    }

    @RequestMapping(value = "delete-contact/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public String delete(@PathVariable Long id) {
        logger.info("Deleting contact with id" + id);
        Contact contact = contactService.findById(id);
        String contactName = contact.getFirstName() + " " + contact.getLastName();
        contactService.delete(contact);
        logger.info("Contact: " + contactName + " deleted successfully");
        return "Contact: " + contactName + " deleted successfully";
    }
}