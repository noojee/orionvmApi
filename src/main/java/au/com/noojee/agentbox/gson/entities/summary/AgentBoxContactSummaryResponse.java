
package au.com.noojee.agentbox.gson.entities.summary;

import java.util.List;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class AgentBoxContactSummaryResponse
{

	@SerializedName("response")
	@Expose
	private AgentBoxContactSummaryWrapper response;

	public AgentBoxContactSummaryWrapper getResponse()
	{
		return response;
	}

	public void setResponse(AgentBoxContactSummaryWrapper response)
	{
		this.response = response;
	}

	@Override
	public String toString()
	{
		return new ToStringBuilder(this).append("response", response).toString();
	}

	@Override
	public int hashCode()
	{
		return new HashCodeBuilder().append(response).toHashCode();
	}

	@Override
	public boolean equals(Object other)
	{
		if (other == this)
		{
			return true;
		}
		if ((other instanceof AgentBoxContactSummaryResponse) == false)
		{
			return false;
		}
		AgentBoxContactSummaryResponse rhs = ((AgentBoxContactSummaryResponse) other);
		return new EqualsBuilder().append(response, rhs.response).isEquals();
	}

	public List<AgentBoxContactSummary> getList()
	{
		return response.getList();
	}

}
