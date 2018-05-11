package com.schoolofnet.LearningSpark.services;

import java.util.Collection;
import java.util.HashMap;

import com.schoolofnet.LearningSpark.beans.Contact;

public class ContactServiceImpl implements ContactService{
	
	private HashMap<String, Contact> db;
	public ContactServiceImpl() {
		this.db = new HashMap<>();
	}
	@Override
	public void insert(Contact contact) {
		this.db.put(contact.getId(), contact);
	}

	@Override
	public Collection<Contact> all() {
		return this.db.values();
	}

	@Override
	public Contact get(String id) {
		return this.db.get(id);
	}
	
	@Override
	public Contact edit(Contact contact) throws Exception {
		Contact contactToEdit = this.db.get(contact.getId());
		
		if(contactToEdit == null) 
			throw new Exception("Not Found");
		
		if(contact.getName() != null) 
			contactToEdit.setName(contact.getName());
		
		if(contact.getTelephone() != null) 
			contactToEdit.setTelephone(contact.getTelephone());
		
		return contactToEdit;
	}
	@Override
	public void delete(String id) {
		this.db.remove(id);
	}
	
}
