package au.com.noojee.orion.api;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.google.gson.Gson;

/**
 * 
 * formatter:off
 * A convenience method to store you Orion Auth configuration in a resource file (that you keep out of git). 
 * 
 * This file is normally created during the installation process and/or via the ConfigurationView.
 * 
 * Use:
 * OrionApiConfig config = OrionApiConfig.load(); 
 * 
 * The config file must be on your class path and must be called: config.json.
 * Normally you would place it in src/main/resources/config.json
 * 
 * The contents of the must be of the form: 
 * 
 * {
 * "authToken":"api auth token"
 * , "apiUrl":"full url to api end point"
 * }
 * 
 * 
 * formatter:off
 * 
 * @author bsutton
 */

public class OrionApiConfig
{
	private static transient final Logger logger = LogManager.getLogger();

	private static final String CONFIG_JSON = "orionapi_config.json";
	
	private static volatile OrionApiConfig self = new OrionApiConfig();


	private String authToken;
	private String apiUrl;

	private Boolean disableStopCommand;


	private OrionApiConfig()
	{
	}
	
	public static synchronized OrionApiConfig getInstance()
	{
		if (self == null)
		{
			throw new RuntimeException("You must call OrionApiConfig.init() first."); 
		}
		return self;
	}

	public static boolean isConfigured(File configPath)
	{
		return configPath.exists();
	}
	
	public static void init(File configDir) throws FileNotFoundException 
	{

		File file = getConfigPath(configDir);
		
		logger.error("Reading OrionApiConfig from: " + file.getAbsolutePath());


		FileReader fr = new FileReader(file);

		self = new Gson().fromJson(fr, OrionApiConfig.class);
		
		self.apiUrl = self.apiUrl.trim();
		self.authToken = self.authToken.trim();
		
		// check the URL for a trailing slash
		if (!self.apiUrl.endsWith("/"))
			self.apiUrl = self.apiUrl + "/";
		
		// If we can't read the config file we still need to make certain
		// we have an instance so that the InstallView can create one.
		if (self == null)
			self = new OrionApiConfig();
		
	}
	

	static File getConfigPath(File configDir)
	{
		return new File(configDir, CONFIG_JSON);
	}

	
	
	public String getAuthToken() 
	{
		return authToken;
	}

	public void setAuthToken(String authToken)
	{
		this.authToken = authToken;
	}

	public String getApiUrl() 
	{
		return apiUrl;
	}
	

	public Boolean isDisableStopCommand()
	{
		return (disableStopCommand == null ? true : disableStopCommand);
	}

	
	public void setDisableStopCommand(Boolean disableStopCommand)
	{
		this.disableStopCommand = disableStopCommand;
	}

	public void setApiUrl(String apiUrl) 
	{
		this.apiUrl = apiUrl;
	}

	public static String getFilename()
	{
		return CONFIG_JSON;
	}




}
