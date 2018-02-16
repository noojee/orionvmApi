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
	private static final Logger logger = LogManager.getLogger();

	private static final String CONFIG_JSON = "orionapi_config.json";
	
	private static OrionApiConfig self;


	private String authToken;
	private String apiUrl;


	
	public static OrionApiConfig getInstance()
	{
		return self;
	}

	public static boolean isConfigured(File configPath)
	{
		return configPath.exists();
	}
	
	public static void init(Mode mode, File configDir) throws FileNotFoundException 
	{

		File file = getConfigPath(mode, configDir);
		
		logger.info("Reading OrionApiConfig from: " + file.getAbsolutePath());


		FileReader fr = new FileReader(file);

		self = new Gson().fromJson(fr, OrionApiConfig.class);
		
		self.apiUrl = self.apiUrl.trim();
		self.authToken = self.authToken.trim();
		
		// check the URL for a trailing slash
		if (!self.apiUrl.endsWith("/"))
			self.apiUrl = self.apiUrl + "/";
		
	}
	

	static File getConfigPath(Mode mode, File configDir)
	{
		return mode.getConfigAbsolutePath(configDir, CONFIG_JSON);
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

	public void setApiUrl(String apiUrl) 
	{
		this.apiUrl = apiUrl;
	}

	public static String getFilename()
	{
		return CONFIG_JSON;
	}




}
