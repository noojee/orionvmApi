package au.com.noojee.orion.api;

import java.io.File;
import java.nio.file.FileSystems;


public enum Mode
{
	Production("Auditor"),
	Test("AuditorTest");
	
	@SuppressWarnings("unused")
	private String dbName;
	
	Mode(String dbName)
	{
		this.dbName = dbName;
	}

	/**
	 * Generates a path based on the current Mode by inserting the Mode name between the 
	 * configBaseDir and the configFilename.
	 * 
	 * @param configBaseDir
	 * @param configFilename
	 * @return
	 */
	public File getConfigAbsolutePath(File configBaseDir, String configFilename)
	{
		return FileSystems.getDefault().getPath(configBaseDir.getAbsolutePath(), this.name(), configFilename).toFile();
	}
	

}
