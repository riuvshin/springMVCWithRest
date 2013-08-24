package com.rakkaus.web.remoting;

import java.util.List;

import org.springframework.context.support.GenericXmlApplicationContext;

import com.rakkaus.web.domain.Contact;
import com.rakkaus.web.service.ContactService;

public class HttpTest {
	
	public static void main(String[] args) {
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
		ctx.load("classpath:App-context.xml");
		ctx.refresh();
		
		ContactService contactService = ctx.getBean("remoteContactService", ContactService.class);
		
		System.out.println("find all contacts");
		List<Contact> contacts = contactService.findAll();
		listContacts(contacts);
	}

	private static void listContacts(List<Contact> contacts) {
		for (Contact contact : contacts) {
			System.out.println(contact);
		}
		System.out.println("");
	}

}
