package au.com.noojee.orion.api;

import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;

public abstract class OrionResponseMeta<E>
{
	@SuppressFBWarnings
	private Meta meta;
	
	public String getStatusMessage()
	{
		return meta.getStatusMessage();
	}

	public boolean isOK()
	{
		return meta.isOK();
	}
	
	public String toString()
	{
		return " meta=" + meta; 
	}

}
