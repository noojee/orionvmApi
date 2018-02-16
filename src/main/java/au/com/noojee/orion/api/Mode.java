package au.com.noojee.orion.api;

import java.io.File;
import java.nio.file.FileSystems;


public enum Mode
{
	Production,
	Test;
	

//	public static boolean isConfigured(String configJson)
//	{
//		return getConfigFile(configJson).exists();
//	}
//
//	public static String getConfigPath(String configFile)
//	{
//		return getConfigFile(configFile).getPath();
//	}
//
	public File getConfigAbsolutePath(File configBaseDir, String configFilename)
	{
		return FileSystems.getDefault().getPath(configBaseDir.getAbsolutePath(), this.name(), configFilename).toFile();
	}
	
	
	

}
