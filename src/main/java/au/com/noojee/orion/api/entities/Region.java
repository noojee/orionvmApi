
package au.com.noojee.orion.api.entities;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Region
{

	@SerializedName("id")
	@Expose
	public String id;
	@SerializedName("name")
	@Expose
	public String name;
	@SerializedName("code")
	@Expose
	public String code;

	public Region withId(String id)
	{
		this.id = id;
		return this;
	}

	public Region withName(String name)
	{
		this.name = name;
		return this;
	}

	public Region withCode(String code)
	{
		this.code = code;
		return this;
	}

	@Override
	public String toString()
	{
		return new ToStringBuilder(this).append("id", id).append("name", name).append("code", code).toString();
	}

	@Override
	public int hashCode()
	{
		return new HashCodeBuilder().append(id).append(name).append(code).toHashCode();
	}

	@Override
	public boolean equals(Object other)
	{
		if (other == this)
		{
			return true;
		}
		if ((other instanceof Region) == false)
		{
			return false;
		}
		Region rhs = ((Region) other);
		return new EqualsBuilder().append(id, rhs.id).append(name, rhs.name).append(code, rhs.code).isEquals();
	}

}
