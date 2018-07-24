
package au.com.noojee.agentbox.gson.entities;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class AgentBoxAttachedRelatedStaffMember {

    @SerializedName("role")
    @Expose
    private String role;
    @SerializedName("id")
    @Expose
    private String id;

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("role", role).append("id", id).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(id).append(role).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof AgentBoxAttachedRelatedStaffMember) == false) {
            return false;
        }
        AgentBoxAttachedRelatedStaffMember rhs = ((AgentBoxAttachedRelatedStaffMember) other);
        return new EqualsBuilder().append(id, rhs.id).append(role, rhs.role).isEquals();
    }

}
