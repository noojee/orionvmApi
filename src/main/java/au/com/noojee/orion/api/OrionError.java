
package au.com.noojee.orion.api;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class OrionError
{

	@SerializedName("error")
	@Expose
	private String error;
	@SerializedName("details")
	@Expose
	private ErrorDetails details;
	@SerializedName("error_description")
	@Expose
	private String errorDescription;
	
	@SuppressWarnings("unused")
	transient private HTTPResponse httpResponse;

	public String getError()
	{
		return error;
	}

	public void setError(String error)
	{
		this.error = error;
	}

	public ErrorDetails getDetails()
	{
		return details;
	}

	public void setDetails(ErrorDetails details)
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
		if (!details.getState().isEmpty())
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
		if ((other instanceof OrionError) == false)
		{
			return false;
		}
		OrionError rhs = ((OrionError) other);
		return new EqualsBuilder().append(details, rhs.details).append(error, rhs.error)
				.append(errorDescription, rhs.errorDescription).isEquals();
	}

	public void setHttpResponse(HTTPResponse httpResponse)
	{
		this.httpResponse = httpResponse;
	}


}
