
package au.com.noojee.orion.api;

import java.util.List;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ErrorDetails {

    @SerializedName("state")
    @Expose
    private List<String> state = null;

    public List<String> getState() {
        return state;
    }

    public void setState(List<String> state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("state", state).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(state).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof ErrorDetails) == false) {
            return false;
        }
        ErrorDetails rhs = ((ErrorDetails) other);
        return new EqualsBuilder().append(state, rhs.state).isEquals();
    }

}
