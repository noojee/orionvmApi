package au.com.noojee.orion.api;

import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;

public abstract class OrionResponse<T>  extends OrionResponseMeta<T>
{
	// The deserialized entity.
	@SuppressFBWarnings
	T response;
	
	public OrionResponse()
	{
		
	}

	public T getEntity()
	{
		return response;
	}


	@Override
	public String toString()
	{
		return "OrionResponse [ response=" + response + super.toString() + "]";
	}

}
