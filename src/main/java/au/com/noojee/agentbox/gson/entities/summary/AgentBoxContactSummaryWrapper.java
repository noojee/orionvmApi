
package au.com.noojee.agentbox.gson.entities.summary;

import java.util.List;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class AgentBoxContactSummaryWrapper
{

	@SerializedName("items")
	@Expose
	private String items;
	@SerializedName("current")
	@Expose
	private String current;
	@SerializedName("last")
	@Expose
	private String last;
	@SerializedName("contacts")
	@Expose
	private List<AgentBoxContactSummary> contacts = null;

	public String getItems()
	{
		return items;
	}

	public void setItems(String items)
	{
		this.items = items;
	}

	public String getCurrent()
	{
		return current;
	}

	public void setCurrent(String current)
	{
		this.current = current;
	}

	public String getLast()
	{
		return last;
	}

	public void setLast(String last)
	{
		this.last = last;
	}

	public List<AgentBoxContactSummary> getContacts()
	{
		return contacts;
	}

	public void setContacts(List<AgentBoxContactSummary> contacts)
	{
		this.contacts = contacts;
	}

	List<AgentBoxContactSummary> getList()
	{
		return contacts;
	}

	@Override
	public String toString()
	{
		return new ToStringBuilder(this).append("items", items).append("current", current).append("last", last)
				.append("contacts", contacts).toString();
	}

	@Override
	public int hashCode()
	{
		return new HashCodeBuilder().append(last).append(items).append(current).append(contacts).toHashCode();
	}

	@Override
	public boolean equals(Object other)
	{
		if (other == this)
		{
			return true;
		}
		if ((other instanceof AgentBoxContactSummaryWrapper) == false)
		{
			return false;
		}
		AgentBoxContactSummaryWrapper rhs = ((AgentBoxContactSummaryWrapper) other);
		return new EqualsBuilder().append(last, rhs.last).append(items, rhs.items).append(current, rhs.current)
				.append(contacts, rhs.contacts).isEquals();
	}

}
