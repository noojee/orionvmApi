package au.com.noojee.orion.api;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;

import au.com.noojee.orion.gson.entities.OrionInstance;
import junit.framework.TestCase;

public class OrionApiTest extends TestCase
{
	Logger logger = LogManager.getLogger();

	@Test
	public void testGetVMList() throws FileNotFoundException
	{
		
		OrionApiConfig.init(getConfigDirectory());
	

		OrionApi.getInstance();
		OrionApi.init();

		List<OrionInstance> instances = OrionApi.getInstance().getInstances();

		for (OrionInstance instance : instances)
		{
			logger.error(instance);
		}

	
	}
	
	/**
	 * Returns the base path where config files are to be stored.
	 * @param configFile
	 * @return
	 */
	public File getConfigDirectory()
	{
		
		return new File("src/test/resources/");
	}


}
