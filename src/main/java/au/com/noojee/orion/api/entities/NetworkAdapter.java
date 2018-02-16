
package au.com.noojee.orion.api.entities;

import java.util.List;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class NetworkAdapter
{

	@SerializedName("id")
	@Expose
	public String id;
	@SerializedName("index")
	@Expose
	public Long index;
	@SerializedName("dhcp")
	@Expose
	public Boolean dhcp;
	@SerializedName("network")
	@Expose
	public Network network;
	@SerializedName("ip_addresses")
	@Expose
	public List<IpAddress> ipAddresses = null;
	@SerializedName("created_at")
	@Expose
	public String createdAt;
	@SerializedName("updated_at")
	@Expose
	public String updatedAt;

	public NetworkAdapter withId(String id)
	{
		this.id = id;
		return this;
	}

	public NetworkAdapter withIndex(Long index)
	{
		this.index = index;
		return this;
	}

	public NetworkAdapter withDhcp(Boolean dhcp)
	{
		this.dhcp = dhcp;
		return this;
	}

	public NetworkAdapter withNetwork(Network network)
	{
		this.network = network;
		return this;
	}

	public NetworkAdapter withIpAddresses(List<IpAddress> ipAddresses)
	{
		this.ipAddresses = ipAddresses;
		return this;
	}

	public NetworkAdapter withCreatedAt(String createdAt)
	{
		this.createdAt = createdAt;
		return this;
	}

	public NetworkAdapter withUpdatedAt(String updatedAt)
	{
		this.updatedAt = updatedAt;
		return this;
	}

	@Override
	public String toString()
	{
		return new ToStringBuilder(this).append("id", id).append("index", index).append("dhcp", dhcp)
				.append("network", network).append("ipAddresses", ipAddresses).append("createdAt", createdAt)
				.append("updatedAt", updatedAt).toString();
	}

	@Override
	public int hashCode()
	{
		return new HashCodeBuilder().append(updatedAt).append(id).append(index).append(createdAt).append(dhcp)
				.append(ipAddresses).append(network).toHashCode();
	}

	@Override
	public boolean equals(Object other)
	{
		if (other == this)
		{
			return true;
		}
		if ((other instanceof NetworkAdapter) == false)
		{
			return false;
		}
		NetworkAdapter rhs = ((NetworkAdapter) other);
		return new EqualsBuilder().append(updatedAt, rhs.updatedAt).append(id, rhs.id).append(index, rhs.index)
				.append(createdAt, rhs.createdAt).append(dhcp, rhs.dhcp).append(ipAddresses, rhs.ipAddresses)
				.append(network, rhs.network).isEquals();
	}

}
