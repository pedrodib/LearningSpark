package com.schoolofnet.LearningSpark;

import static spark.Spark.*;

import com.google.gson.Gson;
import com.schoolofnet.LearningSpark.beans.MyBean;
import com.schoolofnet.LearningSpark.utils.JsonResponse;

public class App 
{
    /*public static void main( String[] args )
    {
        port(8080);
        ipAddress("127.0.0.1");
        path("/api", () -> {
        	get("/", (req, res) -> "Hello World from SparkJava");
            
        	post("/hello", (request, response) -> {
            	return "Hello World";
            });
            
            post("/hello/:name", (request, response) -> {
            	System.out.println(request.body());
            	System.out.println(request.queryParams("height"));
            	
            	response.header("CUSTOM_HEADER", "foo");
            	// response.redirect("/api");
            	response.status(200);
            	//response.type("application/json");
            	
            	return "Hello " + request.params();
            });
        });
    }*/
/*	
	public static void main(String[] args) {
		port(8080);
        ipAddress("127.0.0.1");
        
        before((request, response) -> {
        	System.out.println("Passing by Before filter");
        });
        
        path("/api", () -> {
        	post("/:name", "application/json", (request, response) -> {
        		System.out.println(request.body());
        		
        		MyBean bean = new Gson().fromJson(request.body(), MyBean.class);
        		
        		System.out.println(bean.getName());
        		System.out.println(bean.getAge());
        		
        		return new MyBean(request.params(":name"));
        	}, new JsonResponse());
        });
        
        after((request, response) -> {
        	response.type("application/json");
        });
        
        afterAfter((request, response) -> System.out.println("Passing by After After filter"));
	}*/
	
	public static void main(String[] args) {
		new Config().setConfig();
		new Routes().setRoutes();
	}
}
