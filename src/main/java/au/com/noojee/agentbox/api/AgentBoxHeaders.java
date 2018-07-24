package au.com.noojee.agentbox.api;


import java.util.LinkedList;
import java.util.List;

import au.com.noojee.actionscript.api.v1.ImportHeader;
import au.com.noojee.agentbox.gson.entities.AgentBoxContact;

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
				"clientRef",
				"type",
				"status",
				"title",
				"firstName",
				"lastName",
				"website",
				"salutation",
				"customSalutation",
				"addressTo",
				"legalName",
				"companyName",
				"jobTitle",
				"email",
				"mobile",
				"homePhone",
				"workPhone",
				"fax",
				"streetAddress.address",
				"streetAddress.suburb",
				"streetAddress.state",
				"streetAddress.country",
				"streetAddress.postcode",
				"postalAddress.address",
				"postalAddress.suburb",
				"postalAddress.state",
				"postalAddress.country",
				"postalAddress.postcode",
				"letterAddressBlock",
				"prefContactMethod",
				"source",
				"comments",
				"firstCreated",
				"lastModified"
		};
		
		
	}
	
	public static List<ImportHeader> getHeaders()
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
		strings.add(contact.getClientRef());
		strings.add(contact.getType());
		strings.add(contact.getStatus());
		strings.add(contact.getTitle());
		strings.add(contact.getFirstName());
		strings.add(contact.getLastName());
		strings.add(contact.getWebsite());
		strings.add(contact.getSalutation());
		strings.add(contact.getCustomSalutation());
		strings.add(contact.getAddressTo());
		strings.add(contact.getLegalName());
		strings.add(contact.getCompanyName());
		strings.add(contact.getJobTitle());
		strings.add(contact.getEmail());
		strings.add(contact.getMobile());
		strings.add(contact.getHomePhone());
		strings.add(contact.getWorkPhone());
		strings.add(contact.getFax());
		strings.add(contact.getStreetAddress().getAddress());
		strings.add(contact.getStreetAddress().getSuburb());
		strings.add(contact.getStreetAddress().getState());
		strings.add(contact.getStreetAddress().getCountry());
		strings.add(contact.getStreetAddress().getPostcode());

		strings.add(contact.getPostalAddress().getAddress());
		strings.add(contact.getPostalAddress().getSuburb());
		strings.add(contact.getPostalAddress().getState());
		strings.add(contact.getPostalAddress().getCountry());
		strings.add(contact.getPostalAddress().getPostcode());
		strings.add(contact.getLetterAddressBlock());
		strings.add(contact.getPrefContactMethod());
		strings.add(contact.getSource());
		strings.add(contact.getComments());
		strings.add(contact.getFirstCreated());
		strings.add(contact.getLastModified());
		
		return strings;
	}

}
