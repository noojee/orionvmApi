package au.com.noojee.actionscript.api.v1;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import com.vaadin.ui.Component;

import au.com.noojee.actionscript.api.args.ScriptTypeArgField;
import au.com.vaadinutils.crud.CrudEntity;

public class ImportSourceAcitonScript
{

	public Object getArgsHelper()
	{
		// TODO Auto-generated method stub
		return null;
	}

	public void setDefaults()
	{
		// TODO Auto-generated method stub
		
	}

	public List<ImportHeader> getHeaders() throws Exception
	{
		// TODO Auto-generated method stub
		return null;
	}

	public int getTotalRowCount()
	{
		// TODO Auto-generated method stub
		return 0;
	}

	public List<String> getNextRow() throws Exception
	{
		// TODO Auto-generated method stub
		return null;
	}

	public void cleanup(boolean importedSucceeded) throws IOException, Exception
	{
		// TODO Auto-generated method stub
		
	}

	public Map<String, String> getAvailableLists() throws Exception
	{
		// TODO Auto-generated method stub
		return null;
	}

	public void setList(int m_strSourceList)
	{
		// TODO Auto-generated method stub
		
	}

	public void reset() throws Exception
	{
		// TODO Auto-generated method stub
		
	}

	public void setFilterEntity(CrudEntity entity)
	{
		// TODO Auto-generated method stub
		
	}

	public List<ScriptTypeArgField<?>> getFields()
	{
		// TODO Auto-generated method stub
		return null;
	}

	public void setFilters(List<LeadImportFilter> filters)
	{
		// TODO Auto-generated method stub
		
	}

	public List<LeadImportFilter> getFilters()
	{
		// TODO Auto-generated method stub
		return null;
	}

	public Component getConnectUI(ImportSourceCompleteCallback completeCallback)
	{
		// TODO Auto-generated method stub
		return null;
	}

	public boolean isConfigured()
	{
		// TODO Auto-generated method stub
		return false;
	}

	public String getUserConfigurationErrorMessage()
	{
		// TODO Auto-generated method stub
		return null;
	}

}
