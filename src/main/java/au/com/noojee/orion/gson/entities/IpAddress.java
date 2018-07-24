
package au.com.noojee.orion.gson.entities;

import java.util.List;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class IpAddress 
{

	@SerializedName("id")
	@Expose
	private String id;

	@SerializedName("name")
	@Expose
	public String name;
	@SerializedName("address")
	@Expose
	public String address;
	@SerializedName("network_id")
	@Expose
	public String networkId;
	@SerializedName("instance_ids")
	@Expose
	public List<String> instanceIds = null;
	@SerializedName("shareable")
	@Expose
	public Boolean shareable;
	@SerializedName("created_at")
	@Expose
	public String createdAt;
	@SerializedName("updated_at")
	@Expose
	public String updatedAt;

//	public IpAddress withId(String id)
//	{
//		this.id = id;
//		return this;
//	}

	public IpAddress withName(String name)
	{
		this.name = name;
		return this;
	}

	public IpAddress withAddress(String address)
	{
		this.address = address;
		return this;
	}

	public IpAddress withNetworkId(String networkId)
	{
		this.networkId = networkId;
		return this;
	}

	public IpAddress withInstanceIds(List<String> instanceIds)
	{
		this.instanceIds = instanceIds;
		return this;
	}

	public IpAddress withShareable(Boolean shareable)
	{
		this.shareable = shareable;
		return this;
	}

	public IpAddress withCreatedAt(String createdAt)
	{
		this.createdAt = createdAt;
		return this;
	}

	public IpAddress withUpdatedAt(String updatedAt)
	{
		this.updatedAt = updatedAt;
		return this;
	}

	@Override
	public String toString()
	{
		return new ToStringBuilder(this).append("id", id).append("name", name).append("address", address)
				.append("networkId", networkId).append("instanceIds", instanceIds).append("shareable", shareable)
				.append("createdAt", createdAt).append("updatedAt", updatedAt).toString();
	}

	@Override
	public int hashCode()
	{
		return new HashCodeBuilder().append(updatedAt).append(instanceIds).append(id).append(shareable).append(address)
				.append(createdAt).append(networkId).append(name).toHashCode();
	}

	@Override
	public boolean equals(Object other)
	{
		if (other == this)
		{
			return true;
		}
		if ((other instanceof IpAddress) == false)
		{
			return false;
		}
		IpAddress rhs = ((IpAddress) other);
		return new EqualsBuilder().append(updatedAt, rhs.updatedAt).append(instanceIds, rhs.instanceIds)
				.append(id, rhs.id).append(shareable, rhs.shareable).append(address, rhs.address)
				.append(createdAt, rhs.createdAt).append(networkId, rhs.networkId).append(name, rhs.name).isEquals();
	}

}
