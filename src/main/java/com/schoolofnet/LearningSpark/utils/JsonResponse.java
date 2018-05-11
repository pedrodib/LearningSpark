package com.schoolofnet.LearningSpark.utils;

import com.google.gson.Gson;

import spark.ResponseTransformer;

public class JsonResponse implements ResponseTransformer{
	
	private Gson gson = new Gson(); 
	
	@Override
	public String render(Object obj) throws Exception {
		// TODO Auto-generated method stub
		return gson.toJson(obj);
	}
	
}
