
package au.com.noojee.agentbox.gson.entities;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class AgentBoxPostalAddress {

    @SerializedName("address")
    @Expose
    private String address;
    @SerializedName("suburb")
    @Expose
    private String suburb;
    @SerializedName("state")
    @Expose
    private String state;
    @SerializedName("country")
    @Expose
    private String country;
    @SerializedName("postcode")
    @Expose
    private String postcode;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getSuburb() {
        return suburb;
    }

    public void setSuburb(String suburb) {
        this.suburb = suburb;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("address", address).append("suburb", suburb).append("state", state).append("country", country).append("postcode", postcode).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(suburb).append(address).append(state).append(postcode).append(country).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof AgentBoxPostalAddress) == false) {
            return false;
        }
        AgentBoxPostalAddress rhs = ((AgentBoxPostalAddress) other);
        return new EqualsBuilder().append(suburb, rhs.suburb).append(address, rhs.address).append(state, rhs.state).append(postcode, rhs.postcode).append(country, rhs.country).isEquals();
    }

}
