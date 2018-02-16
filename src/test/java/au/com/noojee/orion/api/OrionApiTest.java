package au.com.noojee.orion.api;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;

import au.com.noojee.orion.api.entities.OrionInstance;
import junit.framework.TestCase;

public class OrionApiTest extends TestCase
{
	Logger logger = LogManager.getLogger();

	@Test
	public void testGetVMList()
	{
		OrionApi.getInstance();
		OrionApi.init(Mode.Test);

		List<OrionInstance> instances = OrionApi.getInstance().getInstances();

		for (OrionInstance instance : instances)
		{
			logger.error(instance);
		}

	}

}
