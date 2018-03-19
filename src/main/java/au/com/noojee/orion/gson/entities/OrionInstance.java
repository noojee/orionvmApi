
package au.com.noojee.orion.gson.entities;

import java.time.LocalDateTime;
import java.util.List;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class OrionInstance 
{
	@SuppressWarnings("unused")
	static transient private Logger logger = LogManager.getLogger();
	@SerializedName("id")
	@Expose
	private String id;


	@SerializedName("name")
	@Expose
	public String name;
	@SerializedName("memory")
	@Expose
	public Long memory;
	@SerializedName("virtualization")
	@Expose
	public String virtualization;
	@SerializedName("hostname")
	@Expose
	public String hostname;
	@SerializedName("boot_device")
	@Expose
	public String bootDevice;
	@SerializedName("start_on_shutdown")
	@Expose
	public Boolean startOnShutdown;
	@SerializedName("start_on_reboot")
	@Expose
	public Boolean startOnReboot;
	@SerializedName("start_on_crash")
	@Expose
	public Boolean startOnCrash;
	@SerializedName("state")
	@Expose
	public OrionInstanceStates state;
	@SerializedName("performance_tier")
	@Expose
	public PerformanceTier performanceTier;
	@SerializedName("disks")
	@Expose
	public List<Disk> disks = null;
	@SerializedName("public_keys")
	@Expose
	public List<PublicKey> publicKeys = null;
	@SerializedName("network_adapters")
	@Expose
	public List<NetworkAdapter> networkAdapters = null;
	@SerializedName("availability_group")
	@Expose
	public List<String> availabilityGroup = null;
	@SerializedName("region")
	@Expose
	public Region region;
	@SerializedName("created_at")
	@Expose
	public LocalDateTime createdAt;
	@SerializedName("updated_at")
	@Expose
	public String updatedAt;

	

	public String getId()
	{
		return id;
	}

	
//	public OrionInstance withId(String id)
//	{
//		this.id = id;
//		return this;
//	}

	public OrionInstance withName(String name)
	{
		this.name = name;
		return this;
	}

	public OrionInstance withMemory(Long memory)
	{
		this.memory = memory;
		return this;
	}

	public OrionInstance withVirtualization(String virtualization)
	{
		this.virtualization = virtualization;
		return this;
	}

	public OrionInstance withHostname(String hostname)
	{
		this.hostname = hostname;
		return this;
	}

	public OrionInstance withBootDevice(String bootDevice)
	{
		this.bootDevice = bootDevice;
		return this;
	}

	public OrionInstance withStartOnShutdown(Boolean startOnShutdown)
	{
		this.startOnShutdown = startOnShutdown;
		return this;
	}

	public OrionInstance withStartOnReboot(Boolean startOnReboot)
	{
		this.startOnReboot = startOnReboot;
		return this;
	}

	public OrionInstance withStartOnCrash(Boolean startOnCrash)
	{
		this.startOnCrash = startOnCrash;
		return this;
	}

	public OrionInstance withState(OrionInstanceStates state)
	{
		this.state = state;
		return this;
	}

	public OrionInstance withPerformanceTier(PerformanceTier performanceTier)
	{
		this.performanceTier = performanceTier;
		return this;
	}

	public OrionInstance withDisks(List<Disk> disks)
	{
		this.disks = disks;
		return this;
	}

	public OrionInstance withPublicKeys(List<PublicKey> publicKeys)
	{
		this.publicKeys = publicKeys;
		return this;
	}

	public OrionInstance withNetworkAdapters(List<NetworkAdapter> networkAdapters)
	{
		this.networkAdapters = networkAdapters;
		return this;
	}

	public OrionInstance withAvailabilityGroup(List<String> availabilityGroup)
	{
		this.availabilityGroup = availabilityGroup;
		return this;
	}

	public OrionInstance withRegion(Region region)
	{
		this.region = region;
		return this;
	}

	public OrionInstance withCreatedAt(LocalDateTime createdAt)
	{
		this.createdAt = createdAt;
		return this;
	}

	public OrionInstance withUpdatedAt(String updatedAt)
	{
		this.updatedAt = updatedAt;
		return this;
	}


	@Override
	public String toString()
	{
		return new ToStringBuilder(this).append("id", getId()).append("name", name).append("memory", memory)
				.append("virtualization", virtualization).append("hostname", hostname).append("bootDevice", bootDevice)
				.append("startOnShutdown", startOnShutdown).append("startOnReboot", startOnReboot)
				.append("startOnCrash", startOnCrash).append("state", state).append("performanceTier", performanceTier)
				.append("disks", disks).append("publicKeys", publicKeys).append("networkAdapters", networkAdapters)
				.append("availabilityGroup", availabilityGroup).append("region", region).append("createdAt", createdAt)
				.append("updatedAt", updatedAt).toString();
	}

	@Override
	public int hashCode()
	{
		return new HashCodeBuilder().append(region).append(bootDevice).append(networkAdapters).append(state)
				.append(startOnReboot).append(startOnShutdown).append(virtualization).append(hostname)
				.append(publicKeys).append(disks).append(performanceTier).append(memory).append(updatedAt).append(getId())
				.append(availabilityGroup).append(createdAt).append(name).append(startOnCrash).toHashCode();
	}

	@Override
	public boolean equals(Object other)
	{
		if (other == this)
		{
			return true;
		}
		if ((other instanceof OrionInstance) == false)
		{
			return false;
		}
		OrionInstance rhs = ((OrionInstance) other);
		return new EqualsBuilder().append(region, rhs.region).append(bootDevice, rhs.bootDevice)
				.append(networkAdapters, rhs.networkAdapters).append(state, rhs.state)
				.append(startOnReboot, rhs.startOnReboot).append(startOnShutdown, rhs.startOnShutdown)
				.append(virtualization, rhs.virtualization).append(hostname, rhs.hostname)
				.append(publicKeys, rhs.publicKeys).append(disks, rhs.disks)
				.append(performanceTier, rhs.performanceTier).append(memory, rhs.memory)
				.append(updatedAt, rhs.updatedAt).append(getId(), rhs.getId()).append(availabilityGroup, rhs.availabilityGroup)
				.append(createdAt, rhs.createdAt).append(name, rhs.name).append(startOnCrash, rhs.startOnCrash)
				.isEquals();
	}
}
