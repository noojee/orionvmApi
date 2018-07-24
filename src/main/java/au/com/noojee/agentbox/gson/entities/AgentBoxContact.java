
package au.com.noojee.agentbox.gson.entities;

import java.util.List;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class AgentBoxContact {

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("clientRef")
    @Expose
    private String clientRef;
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
    @SerializedName("website")
    @Expose
    private String website;
    @SerializedName("salutation")
    @Expose
    private String salutation;
    @SerializedName("customSalutation")
    @Expose
    private String customSalutation;
    @SerializedName("addressTo")
    @Expose
    private String addressTo;
    @SerializedName("legalName")
    @Expose
    private String legalName;
    @SerializedName("companyName")
    @Expose
    private String companyName;
    @SerializedName("jobTitle")
    @Expose
    private String jobTitle;
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
    @SerializedName("fax")
    @Expose
    private String fax;
    @SerializedName("streetAddress")
    @Expose
    private AgentBoxStreetAddress streetAddress;
    @SerializedName("postalAddress")
    @Expose
    private AgentBoxPostalAddress postalAddress;
    @SerializedName("letterAddressBlock")
    @Expose
    private String letterAddressBlock;
    @SerializedName("prefContactMethod")
    @Expose
    private String prefContactMethod;
    @SerializedName("source")
    @Expose
    private String source;
    @SerializedName("comments")
    @Expose
    private String comments;
    @SerializedName("firstCreated")
    @Expose
    private String firstCreated;
    @SerializedName("lastModified")
    @Expose
    private String lastModified;
    @SerializedName("attachedRelatedStaffMembers")
    @Expose
    private List<AgentBoxAttachedRelatedStaffMember> attachedRelatedStaffMembers = null;
    @SerializedName("contactClasses")
    @Expose
    private List<AgentBoxContactClass> contactClasses = null;
    @SerializedName("subscriptions")
    @Expose
    private List<AgentBoxSubscription> subscriptions = null;
    @SerializedName("keyDates")
    @Expose
    private List<Object> keyDates = null;
    @SerializedName("communicationRestrictions")
    @Expose
    private AgentBoxCommunicationRestrictions communicationRestrictions;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getClientRef() {
        return clientRef;
    }

    public void setClientRef(String clientRef) {
        this.clientRef = clientRef;
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

    public String getAddressTo() {
        return addressTo;
    }

    public void setAddressTo(String addressTo) {
        this.addressTo = addressTo;
    }

    public String getLegalName() {
        return legalName;
    }

    public void setLegalName(String legalName) {
        this.legalName = legalName;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
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

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public AgentBoxStreetAddress getStreetAddress() {
        return streetAddress;
    }

    public void setStreetAddress(AgentBoxStreetAddress streetAddress) {
        this.streetAddress = streetAddress;
    }

    public AgentBoxPostalAddress getPostalAddress() {
        return postalAddress;
    }

    public void setPostalAddress(AgentBoxPostalAddress postalAddress) {
        this.postalAddress = postalAddress;
    }

    public String getLetterAddressBlock() {
        return letterAddressBlock;
    }

    public void setLetterAddressBlock(String letterAddressBlock) {
        this.letterAddressBlock = letterAddressBlock;
    }

    public String getPrefContactMethod() {
        return prefContactMethod;
    }

    public void setPrefContactMethod(String prefContactMethod) {
        this.prefContactMethod = prefContactMethod;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
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

    public List<AgentBoxAttachedRelatedStaffMember> getAttachedRelatedStaffMembers() {
        return attachedRelatedStaffMembers;
    }

    public void setAttachedRelatedStaffMembers(List<AgentBoxAttachedRelatedStaffMember> attachedRelatedStaffMembers) {
        this.attachedRelatedStaffMembers = attachedRelatedStaffMembers;
    }

    public List<AgentBoxContactClass> getContactClasses() {
        return contactClasses;
    }

    public void setContactClasses(List<AgentBoxContactClass> contactClasses) {
        this.contactClasses = contactClasses;
    }

    public List<AgentBoxSubscription> getSubscriptions() {
        return subscriptions;
    }

    public void setSubscriptions(List<AgentBoxSubscription> subscriptions) {
        this.subscriptions = subscriptions;
    }

    public List<Object> getKeyDates() {
        return keyDates;
    }

    public void setKeyDates(List<Object> keyDates) {
        this.keyDates = keyDates;
    }

    public AgentBoxCommunicationRestrictions getCommunicationRestrictions() {
        return communicationRestrictions;
    }

    public void setCommunicationRestrictions(AgentBoxCommunicationRestrictions communicationRestrictions) {
        this.communicationRestrictions = communicationRestrictions;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("id", id).append("clientRef", clientRef).append("type", type).append("status", status).append("title", title).append("firstName", firstName).append("lastName", lastName).append("website", website).append("salutation", salutation).append("customSalutation", customSalutation).append("addressTo", addressTo).append("legalName", legalName).append("companyName", companyName).append("jobTitle", jobTitle).append("email", email).append("mobile", mobile).append("homePhone", homePhone).append("workPhone", workPhone).append("fax", fax).append("streetAddress", streetAddress).append("postalAddress", postalAddress).append("letterAddressBlock", letterAddressBlock).append("prefContactMethod", prefContactMethod).append("source", source).append("comments", comments).append("firstCreated", firstCreated).append("lastModified", lastModified).append("attachedRelatedStaffMembers", attachedRelatedStaffMembers).append("contactClasses", contactClasses).append("subscriptions", subscriptions).append("keyDates", keyDates).append("communicationRestrictions", communicationRestrictions).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(streetAddress).append(contactClasses).append(type).append(homePhone).append(letterAddressBlock).append(clientRef).append(id).append(title).append(attachedRelatedStaffMembers).append(firstCreated).append(workPhone).append(firstName).append(prefContactMethod).append(jobTitle).append(legalName).append(lastName).append(fax).append(communicationRestrictions).append(lastModified).append(subscriptions).append(website).append(status).append(customSalutation).append(companyName).append(source).append(email).append(keyDates).append(addressTo).append(postalAddress).append(salutation).append(comments).append(mobile).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof AgentBoxContact) == false) {
            return false;
        }
        AgentBoxContact rhs = ((AgentBoxContact) other);
        return new EqualsBuilder().append(streetAddress, rhs.streetAddress).append(contactClasses, rhs.contactClasses).append(type, rhs.type).append(homePhone, rhs.homePhone).append(letterAddressBlock, rhs.letterAddressBlock).append(clientRef, rhs.clientRef).append(id, rhs.id).append(title, rhs.title).append(attachedRelatedStaffMembers, rhs.attachedRelatedStaffMembers).append(firstCreated, rhs.firstCreated).append(workPhone, rhs.workPhone).append(firstName, rhs.firstName).append(prefContactMethod, rhs.prefContactMethod).append(jobTitle, rhs.jobTitle).append(legalName, rhs.legalName).append(lastName, rhs.lastName).append(fax, rhs.fax).append(communicationRestrictions, rhs.communicationRestrictions).append(lastModified, rhs.lastModified).append(subscriptions, rhs.subscriptions).append(website, rhs.website).append(status, rhs.status).append(customSalutation, rhs.customSalutation).append(companyName, rhs.companyName).append(source, rhs.source).append(email, rhs.email).append(keyDates, rhs.keyDates).append(addressTo, rhs.addressTo).append(postalAddress, rhs.postalAddress).append(salutation, rhs.salutation).append(comments, rhs.comments).append(mobile, rhs.mobile).isEquals();
    }

}
