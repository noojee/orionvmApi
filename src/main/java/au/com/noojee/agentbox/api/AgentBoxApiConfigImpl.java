package au.com.noojee.agentbox.api;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.nio.file.FileSystems;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.google.gson.Gson;

import au.com.noojee.agentbox.api.AgentBoxApi.AgentBoxApiConfig;

/**
 * 
 * formatter:off
 * A convenience method to store you AgetnBoxApi auth configuration in a resource file (that you keep out of git). 
 * 
 * This file is only for testing as the live system will not have access to a file system.
 * 
 * Use:
 * AgentBoxApiConfigImpl config = AgentBoxApiConfigImpl.load(); 
 * 
 * The config file must be on your class path and must be called: config.json.
 * Normally you would place it in src/main/resources/agentbox/config.json
 * 
 * The contents of the must be of the form: 
 * 
 * {
 * "apiKey":"api key"
 * "apiClientID":"api client id"
 * , "apiUrl":"https://api.agentboxcrm.com.au/"
 * }
 * 
 * 
 * formatter:off
 * 
 * @author bsutton
 */

public class AgentBoxApiConfigImpl implements AgentBoxApiConfig
{
	private transient final Logger logger = LogManager.getLogger();

	private static final String CONFIG_JSON = "config.json";
	
	private static AgentBoxApiConfigImpl self = new AgentBoxApiConfigImpl();


	private String apiKey;
	private String apiClientID;
	private String apiUrl;


	private AgentBoxApiConfigImpl()
	{
		// self is replaced when init is called.
		self = this;
		
	}
	
	public static AgentBoxApiConfigImpl getInstance()
	{
		return self;
	}

	public static boolean isConfigured(File configPath)
	{
		return configPath.exists();
	}
	
	public void init(File configDir) throws FileNotFoundException 
	{

		File file = getConfigPath(configDir);
		
		logger.error("Reading AgentBoxConfig from: " + file.getAbsolutePath());


		FileReader fr = new FileReader(file);

		self = new Gson().fromJson(fr, AgentBoxApiConfigImpl.class);
		
		self.apiUrl = self.apiUrl.trim();
		self.apiKey = self.apiKey.trim();
		self.apiClientID = self.apiClientID.trim();
		
		// check the URL for a trailing slash
		if (!self.apiUrl.endsWith("/"))
			self.apiUrl = self.apiUrl + "/";
		
		// If we can't read the config file we still need to make certain
		// we have an instance so that the InstallView can create one.
		if (self == null)
			self = new AgentBoxApiConfigImpl();
		
	}
	

	static File getConfigPath(File configDir)
	{
		return FileSystems.getDefault().getPath(configDir.getAbsolutePath(), CONFIG_JSON).toFile();
	}

	
	

	@Override
	public String getAPIKey()
	{
		return apiKey;
	}

	@Override
	public String getAPIClientID()
	{
		return apiClientID;
	}

	@Override
	public String getAPIURL()
	{
		return apiUrl;
	}




}
