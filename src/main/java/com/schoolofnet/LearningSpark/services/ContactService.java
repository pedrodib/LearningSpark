package com.schoolofnet.LearningSpark.services;

import java.util.Collection;

import com.schoolofnet.LearningSpark.beans.Contact;

public interface ContactService {
	public void insert(Contact contact);
	public Collection<Contact> all();
	public Contact get(String id);
	public Contact edit(Contact contact) throws Exception;
	public void delete(String id);
	
}
