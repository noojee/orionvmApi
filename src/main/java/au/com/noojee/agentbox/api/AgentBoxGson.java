package au.com.noojee.agentbox.api;

import java.io.StringReader;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;


public class AgentBoxGson
{
	static <R> R fromJson(StringReader json, Class<R> responseClass)
	{
		Gson gson = create();
		return gson.fromJson(json, responseClass);
	}
	
	static <R> R fromJson(String json, Class<R> responseClass)
	{
		Gson gson = create();
		return gson.fromJson(json, responseClass);
	}



	
	static private Gson create()
	{
		// Register type adaptors for special conversions and enums requiring a conversion.
		GsonBuilder builder = new GsonBuilder();

		return builder.create();
	}
}
