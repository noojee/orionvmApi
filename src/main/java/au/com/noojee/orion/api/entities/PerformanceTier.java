
package au.com.noojee.orion.api.entities;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PerformanceTier
{

	@SerializedName("id")
	@Expose
	public String id;
	@SerializedName("name")
	@Expose
	public String name;
	@SerializedName("region")
	@Expose
	public Region region;

	public PerformanceTier withId(String id)
	{
		this.id = id;
		return this;
	}

	public PerformanceTier withName(String name)
	{
		this.name = name;
		return this;
	}

	public PerformanceTier withRegion(Region region)
	{
		this.region = region;
		return this;
	}

	@Override
	public String toString()
	{
		return new ToStringBuilder(this).append("id", id).append("name", name).append("region", region).toString();
	}

	@Override
	public int hashCode()
	{
		return new HashCodeBuilder().append(region).append(id).append(name).toHashCode();
	}

	@Override
	public boolean equals(Object other)
	{
		if (other == this)
		{
			return true;
		}
		if ((other instanceof PerformanceTier) == false)
		{
			return false;
		}
		PerformanceTier rhs = ((PerformanceTier) other);
		return new EqualsBuilder().append(region, rhs.region).append(id, rhs.id).append(name, rhs.name).isEquals();
	}

}
