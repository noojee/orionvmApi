package au.com.noojee.orion.api;

public abstract class OrionResponseMeta<E>
{
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
