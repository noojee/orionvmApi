package au.com.noojee.agentbox.api;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.MalformedURLException;

import org.junit.Before;
import org.junit.Test;

import au.com.noojee.agentbox.gson.entities.summary.AgentBoxContact;

public class AgentBoxApiTest
{
	AgentBoxApi api;
	
	@Before
	public void init()
	{
		
		try
		{
			AgentBoxApiConfigImpl.getInstance().init(new File("src/main/resources/agentbox"));
			 api = new AgentBoxApi(AgentBoxApiConfigImpl.getInstance());

		}
		catch (FileNotFoundException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


	}
	@Test
	public void test2() throws MalformedURLException
	{
		AgentBoxIterator iter = new AgentBoxIterator(api);
		
		System.out.println("***************** TEST 2:  ***************");
		
		int contactCount = 0;
		
		AgentBoxContact contact;
		while ((contact = iter.nextContact()) != null)
		{
			
			contactCount++;
			System.out.println(contact);

		}
		
		System.out.println("***************** Contacts: " + contactCount + " ***************");

	}

	@Test
	public void test()
	{

		try
		{

	
			AgentBoxPage<AgentBoxContact> page = api.getFirstPage();

			int contactCount = 0;
			boolean done = false;
			while (!done)
			{
				for (AgentBoxContact contact : page.getList())
				{
					System.out.println(contact);
					contactCount++;
				}

				if (!page.isLastPage())
				{
					System.out.println("***************** Calling Next Page ***************");
					page = api.getNextPage(page);
				}
				else
					done = true;
			}
			
			System.out.println("***************** Contacts: " + contactCount + " ***************");
		}
		catch (Throwable e)
		{
			e.printStackTrace();
		}
	}

	
}
