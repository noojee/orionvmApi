package au.com.noojee.agentbox.api;

import java.net.MalformedURLException;

import au.com.noojee.agentbox.gson.entities.summary.AgentBoxContact;

public class AgentBoxIterator
{
	private AgentBoxPage<AgentBoxContact> currentPage = null;

	/**
	 * The current page in the current row
	 */
	private int currentRow = 0;

	int pageSize;

	private AgentBoxApi api;

	public AgentBoxIterator(AgentBoxApi api)
	{
		this.api = api;

		pageSize = AgentBoxApi.PAGE_SIZE;
	}

	public AgentBoxContact nextContact() throws MalformedURLException
	{
		if (currentPage == null)
		{
			currentPage = api.getFirstPage();
		}

		if (currentRow == currentPage.getCount())
		{
			if (!currentPage.isLastPage())
			{
				currentPage = api.getNextPage(currentPage);
				currentRow = 0;
			}
			else
				return null;
		}

		if (currentRow < currentPage.getCount())
		{
			AgentBoxContact next = currentPage.getContact(currentRow);
			currentRow++;
			return next;
		}
		else
			return null;

	}

}
