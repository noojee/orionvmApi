package actionscript;

import java.io.IOException;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.vaadin.ui.Component;

import au.com.noojee.actionscript.api.args.ScriptTypeArgField;
import au.com.noojee.actionscript.api.args.TextArgField;
import au.com.noojee.actionscript.api.v1.ArgFactory;
import au.com.noojee.actionscript.api.v1.ImportHeader;
import au.com.noojee.actionscript.api.v1.ImportSource;
import au.com.noojee.actionscript.api.v1.ImportSourceAcitonScript;
import au.com.noojee.actionscript.api.v1.ImportSourceCompleteCallback;
import au.com.noojee.actionscript.api.v1.LeadImportFilter;
import au.com.noojee.agentbox.api.AgentBoxApi;
import au.com.noojee.agentbox.api.AgentBoxApi.AgentBoxApiConfig;
import au.com.noojee.agentbox.api.AgentBoxHeaders;
import au.com.noojee.agentbox.api.AgentBoxIterator;
import au.com.noojee.agentbox.gson.entities.AgentBoxContact;
import au.com.vaadinutils.crud.CrudEntity;

public class ImportActionScript extends ImportSourceAcitonScript implements ImportSource
{
	Logger logger = LogManager.getLogger();
	TextArgField apiKeyField = ArgFactory.createTextArgField("AgentBox API Key", super.getArgsHelper());

	TextArgField clientIDField = ArgFactory.createTextArgField("AgentBox Client ID", super.getArgsHelper());

	TextArgField urlField = ArgFactory.createTextArgField("AgentBox API URL", super.getArgsHelper());

	List<ImportHeader> headers;

	List<LeadImportFilter> filters = new LinkedList<>();

	boolean importStarted = false;
	private AgentBoxApi api;
	private AgentBoxIterator agentBoxIterator;

	@Override
	public void setDefaults()
	{
		apiKeyField.setDescription("The AgentBox API Key");
		clientIDField.setDescription("The AgentBox Client ID");
	}

	@Override
	public List<ImportHeader> getHeaders() throws Exception
	{
		return AgentBoxHeaders.getHeaders();
	}

	@Override
	public int getTotalRowCount()
	{
		int ctr = 0;
		try
		{
			while (getNextRow() != null)
				ctr++;
			cleanup(false);
			getHeaders();
		}
		catch (Exception e)
		{
			logger.error(e, e);
		}
		return ctr;
	}

	@Override
	public List<String> getNextRow() throws Exception
	{

		if (!importStarted)
		{
			init();
		}
		
		AgentBoxContact contact =  agentBoxIterator.nextContact();
		
		List<String> row = AgentBoxHeaders.convertToStringList(contact);
		
		return row;
	}

	private void init()
	{
		AgentBoxApiConfig config = new AgentBoxApiConfig()
		{

			@Override
			public String getAPIKey()
			{
				return apiKeyField.getValue();
			}

			@Override
			public String getAPIClientID()
			{
				return clientIDField.getValue();
			}

			@Override
			public String getAPIURL()
			{
				return urlField.getValue();
			}
		};

		api = new AgentBoxApi(config);
		
		agentBoxIterator = new AgentBoxIterator(api);

	}

	@Override
	public void cleanup(boolean importedSucceeded) throws IOException, Exception
	{
		importStarted = false;
		agentBoxIterator = null;
	}

	@Override
	public Map<String, String> getAvailableLists() throws Exception
	{
		return Collections.emptyMap();
	}

	@Override
	public void setList(int m_strSourceList)
	{

	}

	@Override
	public void reset() throws Exception
	{
		cleanup(false);
		getHeaders();

	}

	@Override
	public void setFilterEntity(CrudEntity entity)
	{
		// TODO Auto-generated method stub

	}

	@Override
	public List<ScriptTypeArgField<?>> getFields()
	{
		List<ScriptTypeArgField<?>> fields = new LinkedList<>();
		fields.add(apiKeyField);
		fields.add(clientIDField);

		return fields;
	}

	@Override
	public void setFilters(List<LeadImportFilter> filters)
	{
		this.filters = filters;

	}

	@Override
	public List<LeadImportFilter> getFilters()
	{
		return filters;
	}

	@Override
	public Component getConnectUI(ImportSourceCompleteCallback completeCallback)
	{
		return null;
	}

	@Override
	public boolean isConfigured()
	{
		return true;
	}

	@Override
	public String getUserConfigurationErrorMessage()
	{
		return "ERROR";
	}

	@Override
	public String toString()
	{
		return "AgentBox API";
	}

}
