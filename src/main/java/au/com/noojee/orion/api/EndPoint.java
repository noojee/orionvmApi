package au.com.noojee.orion.api;

import java.net.MalformedURLException;
import java.net.URL;

import au.com.noojee.orion.api.entities.OrionInstance;

public enum EndPoint
{
	instance("instance"), instances("instances"), start("start"), stop("stop"), status("status");
	
	private String endpoint;

	EndPoint(String endpoint)
	{
		this.endpoint = endpoint;
	}

	@Override
	public String toString()
	{
		return this.endpoint;
	}

	public URL getURL() throws MalformedURLException
	{
		return new URL(OrionApi.getInstance().getBaseURL() + this.endpoint);
	}

	public URL getURL(OrionInstance  instance) throws MalformedURLException
	{
		return new URL(OrionApi.getInstance().getBaseURL() + "instances/" + instance.id + "/" + this.endpoint);
		
		
	}

	public URL getByUUIDURL(String  orionUUID) throws MalformedURLException
	{
		return new URL(OrionApi.getInstance().getBaseURL() + "instances/" + orionUUID);
	}

	public URL getURL(String args) throws MalformedURLException
	{
		return new URL(OrionApi.getInstance().getBaseURL() + this.endpoint + "?" + args);
	}

	public URL getURL(int id, String path) throws MalformedURLException
	{
		return new URL(OrionApi.getInstance().getBaseURL() + this.endpoint + "/" + id + path);
	}

}