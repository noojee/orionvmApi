
package au.com.noojee.orion.gson.entities;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Disk 
{
	@SerializedName("id")
	@Expose
	private String id;

	@SerializedName("name")
	@Expose
	public String name;
	@SerializedName("position")
	@Expose
	public Long position;
	@SerializedName("size")
	@Expose
	public Long size;
	@SerializedName("performance_tier")
	@Expose
	public PerformanceTier performanceTier;
	@SerializedName("template")
	@Expose
	public Object template;
	@SerializedName("state")
	@Expose
	public String state;
	@SerializedName("region")
	@Expose
	public Region region;
	@SerializedName("instance_id")
	@Expose
	public String instanceId;
	@SerializedName("cdrom")
	@Expose
	public Boolean cdrom;
	@SerializedName("is_template")
	@Expose
	public Boolean isTemplate;
	@SerializedName("created_at")
	@Expose
	public String createdAt;
	@SerializedName("updated_at")
	@Expose
	public String updatedAt;

//	public Disk withId(String id)
//	{
//		this.id = id;
//		return this;
//	}

	public Disk withName(String name)
	{
		this.name = name;
		return this;
	}

	public Disk withPosition(Long position)
	{
		this.position = position;
		return this;
	}

	public Disk withSize(Long size)
	{
		this.size = size;
		return this;
	}

	public Disk withPerformanceTier(PerformanceTier performanceTier)
	{
		this.performanceTier = performanceTier;
		return this;
	}

	public Disk withTemplate(Object template)
	{
		this.template = template;
		return this;
	}

	public Disk withState(String state)
	{
		this.state = state;
		return this;
	}

	public Disk withRegion(Region region)
	{
		this.region = region;
		return this;
	}

	public Disk withInstanceId(String instanceId)
	{
		this.instanceId = instanceId;
		return this;
	}

	public Disk withCdrom(Boolean cdrom)
	{
		this.cdrom = cdrom;
		return this;
	}

	public Disk withIsTemplate(Boolean isTemplate)
	{
		this.isTemplate = isTemplate;
		return this;
	}

	public Disk withCreatedAt(String createdAt)
	{
		this.createdAt = createdAt;
		return this;
	}

	public Disk withUpdatedAt(String updatedAt)
	{
		this.updatedAt = updatedAt;
		return this;
	}

	@Override
	public String toString()
	{
		return new ToStringBuilder(this).append("id", id).append("name", name).append("position", position)
				.append("size", size).append("performanceTier", performanceTier).append("template", template)
				.append("state", state).append("region", region).append("instanceId", instanceId).append("cdrom", cdrom)
				.append("isTemplate", isTemplate).append("createdAt", createdAt).append("updatedAt", updatedAt)
				.toString();
	}

	@Override
	public int hashCode()
	{
		return new HashCodeBuilder().append(region).append(template).append(position).append(instanceId).append(state)
				.append(performanceTier).append(size).append(updatedAt).append(id).append(cdrom).append(createdAt)
				.append(name).append(isTemplate).toHashCode();
	}

	@Override
	public boolean equals(Object other)
	{
		if (other == this)
		{
			return true;
		}
		if ((other instanceof Disk) == false)
		{
			return false;
		}
		Disk rhs = ((Disk) other);
		return new EqualsBuilder().append(region, rhs.region).append(template, rhs.template)
				.append(position, rhs.position).append(instanceId, rhs.instanceId).append(state, rhs.state)
				.append(performanceTier, rhs.performanceTier).append(size, rhs.size).append(updatedAt, rhs.updatedAt)
				.append(id, rhs.id).append(cdrom, rhs.cdrom).append(createdAt, rhs.createdAt).append(name, rhs.name)
				.append(isTemplate, rhs.isTemplate).isEquals();
	}

}
