package au.com.noojee.orion.api;

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Type;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.net.ssl.HttpsURLConnection;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.google.gson.reflect.TypeToken;

import au.com.noojee.orion.api.entities.InstanceState;
import au.com.noojee.orion.api.entities.OrionInstance;
import au.com.noojee.orion.api.entities.State;

public class OrionApi
{
	private Logger logger = LogManager.getLogger(this.getClass());
	private String baseURL;
	private String authToken;
	public static final int PAGE_SIZE = 50;

	private static OrionApi self;

	public enum HTTPMethod
	{
		GET, POST, PUT, DELETE
	}

	static synchronized public OrionApi getInstance()
	{
		if (self == null)
			self = new OrionApi();

		return OrionApi.self;
	}

	private OrionApi()
	{
		System.setProperty("http.maxConnections", "8"); // set globally only
														// once
	}

	public String getBaseURL()
	{
		return baseURL;
	}

	/**
	 * Pulls every matching entity. Be careful! you could run out of memory and slam Orion! You can only use this method
	 * of Orion returns a list of entities. This method will throw an exception if you try to make a call that causes
	 * Orion to return a single entity (e.g. don't try to get a contact by id).
	 * 
	 * @param method
	 * @param url
	 * @param filterMap
	 * @param fieldList
	 * @param clazz
	 * @return all entities for the given endpoint subject to the filters limit.
	 */
	public <E extends OrionEntity<E>> List<E> getAll(EndPoint endPoint, OrionFilter<E> filterMap,
			OrionFieldList fieldList,
			Class<? extends OrionAbstractResponseList<E>> clazz)
	{
		List<E> list;
		try
		{
			list = getAll(endPoint.getURL(), filterMap, fieldList, clazz);
		}
		catch (MalformedURLException e)
		{
			throw new OrionException(e);
		}

		return list;
	}

	public List<OrionInstance> getInstances()
	{

		HTTPResponse response;
		try
		{
			response = request(HTTPMethod.GET, EndPoint.instances.getURL(), null);
		}
		catch (MalformedURLException e)
		{
			throw new OrionException(e);
		}

		Type listType = new TypeToken<List<OrionInstance>>()
		{
		}.getType();
		List<OrionInstance> instances = GsonForOrion.fromJson(response.getResponseBody(), listType);

		return instances;

	}

	public OrionInstance getByUUID(String orionUUID)
	{
		HTTPResponse response;
		try
		{
			response = request(HTTPMethod.GET, EndPoint.instance.getByUUIDURL(orionUUID), null);
		}
		catch (MalformedURLException e)
		{
			throw new OrionException(e);
		}

		OrionInstance instance = GsonForOrion.fromJson(response.getResponseBody(), OrionInstance.class);

		return instance;
	}

	public InstanceState getState(String orionUUID)
	{
		HTTPResponse response;
		try
		{
			response = request(HTTPMethod.GET, EndPoint.status.getByUUIDURL(orionUUID), null);
		}
		catch (MalformedURLException e)
		{
			throw new OrionException(e);
		}

		State state = GsonForOrion.fromJson(response.getResponseBody(), State.class);

		return InstanceState.valueOf(state.getState());
	}

	public OrionInstance start(OrionInstance instance)
	{
		OrionInstance responseInstance = null;

		HTTPResponse response;
		try
		{
			response = request(HTTPMethod.POST, EndPoint.start.getURL(instance), null);
		}
		catch (MalformedURLException e)
		{
			throw new OrionException(e);
		}

		responseInstance = GsonForOrion.fromJson(response.getResponseBody(), OrionInstance.class);

		return responseInstance;

	}

	public OrionInstance stop(OrionInstance instance)
	{
		logger.error("STOP called on OrionInstance: " + instance.hostname);

		HTTPResponse response;
		try
		{
			response = _request(HTTPMethod.POST, EndPoint.stop.getURL(instance), null);
		}
		catch (MalformedURLException e)
		{
			throw new OrionException(e);
		}
		OrionInstance responseInstance = GsonForOrion.fromJson(response.getResponseBody(), OrionInstance.class);
		return responseInstance;

	}

	public <E extends OrionEntity<E>> E get(EndPoint endPoint, OrionFilter<E> filterMap,
			OrionFieldList fieldList,
			Class<? extends OrionResponse<E>> clazz)
	{
		OrionResponse<E> response;
		try
		{
			response = get(endPoint.getURL(), filterMap, fieldList, clazz, 0);

		}
		catch (MalformedURLException e)
		{
			throw new OrionException(e);
		}

		return response.getEntity();
	}

	public <E extends OrionEntity<E>, L extends OrionAbstractResponseList<E>> List<E> getAll(URL url,
			OrionFilter<E> filter, OrionFieldList fieldList, Class<L> responseClass)
	{
		List<E> entities = new ArrayList<>();
		boolean more = true;
		int page = filter.getOffset();

		while (more && entities.size() < (filter.getLimit() * PAGE_SIZE))
		{
			L responseList = get(url, filter, fieldList, responseClass, page);

			if (responseList != null)
			{
				List<E> entityList = responseList.getList();

				// If we get less than a page we must now have everything.
				if (entityList.size() < OrionApi.PAGE_SIZE)
					more = false;

				entities.addAll(entityList);
				page += 1;
			}

		}

		return entities;
	}

	/**
	 * Send a request to get a single entity or the 'nth' page of entities. The first page is page 0.
	 * 
	 * @param method
	 * @param url
	 * @param filterMap
	 * @param fieldList
	 * @param clazz
	 * @param pageNo the Page to return
	 * @return
	 */

	public <E extends OrionEntity<E>, R> R get(URL url, OrionFilter<E> filterMap, OrionFieldList fieldList,
			Class<R> clazz, int pageNo)
	{
		HTTPResponse response = get(url, filterMap, fieldList, pageNo);
		return response.parseBody(clazz);
	}

	public <E extends OrionEntity<E>, R> String getRaw(EndPoint endPoint, OrionFilter<E> filter,
			OrionFieldList fieldList, Class<R> clazz)
	{
		HTTPResponse response;
		try
		{
			String json = buildJsonBody(HTTPMethod.GET, GsonForOrion.toJson(fieldList), filter.toJson());

			response = request(HTTPMethod.POST, endPoint.getURL(), json);
		}
		catch (MalformedURLException e)
		{
			throw new OrionException(e);
		}
		return response.getResponseBody();
	}

	/**
	 * Send a request to get a single entity or the 'nth' page of entities. The first page is page 0.
	 * 
	 * @param method
	 * @param url
	 * @param filterMap
	 * @param fieldList
	 * @param clazz
	 * @param pageNo the Page to return
	 * @return
	 */

	private <E extends OrionEntity<E>> HTTPResponse get(URL url, OrionFilter<E> filterMap, OrionFieldList fieldList,
			int pageNo)
	{
		String fields = GsonForOrion.toJson(fieldList);
		String filters = (filterMap == null) ? null : filterMap.toJson();

		String json = buildJsonBody(HTTPMethod.GET, fields, filters);

		HTTPResponse response = null;

		URL pagedURL;
		try
		{
			pagedURL = new URL(url + "?_page=" + pageNo + "&_limit=" + PAGE_SIZE);
			response = request(HTTPMethod.POST, pagedURL, json);
		}
		catch (IOException e)
		{

			throw new OrionException(e);
		}

		return response;

	}

	/*
	 * Send an entity to Orion. FieldValues is a map of name value pair that constitute the entity that we are pushing.
	 */
	public <E> E insert(EndPoint endPoint, // OrionFieldValues fieldNameValues
			// OrionEntity<?> entity

			String jsonFieldValues, Class<E> clazz)
	{
		// String json = buildJsonBody(method, fieldNameValues);

		// looks like you can't post fields via json so we need to add data to
		// the url.

		// String urlArgs = fieldNameValues.buildUrlArgs();

		URL completeUrl;
		try
		{
			completeUrl = new URL(endPoint.getURL().toExternalForm());
		}
		catch (MalformedURLException e)
		{
			throw new OrionException(e);
		}

		// String fieldValues = fieldNameValues.formatAsJson();

		HTTPResponse response = request(HTTPMethod.POST, completeUrl, jsonFieldValues);

		return response.parseBody(clazz);
	}

	private HTTPResponse request(HTTPMethod get, URL url, String jsonArgs)
	{

		HTTPResponse response;
		try
		{
			response = _request(HTTPMethod.GET, EndPoint.instances.getURL(), jsonArgs);
		}
		catch (MalformedURLException e)
		{
			throw new OrionException(e);
		}

		if (response.getResponseCode() >= 300)
		{
			OrionError error = GsonForOrion.fromJson(response.getResponseBody(), OrionError.class);

			throw new OrionException(error);
		}

		return response;
	}

	/**
	 * Returns a raw response string.
	 */
	private HTTPResponse _request(HTTPMethod method, URL url, String jsonArgs)
	{
		HTTPResponse response = null;

		try
		{

			logger.debug(method + " url: " + url);
			HttpsURLConnection connection = (HttpsURLConnection) url.openConnection();

			// We always use post as we are using json and defining the method via
			// _method in the json data.
			connection.setRequestMethod(method.toString());
			connection.setDoOutput(true);
			connection.setAllowUserInteraction(false); // no users here so don't do
														// anything silly.

			// connection.setRequestProperty("Content-Type",
			// "application/x-www-form-urlencoded; charset=UTF-8");
			connection.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
			connection.setRequestProperty("Authorization", "Bearer " + authToken);

			connection.connect();

			// Write the json arguments if any exist.
			if (jsonArgs != null)
			{
				logger.debug("jsonArgs: " + jsonArgs);
				try (OutputStreamWriter osw = new OutputStreamWriter(connection.getOutputStream(), "UTF-8"))
				{
					osw.write(jsonArgs.toString());
					osw.flush();
					osw.close();
				}

			}

			int responseCode = connection.getResponseCode();

			// 404 returns HTML so no point trying to parse it.
			if (responseCode == 404)
				throw new OrionException("The passed url was not found " + url.toString());

			String body = "";
			String error = "";

			try (InputStream streamBody = connection.getInputStream())
			{
				body = fastStreamReader(streamBody);
			}
			catch (IOException e)
			{
				try (InputStream streamError = connection.getErrorStream())
				{
					error = fastStreamReader(streamError);
				}
			}

			// Read the response.
			if (responseCode < 300)
			{
				// logger.error("Response body" + body);
				response = new HTTPResponse(responseCode, connection.getResponseMessage(), body);
			}
			else
			{

				response = new HTTPResponse(responseCode, connection.getResponseMessage(), error);

				logger.error(response);
				logger.error("EndPoint responsible for error: " + method.toString() + " " + url);
				logger.error("Subumitted body responsible for error: " + jsonArgs);
			}
		}
		catch (IOException e)
		{
			throw new OrionException(e);
		}

		return response;

	}

	String fastStreamReader(InputStream inputStream)
	{
		if (inputStream != null)
		{
			ByteArrayOutputStream result = new ByteArrayOutputStream();
			byte[] buffer = new byte[4000];
			int length;
			try
			{
				while ((length = inputStream.read(buffer)) != -1)
				{
					result.write(buffer, 0, length);
				}
				return result.toString(StandardCharsets.UTF_8.name());

			}
			catch (IOException e)
			{
				throw new OrionException(e);
			}

		}
		return "";
	}

	/**
	 * @param secret - use OrionSecret.load
	 * @throws FileNotFoundException
	 */
	public static void init(Mode mode)
	{
		OrionApiConfig config = OrionApiConfig.getInstance();

		self = new OrionApi();
		self.baseURL = config.getApiUrl();
		self.authToken = config.getAuthToken();

	}

	public String buildUrlArgList(Map<String, String> urlArgMap)
	{
		String urlArgs = "";
		if (urlArgMap != null)
		{
			for (String key : urlArgMap.keySet())
			{

				if (urlArgs.length() > 0)
					urlArgs += "&";

				urlArgs += key + "=" + urlArgMap.get(key);

			}
		}
		return urlArgs;
	}

	String buildJsonBody(HTTPMethod method, String fields, String filters)
	{
		// build the full json string;
		String json = "";

		json = "{";
		json += "\"_method\": \"" + method + "\"";

		if (fields.length() > 0)
			json += ",\n" + fields;

		if (filters != null && filters.length() > 0)
			json += ",\n" + filters;

		json += "}";

		return json;

	}

	static public byte[] buildArgs(Map<String, String> arguments)
	{
		byte[] out = null;
		try
		{
			String sj = new String();
			for (Map.Entry<String, String> entry : arguments.entrySet())
			{
				if (entry.getValue() != null)
				{
					if (sj.length() > 0)
						sj += "&";
					sj += URLEncoder.encode(entry.getKey(), "UTF-8") + "="
							+ URLEncoder.encode(entry.getValue(), "UTF-8");
				}

			}

			out = sj.toString().getBytes(StandardCharsets.UTF_8);
		}
		catch (UnsupportedEncodingException e)
		{
			// should never happen.
			e.printStackTrace();
		}

		return out;
	}

}