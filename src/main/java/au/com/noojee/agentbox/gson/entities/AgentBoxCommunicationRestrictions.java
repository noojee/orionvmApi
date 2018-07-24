
package au.com.noojee.agentbox.gson.entities;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class AgentBoxCommunicationRestrictions {

    @SerializedName("doNotCall")
    @Expose
    private Boolean doNotCall;
    @SerializedName("doNotSMS")
    @Expose
    private Boolean doNotSMS;
    @SerializedName("doNotEmail")
    @Expose
    private Boolean doNotEmail;
    @SerializedName("doNotMail")
    @Expose
    private Boolean doNotMail;

    public Boolean getDoNotCall() {
        return doNotCall;
    }

    public void setDoNotCall(Boolean doNotCall) {
        this.doNotCall = doNotCall;
    }

    public Boolean getDoNotSMS() {
        return doNotSMS;
    }

    public void setDoNotSMS(Boolean doNotSMS) {
        this.doNotSMS = doNotSMS;
    }

    public Boolean getDoNotEmail() {
        return doNotEmail;
    }

    public void setDoNotEmail(Boolean doNotEmail) {
        this.doNotEmail = doNotEmail;
    }

    public Boolean getDoNotMail() {
        return doNotMail;
    }

    public void setDoNotMail(Boolean doNotMail) {
        this.doNotMail = doNotMail;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("doNotCall", doNotCall).append("doNotSMS", doNotSMS).append("doNotEmail", doNotEmail).append("doNotMail", doNotMail).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(doNotEmail).append(doNotMail).append(doNotCall).append(doNotSMS).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof AgentBoxCommunicationRestrictions) == false) {
            return false;
        }
        AgentBoxCommunicationRestrictions rhs = ((AgentBoxCommunicationRestrictions) other);
        return new EqualsBuilder().append(doNotEmail, rhs.doNotEmail).append(doNotMail, rhs.doNotMail).append(doNotCall, rhs.doNotCall).append(doNotSMS, rhs.doNotSMS).isEquals();
    }

}
