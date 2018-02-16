package au.com.noojee.orion.api;

public class OrionException extends RuntimeException
{
	private static final long serialVersionUID = 1L;
	
	OrionErrorResponse error = null;

	public OrionException(String message)
	{
		super(message);
	}

	public OrionException(Throwable e)
	{
		super(e);
	}
	
	public OrionException(OrionError fromJson)
	{
		super(fromJson.getMessage());
	}

	@Override
	public String toString()
	{
		String response;
		if (error == null)
			response = super.toString();
		else
			response = error.toString();
		return response;
			
	}

}
