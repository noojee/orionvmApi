
package au.com.noojee.agentbox.gson.entities;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class AgentBoxContactWrapper {

    @SerializedName("contact")
    @Expose
    private AgentBoxContact contact;

    public AgentBoxContact getContact() {
        return contact;
    }

    public void setContact(AgentBoxContact contact) {
        this.contact = contact;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("contact", contact).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(contact).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof AgentBoxContactWrapper) == false) {
            return false;
        }
        AgentBoxContactWrapper rhs = ((AgentBoxContactWrapper) other);
        return new EqualsBuilder().append(contact, rhs.contact).isEquals();
    }

}
