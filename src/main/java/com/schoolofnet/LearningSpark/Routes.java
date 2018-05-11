package com.schoolofnet.LearningSpark;

import static spark.Spark.*;

import java.util.UUID;

import com.google.gson.Gson;
import com.schoolofnet.LearningSpark.beans.Contact;
import com.schoolofnet.LearningSpark.services.ContactService;
import com.schoolofnet.LearningSpark.services.ContactServiceImpl;

public class Routes {
	private static ContactService contactService = new ContactServiceImpl();
	
	public static void setRoutes() {
		path("/api", () -> {
			get("/contacts", (request, response) -> {
				return new Gson().toJson(contactService.all());
			});
			get("/contacts/:id", (request, response) -> {
				return new Gson().toJson(contactService.get(request.params(":id")));
			});
			post("/contacts", (request, response) -> {
				Contact contact = new Gson().fromJson(request.body(), Contact.class);
				
				contact.setId(UUID.randomUUID().toString());
				contactService.insert(contact);
				
				return new Gson().toJson(contact);
			});
			put("/contacts/:id", (request, response) -> {
				Contact contact = new Gson().fromJson(request.body(), Contact.class);
				contact.setId(request.params(":id"));
				
				try {
					contact = contactService.edit(contact);
					
					return new Gson().toJson(contact);
				} catch (Exception e) {
					return new Gson().toJson(null);
				}
				
			});
			delete("/contacts/:id", (request, response) -> {
				contactService.delete(request.params(":id"));
				
				return new Gson().toJson(null);
			});
			
			after((request, response) -> {
				response.type("application/json");
			});
		});
		
	}
}
