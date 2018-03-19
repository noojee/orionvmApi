
package au.com.noojee.orion.gson.entities;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PublicKey 
{
	@SerializedName("id")
	@Expose
	public String id;

	@SerializedName("name")
	@Expose
	public String name;
	@SerializedName("key")
	@Expose
	public String key;
	@SerializedName("created_at")
	@Expose
	public String createdAt;
	@SerializedName("updated_at")
	@Expose
	public String updatedAt;

	public PublicKey withId(String id)
	{
		this.id = id;
		return this;
	}

	public PublicKey withName(String name)
	{
		this.name = name;
		return this;
	}

	public PublicKey withKey(String key)
	{
		this.key = key;
		return this;
	}

	public PublicKey withCreatedAt(String createdAt)
	{
		this.createdAt = createdAt;
		return this;
	}

	public PublicKey withUpdatedAt(String updatedAt)
	{
		this.updatedAt = updatedAt;
		return this;
	}

	@Override
	public String toString()
	{
		return new ToStringBuilder(this).append("id", id).append("name", name).append("key", key)
				.append("createdAt", createdAt).append("updatedAt", updatedAt).toString();
	}

	@Override
	public int hashCode()
	{
		return new HashCodeBuilder().append(updatedAt).append(id).append(createdAt).append(name).append(key)
				.toHashCode();
	}

	@Override
	public boolean equals(Object other)
	{
		if (other == this)
		{
			return true;
		}
		if ((other instanceof PublicKey) == false)
		{
			return false;
		}
		PublicKey rhs = ((PublicKey) other);
		return new EqualsBuilder().append(updatedAt, rhs.updatedAt).append(id, rhs.id).append(createdAt, rhs.createdAt)
				.append(name, rhs.name).append(key, rhs.key).isEquals();
	}

}
