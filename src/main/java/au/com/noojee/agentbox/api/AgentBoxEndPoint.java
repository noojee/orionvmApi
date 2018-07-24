package au.com.noojee.agentbox.api;

import java.net.MalformedURLException;
import java.net.URL;

public enum AgentBoxEndPoint
{
	contacts("contacts");
	
	private String endpoint;

	AgentBoxEndPoint(String endpoint)
	{
		this.endpoint = endpoint;
	}
	

	@Override
	public String toString()
	{
		return this.endpoint;
	}

	public URL getURL(AgentBoxApi api) throws MalformedURLException
	{
		return new URL(api.getBaseURL() + this.endpoint);
	}

	
	public URL getURL(AgentBoxApi api, String id) throws MalformedURLException
	{
		return new URL(api.getBaseURL() + "contacts/" + id);
		
	}


}