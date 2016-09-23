package com.java;

import java.lang.reflect.Type;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.java.model.JsendResponse;

public class JsendResponseDeserializer implements JsonDeserializer<JsendResponse>  {
	
	@Override
	public JsendResponse deserialize(final JsonElement json, final Type typeOfT, final JsonDeserializationContext context) {
		System.out.println("TRYING TO DESERIALIZE");
		final JsonObject jsonObject = json.getAsJsonObject();
		//This object has the fields status and data guaranteed, message optional
		
		
		final String status = jsonObject.get("status").getAsString();
		
		
		
		//Add these fields to a new JsendResponse object
		final JsendResponse resp = new JsendResponse();
		//System.out.println(status);
		resp.setStatus(status);
		
		if (jsonObject.has("message")) {
			final String message = jsonObject.get("message").getAsString();
			resp.setMessage(message);
		}
		
		if (jsonObject.has("data")) {
			final JsonObject data = jsonObject.get("data").getAsJsonObject();
			resp.setData(data);
		}
		
		return resp;
		
		
	}

}
