
package au.com.noojee.agentbox.api;

import java.util.List;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class AgentBoxErrorDetails
{

	@SerializedName("state")
	@Expose
	private List<String> state = null;

	public List<String> getState()
	{
		return state;
	}

	public void setState(List<String> state)
	{
		this.state = state;
	}

	@Override
	public String toString()
	{
		return new ToStringBuilder(this).append("state", state).toString();
	}

	@Override
	public int hashCode()
	{
		return new HashCodeBuilder().append(state).toHashCode();
	}

	@Override
	public boolean equals(Object other)
	{
		if (other == this)
		{
			return true;
		}
		if ((other instanceof AgentBoxErrorDetails) == false)
		{
			return false;
		}
		AgentBoxErrorDetails rhs = ((AgentBoxErrorDetails) other);
		return new EqualsBuilder().append(state, rhs.state).isEquals();
	}

}
