
package au.com.noojee.orion.api.entities;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Network
{

	@SerializedName("id")
	@Expose
	public String id;
	@SerializedName("name")
	@Expose
	public String name;
	@SerializedName("is_public")
	@Expose
	public Boolean isPublic;
	@SerializedName("specification")
	@Expose
	public String specification;
	@SerializedName("netmask")
	@Expose
	public String netmask;
	@SerializedName("gateway")
	@Expose
	public String gateway;
	@SerializedName("primary_nameserver")
	@Expose
	public String primaryNameserver;
	@SerializedName("secondary_nameserver")
	@Expose
	public String secondaryNameserver;
	@SerializedName("state")
	@Expose
	public String state;
	@SerializedName("network_address")
	@Expose
	public String networkAddress;
	@SerializedName("region")
	@Expose
	public Region region;
	@SerializedName("created_at")
	@Expose
	public String createdAt;
	@SerializedName("updated_at")
	@Expose
	public String updatedAt;

	public Network withId(String id)
	{
		this.id = id;
		return this;
	}

	public Network withName(String name)
	{
		this.name = name;
		return this;
	}

	public Network withIsPublic(Boolean isPublic)
	{
		this.isPublic = isPublic;
		return this;
	}

	public Network withSpecification(String specification)
	{
		this.specification = specification;
		return this;
	}

	public Network withNetmask(String netmask)
	{
		this.netmask = netmask;
		return this;
	}

	public Network withGateway(String gateway)
	{
		this.gateway = gateway;
		return this;
	}

	public Network withPrimaryNameserver(String primaryNameserver)
	{
		this.primaryNameserver = primaryNameserver;
		return this;
	}

	public Network withSecondaryNameserver(String secondaryNameserver)
	{
		this.secondaryNameserver = secondaryNameserver;
		return this;
	}

	public Network withState(String state)
	{
		this.state = state;
		return this;
	}

	public Network withNetworkAddress(String networkAddress)
	{
		this.networkAddress = networkAddress;
		return this;
	}

	public Network withRegion(Region region)
	{
		this.region = region;
		return this;
	}

	public Network withCreatedAt(String createdAt)
	{
		this.createdAt = createdAt;
		return this;
	}

	public Network withUpdatedAt(String updatedAt)
	{
		this.updatedAt = updatedAt;
		return this;
	}

	@Override
	public String toString()
	{
		return new ToStringBuilder(this).append("id", id).append("name", name).append("isPublic", isPublic)
				.append("specification", specification).append("netmask", netmask).append("gateway", gateway)
				.append("primaryNameserver", primaryNameserver).append("secondaryNameserver", secondaryNameserver)
				.append("state", state).append("networkAddress", networkAddress).append("region", region)
				.append("createdAt", createdAt).append("updatedAt", updatedAt).toString();
	}

	@Override
	public int hashCode()
	{
		return new HashCodeBuilder().append(region).append(gateway).append(networkAddress).append(state)
				.append(isPublic).append(primaryNameserver).append(netmask).append(updatedAt).append(id)
				.append(createdAt).append(name).append(specification).append(secondaryNameserver).toHashCode();
	}

	@Override
	public boolean equals(Object other)
	{
		if (other == this)
		{
			return true;
		}
		if ((other instanceof Network) == false)
		{
			return false;
		}
		Network rhs = ((Network) other);
		return new EqualsBuilder().append(region, rhs.region).append(gateway, rhs.gateway)
				.append(networkAddress, rhs.networkAddress).append(state, rhs.state).append(isPublic, rhs.isPublic)
				.append(primaryNameserver, rhs.primaryNameserver).append(netmask, rhs.netmask)
				.append(updatedAt, rhs.updatedAt).append(id, rhs.id).append(createdAt, rhs.createdAt)
				.append(name, rhs.name).append(specification, rhs.specification)
				.append(secondaryNameserver, rhs.secondaryNameserver).isEquals();
	}

}
