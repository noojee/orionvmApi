
package au.com.noojee.agentbox.gson.entities.summary;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import au.com.noojee.agentbox.gson.entities.AgentBoxStreetAddress;

public class AgentBoxContactSummary {

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("firstName")
    @Expose
    private String firstName;
    @SerializedName("lastName")
    @Expose
    private String lastName;
    @SerializedName("jobTitle")
    @Expose
    private String jobTitle;
    @SerializedName("website")
    @Expose
    private String website;
    @SerializedName("salutation")
    @Expose
    private String salutation;
    @SerializedName("customSalutation")
    @Expose
    private String customSalutation;
    @SerializedName("companyName")
    @Expose
    private String companyName;
    @SerializedName("email")
    @Expose
    private String email;
    @SerializedName("mobile")
    @Expose
    private String mobile;
    @SerializedName("homePhone")
    @Expose
    private String homePhone;
    @SerializedName("workPhone")
    @Expose
    private String workPhone;
    @SerializedName("streetAddress")
    @Expose
    private AgentBoxStreetAddress streetAddress;
    
    @SerializedName("firstCreated")
    @Expose
    private String firstCreated;
    @SerializedName("lastModified")
    @Expose
    private String lastModified;
    @SerializedName("links")
    @Expose
    private AgentBoxLinks links;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getSalutation() {
        return salutation;
    }

    public void setSalutation(String salutation) {
        this.salutation = salutation;
    }

    public String getCustomSalutation() {
        return customSalutation;
    }

    public void setCustomSalutation(String customSalutation) {
        this.customSalutation = customSalutation;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getHomePhone() {
        return homePhone;
    }

    public void setHomePhone(String homePhone) {
        this.homePhone = homePhone;
    }

    public String getWorkPhone() {
        return workPhone;
    }

    public void setWorkPhone(String workPhone) {
        this.workPhone = workPhone;
    }

    public String getFirstCreated() {
        return firstCreated;
    }

    public void setFirstCreated(String firstCreated) {
        this.firstCreated = firstCreated;
    }

    public String getLastModified() {
        return lastModified;
    }

    public void setLastModified(String lastModified) {
        this.lastModified = lastModified;
    }

    public AgentBoxLinks getLinks() {
        return links;
    }

    public void setLinks(AgentBoxLinks links) {
        this.links = links;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("id", id).append("type", type).append("status", status).append("title", title).append("firstName", firstName).append("lastName", lastName).append("jobTitle", jobTitle).append("website", website).append("salutation", salutation).append("customSalutation", customSalutation).append("companyName", companyName).append("email", email).append("mobile", mobile).append("homePhone", homePhone).append("workPhone", workPhone).append("firstCreated", firstCreated).append("lastModified", lastModified).append("links", links).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(lastName).append(lastModified).append(website).append(status).append(customSalutation).append(links).append(companyName).append(type).append(homePhone).append(id).append(title).append(email).append(firstCreated).append(workPhone).append(salutation).append(firstName).append(mobile).append(jobTitle).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof AgentBoxContactSummary) == false) {
            return false;
        }
        AgentBoxContactSummary rhs = ((AgentBoxContactSummary) other);
        return new EqualsBuilder().append(lastName, rhs.lastName).append(lastModified, rhs.lastModified).append(website, rhs.website).append(status, rhs.status).append(customSalutation, rhs.customSalutation).append(links, rhs.links).append(companyName, rhs.companyName).append(type, rhs.type).append(homePhone, rhs.homePhone).append(id, rhs.id).append(title, rhs.title).append(email, rhs.email).append(firstCreated, rhs.firstCreated).append(workPhone, rhs.workPhone).append(salutation, rhs.salutation).append(firstName, rhs.firstName).append(mobile, rhs.mobile).append(jobTitle, rhs.jobTitle).isEquals();
    }

}
