
package au.com.noojee.agentbox.api;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class AgentBoxError
{

	@SerializedName("error")
	@Expose
	private String error;
	@SerializedName("details")
	@Expose
	private AgentBoxErrorDetails details;
	@SerializedName("error_description")
	@Expose
	private String errorDescription;
	
	@SuppressWarnings("unused")
	transient private AgentBoxHTTPResponse httpResponse;

	public String getError()
	{
		return error;
	}

	public void setError(String error)
	{
		this.error = error;
	}

	public AgentBoxErrorDetails getDetails()
	{
		return details;
	}

	public void setDetails(AgentBoxErrorDetails details)
	{
		this.details = details;
	}

	public String getErrorDescription()
	{
		return errorDescription;
	}

	public void setErrorDescription(String errorDescription)
	{
		this.errorDescription = errorDescription;
	}
	
	public String getMessage()
	{
		String message = this.errorDescription;
		
		if (details != null && !details.getState().isEmpty())
			message += ":" + details.getState().get(0);
		return message;
	}


	@Override
	public String toString()
	{
		return new ToStringBuilder(this).append("error", error).append("details", details)
				.append("errorDescription", errorDescription).toString();
	}

	@Override
	public int hashCode()
	{
		return new HashCodeBuilder().append(details).append(error).append(errorDescription).toHashCode();
	}

	@Override
	public boolean equals(Object other)
	{
		if (other == this)
		{
			return true;
		}
		if ((other instanceof AgentBoxError) == false)
		{
			return false;
		}
		AgentBoxError rhs = ((AgentBoxError) other);
		return new EqualsBuilder().append(details, rhs.details).append(error, rhs.error)
				.append(errorDescription, rhs.errorDescription).isEquals();
	}

	public void setHttpResponse(AgentBoxHTTPResponse httpResponse)
	{
		this.httpResponse = httpResponse;
	}


}
