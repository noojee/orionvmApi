package au.com.noojee.agentbox.api;

public class AgentBoxException extends RuntimeException
{
	private static final long serialVersionUID = 1L;

	AgentBoxException(String message)
	{
		super(message);
	}

	AgentBoxException(Throwable e)
	{
		super(e);
	}

	AgentBoxException(AgentBoxError fromJson)
	{
		super(fromJson.getMessage());
	}

	@Override
	public String toString()
	{
		String response;
		response = super.toString();
		return response;

	}

}
