package au.com.noojee.orion.api;

public abstract class OrionResponse<T>  extends OrionResponseMeta<T>
{
	// The deserialized entity.
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
