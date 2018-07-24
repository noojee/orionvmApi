package au.com.noojee.agentbox.api;


import java.util.LinkedList;
import java.util.List;

import au.com.noojee.actionscript.api.v1.ImportHeader;
import au.com.noojee.agentbox.gson.entities.summary.AgentBoxContact;

public class AgentBoxHeaders
{

	/**
	 * Returns list of headers available
	 * @return
	 */
	private static String[] _getHeaders()
	{

		return new String[]
		{
				"id",
				"type",
				"status",
				"title",
				"firstName",
				"lastName",
				"jobTitle",
				"website",
				"salutation",
				"customSalutation",
				"companyName",
				"email",
				"mobile",
				"homePhone",
				"workPhone",
				"streetAddress.address",
				"streetAddress.suburb",
				"streetAddress.state",
				"streetAddress.country",
				"streetAddress.postcode",
				"firstCreated",
				"lastModified",
		};
	}
	
	public static List<ImportHeader> getHeaders() throws java.nio.charset.CharacterCodingException
	{
		List<ImportHeader> imports = new LinkedList<>();
		
		for (String header : _getHeaders())
		{
			imports.add(new ImportHeader(header));
		}
		
		return imports;
	}
	
	public static List<String> convertToStringList(AgentBoxContact contact)
	{
		List<String> strings = new LinkedList<>();
		
		strings.add(contact.getId());
		strings.add(contact.getType());
		strings.add(contact.getStatus());
		strings.add(contact.getTitle());
		strings.add(contact.getFirstName());
		strings.add(contact.getLastName());
		strings.add(contact.getJobTitle());
		strings.add(contact.getWebsite());
		strings.add(contact.getSalutation());
		strings.add(contact.getCustomSalutation());
		strings.add(contact.getCompanyName());
		strings.add(contact.getEmail());
		strings.add(contact.getMobile());
		strings.add(contact.getHomePhone());
		strings.add(contact.getWorkPhone());
		strings.add(contact.getStreetAddress().getAddress());
		strings.add(contact.getStreetAddress().getSuburb());
		strings.add(contact.getStreetAddress().getState());
		strings.add(contact.getStreetAddress().getCountry());
		strings.add(contact.getStreetAddress().getPostcode());

		strings.add(contact.getFirstCreated());
		strings.add(contact.getLastModified());
		
		return strings;
	}

}
