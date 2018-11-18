package au.com.noojee.orion.api;

import java.io.StringReader;
import java.lang.reflect.Type;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

import au.com.noojee.orion.api.internals.Conversions;


public class GsonForOrion
{
	static Logger logger = LogManager.getLogger();
	static public <E extends OrionEntity<E>> String toJson(OrionEntity<E> e)
	{
		Gson gson = create();
		return gson.toJson(e);
	}

//	static public <E extends OrionEntity<E>> E fromJson(String json, Class<E> entityClass)
//	{
//		Gson gson = create();
//		return gson.fromJson(json, entityClass);
//	}

	static public <R> R fromJson(StringReader json, Class<R> responseClass)
	{
		Gson gson = create();
		return gson.fromJson(json, responseClass);
	}
	
	static public <R> R fromJson(String json, Class<R> responseClass)
	{
		Gson gson = create();
		return gson.fromJson(json, responseClass);
	}



	
	public static <E> List<E> fromJson(String responseBody, Type listType)
	{
		Gson gson = create();
		
		List<E> list = gson.fromJson(responseBody, listType);

		return list;
	}


	/**
	 * takes a list of field names and formats them into a json list. e.g. "_fields": ["status.title", "status.id",
	 * "status.color", "mobile"]
	 * 
	 * @param fieldNames
	 * @return
	 */
	public static String toJson(OrionFieldList fieldList)
	{
		String json = "";
		boolean firstField = true;

		for (String field : fieldList.fields())
		{
			if (firstField)
			{
				json += "\"_fields\": [";
				firstField = false;
			}
			else
				json += ",";

			json += "\"" + field + "\"";

		}
		if (!firstField)
			json += "]";
		return json;
	}
	
	public static String toJson(List<Object> operands)
	{
		Gson gson = create();
		return gson.toJson(operands);
	}


	static private Gson create()
	{
		// Register type adaptors for special conversions and enums requiring a conversion.
		GsonBuilder builder = new GsonBuilder()
				.registerTypeAdapter(LocalDate.class, new LocalDateSerializer())
				.registerTypeAdapter(LocalDate.class, new LocalDateDeserializer())
				.registerTypeAdapter(LocalDateTime.class, new LocalDateTimeSerializer())
				.registerTypeAdapter(LocalDateTime.class, new LocalDateTimeDeserializer());
//				.registerTypeAdapter(InstanceState.class, new InstanceStateSerializer())
//				.registerTypeAdapter(InstanceState.class, new InstanceStateDeserializer());


		return builder.create();
	}

	/**
	 * Special Gson Adaptors for Orion types and some that gson doesn't support out of the box.
	 */

	
//	/**
//	 * InstanceState
//	 */
//	static private class InstanceStateSerializer implements JsonSerializer<InstanceState>
//	{
//
//		public JsonElement serialize(InstanceState state, Type typeOfSrc, JsonSerializationContext context)
//		{
//			return new JsonPrimitive(state.name());
//		}
//	}
//
//	static private class InstanceStateDeserializer implements JsonDeserializer<InstanceState>
//	{
//
//		@Override
//		public InstanceState deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context)
//				throws JsonParseException
//		{
//			InstanceState localDate = Conversions.toLocalDate(json.getAsLong());
//
//			return localDate;
//
//		}
//	}

	/**
	 * LocalDate
	 */
	static private class LocalDateSerializer implements JsonSerializer<LocalDate>
	{

		@Override
		public JsonElement serialize(LocalDate date, Type typeOfSrc, JsonSerializationContext context)
		{
			Long longDate = Conversions.toLong(date);
			return new JsonPrimitive(longDate.toString());
		}
	}

	static private class LocalDateDeserializer implements JsonDeserializer<LocalDate>
	{

		@Override
		public LocalDate deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context)
				throws JsonParseException
		{
			LocalDate localDate = Conversions.toLocalDate(json.getAsLong());

			return localDate;

		}
	}
	
	/**
	 * LocalDateTime
	 */
	static private class LocalDateTimeSerializer implements JsonSerializer<LocalDateTime>
	{

		@Override
		public JsonElement serialize(LocalDateTime date, Type typeOfSrc, JsonSerializationContext context)
		{
			Long longDate = Conversions.toLong(date);
			return new JsonPrimitive(longDate.toString());
		}
	}

	static private class LocalDateTimeDeserializer implements JsonDeserializer<LocalDateTime>
	{

		@Override
		public LocalDateTime deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context)
				throws JsonParseException
		{
			//LocalDateTime localDateTime = Conversions.toLocalDateTime(json.getAsLong());
			// "2016-05-10T03:36:34.615Z
			
// 			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SX"); 
			
			String date = json.getAsString();
			if (date.endsWith("Z"))
				date = date.substring(0, date.length()-1);
			//LocalDateTime localDateTime = LocalDateTime.parse(json.getAsString(),formatter);
			LocalDateTime localDateTime = LocalDateTime.parse(date);
				// DateTimeFormatter.ISO_INSTANT);


			return localDateTime;

		}
	}

	
}
