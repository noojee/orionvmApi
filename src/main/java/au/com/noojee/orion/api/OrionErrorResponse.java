package au.com.noojee.orion.api;

/**
 * Returned by Orion when an error code 300 or greater is returned.
 * 
 * @author bsutton
 *
 */
public class OrionErrorResponse
{
	@SuppressWarnings("unused")
	private Meta meta;
	
	private HTTPResponse httpResponse;
	
	public void setHttpResponse(HTTPResponse httpResponse)
	{
		this.httpResponse = httpResponse;
	}
	
	@Override
	public String toString()
	{
		return httpResponse.toString();
	}
}
