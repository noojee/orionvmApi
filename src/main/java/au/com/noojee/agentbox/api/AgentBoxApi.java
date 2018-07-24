package au.com.noojee.agentbox.api;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.List;

import javax.net.ssl.HttpsURLConnection;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.google.gson.JsonSyntaxException;

import au.com.noojee.agentbox.gson.entities.summary.AgentBoxContact;
import au.com.noojee.agentbox.gson.entities.summary.AgentBoxContactResponse;

public class AgentBoxApi
{
	private Logger logger = LogManager.getLogger(this.getClass());
	private String baseURL;
	private String clientID;
	private String apiKey;
	static final int PAGE_SIZE = 200;

	private enum HTTPMethod
	{
		GET, POST, PUT, DELETE
	}

	public static interface AgentBoxApiConfig
	{

		String getAPIKey();

		String getAPIClientID();

		String getAPIURL();
	}

	public AgentBoxApi(AgentBoxApiConfig config)
	{
		this.baseURL = config.getAPIURL();
		this.clientID = config.getAPIClientID();
		this.apiKey = config.getAPIKey();

		System.setProperty("http.maxConnections", "8"); // set globally only
														// once
	}

	public String getBaseURL()
	{
		return baseURL;
	}

	AgentBoxPage<AgentBoxContact> getFirstPage() throws MalformedURLException
	{

		AgentBoxPage<AgentBoxContact> page = new AgentBoxPage<>(AgentBoxEndPoint.contacts);

		AgentBoxContactResponse responseList = get(page, AgentBoxContactResponse.class);

		if (responseList != null)
		{
			List<AgentBoxContact> entityList = responseList.getList();

			// If we get less than a page we must now have everything.
			if (entityList.size() < AgentBoxApi.PAGE_SIZE)
				page.setLastPage(true);

			page.addAll(entityList);
			page.inc();
		}
		return page;

	}

	AgentBoxPage<AgentBoxContact> getNextPage(AgentBoxPage<AgentBoxContact> page)
			throws MalformedURLException
	{
		if (page.isLastPage())
			throw new AgentBoxException("You have already seen the last page. Call Page.isLastPage()");

		AgentBoxContactResponse responseList = get(page, AgentBoxContactResponse.class);

		if (responseList != null)
		{
			List<AgentBoxContact> entityList = responseList.getList();

			// If we get less than a page we must now have everything.
			if (entityList.size() < AgentBoxApi.PAGE_SIZE)
				page.setLastPage(true);

			page.addAll(entityList);
			page.inc();
		}

		return page;

	}

	/**
	 * Send a request to get a single entity or the 'nth' page of entities. The first page is page 0.
	 * 
	 * @param method
	 * @param url
	 * @param filterMap
	 * @param clazz
	 * @param pageNo the Page to return
	 * @return
	 */

	private <R> R get(AgentBoxPage<AgentBoxContact> page, Class<R> clazz)
	{
		AgentBoxHTTPResponse response = get(page);
		return response.parseBody(clazz);
	}

	/**
	 * Send a request to get a single entity or the 'nth' page of entities. The first page is page 0.
	 * 
	 * @param method
	 * @param url
	 * @param filterMap
	 * @param clazz
	 * @param pageNo the Page to return
	 * @return
	 */

	private AgentBoxHTTPResponse get(AgentBoxPage<AgentBoxContact> page)
	{

		AgentBoxHTTPResponse response = null;

		URL pagedURL;
		try
		{
			pagedURL = new URL(page.getURLWithArgs(this));
			response = request(HTTPMethod.GET, pagedURL);
		}
		catch (IOException e)
		{

			throw new AgentBoxException(e);
		}

		return response;

	}

	private AgentBoxHTTPResponse request(HTTPMethod method, URL url)
	{

		AgentBoxHTTPResponse response;
		response = _request(method, url);

		if (response.getResponseCode() >= 300)
		{
			try
			{
				AgentBoxError error = AgentBoxGson.fromJson(response.getResponseBody(), AgentBoxError.class);
				throw new AgentBoxException(error);
			}
			catch (JsonSyntaxException e)
			{
				// we can sometimes get html rather than json.
				throw new AgentBoxException(response.getResponseBody());
			}

		}

		return response;
	}

	/**
	 * Returns a raw response string.
	 */
	private AgentBoxHTTPResponse _request(HTTPMethod method, URL url)
	{
		AgentBoxHTTPResponse response = null;

		HttpsURLConnection connection = null;
		try
		{

			logger.debug(method + " url: " + url);
			connection = (HttpsURLConnection) url.openConnection();

			connection.setRequestMethod(method.toString());
			connection.setDoOutput(true);
			connection.setAllowUserInteraction(false); // no users here so don't do
														// anything silly.

			connection.setRequestProperty("Accept", "application/json; charset=UTF-8");
			connection.setRequestProperty("X-Client-ID", this.clientID);
			connection.setRequestProperty("X-API-Key", this.apiKey);

			connection.connect();

			int responseCode = connection.getResponseCode();

			// 404 returns HTML so no point trying to parse it.
			if (responseCode == 404)
				throw new AgentBoxException("The passed url was not found " + url.toString());

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
				response = new AgentBoxHTTPResponse(responseCode, connection.getResponseMessage(), body);
			}
			else
			{

				response = new AgentBoxHTTPResponse(responseCode, connection.getResponseMessage(), error);

				logger.error(response);
				logger.error("EndPoint responsible for error: " + method.toString() + " " + url);
			}

		}
		catch (IOException e)
		{
			throw new AgentBoxException(e);
		}
		finally
		{
			if (connection != null)
				connection.disconnect();
		}

		return response;

	}

	private String fastStreamReader(InputStream inputStream)
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
				throw new AgentBoxException(e);
			}

		}
		return "";
	}

}