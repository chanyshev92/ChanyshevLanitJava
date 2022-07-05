package model;

import java.io.Serializable;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.annotations.SerializedName;


public class Ticket implements Serializable
{
    @SerializedName("id")
    private Integer id;

    @SerializedName("title")
    private String title;

    @SerializedName("priority")
    private Integer priority;

    @SerializedName("status")
    @JsonProperty
    private Integer status;

    @SerializedName("queue")
    private Integer queue;

    @JsonIgnore
    private String due_date;

    @JsonIgnore
    private String assigned_to;
    @JsonIgnore
    private String created;
    @JsonIgnore
    private String modified;
    @JsonIgnore
    private String submitter_email;
    @JsonIgnore
    private Boolean on_hold;
    @JsonIgnore
    private String description;
    @JsonIgnore
    private String resolution;
    @JsonIgnore
    private String last_escalation;
    @JsonIgnore
    private String secret_key;
    @JsonIgnore
    private Integer kbitem;
    @JsonIgnore
    private Integer merged_to;

    private final static long serialVersionUID = 2468277671475621618L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDue_date() {
        return due_date;
    }

    public void setDue_date(String due_date) {
        this.due_date = due_date;
    }

    public String getAssigned_to() {
        return assigned_to;
    }

    public void setAssigned_to(String assigned_to) {
        this.assigned_to = assigned_to;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = created;
    }

    public String getModified() {
        return modified;
    }

    public void setModified(String modified) {
        this.modified = modified;
    }

    public String getSubmitter_email() {
        return submitter_email;
    }

    public void setSubmitter_email(String submitter_email) {
        this.submitter_email = submitter_email;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Boolean getOn_hold() {
        return on_hold;
    }

    public void setOn_hold(Boolean on_hold) {
        this.on_hold = on_hold;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getResolution() {
        return resolution;
    }

    public void setResolution(String resolution) {
        this.resolution = resolution;
    }

    public Integer getPriority() {
        return priority;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    public String getLast_escalation() {
        return last_escalation;
    }

    public void setLast_escalation(String last_escalation) {
        this.last_escalation = last_escalation;
    }

    public String getSecret_key() {
        return secret_key;
    }

    public void setSecret_key(String secret_key) {
        this.secret_key = secret_key;
    }

    public Integer getQueue() {
        return queue;
    }

    public void setQueue(Integer queue) {
        this.queue = queue;
    }

    public Integer getKbitem() {
        return kbitem;
    }

    public void setKbitem(Integer kbitem) {
        this.kbitem = kbitem;
    }

    public Integer getMerged_to() {
        return merged_to;
    }

    public void setMerged_to(Integer merged_to) {
        this.merged_to = merged_to;
    }


    @Override
    public int hashCode() {
        int result = 1;
        result = ((result* 31)+((this.on_hold == null)? 0 :this.on_hold.hashCode()));
        result = ((result* 31)+((this.secret_key == null)? 0 :this.secret_key.hashCode()));
        result = ((result* 31)+((this.created == null)? 0 :this.created.hashCode()));
        result = ((result* 31)+((this.due_date == null)? 0 :this.due_date.hashCode()));
        result = ((result* 31)+((this.kbitem == null)? 0 :this.kbitem.hashCode()));
        result = ((result* 31)+((this.description == null)? 0 :this.description.hashCode()));
        result = ((result* 31)+((this.title == null)? 0 :this.title.hashCode()));
        result = ((result* 31)+((this.priority == null)? 0 :this.priority.hashCode()));
        result = ((result* 31)+((this.resolution == null)? 0 :this.resolution.hashCode()));
        result = ((result* 31)+((this.assigned_to == null)? 0 :this.assigned_to.hashCode()));
        result = ((result* 31)+((this.modified == null)? 0 :this.modified.hashCode()));
        result = ((result* 31)+((this.id == null)? 0 :this.id.hashCode()));
        result = ((result* 31)+((this.last_escalation == null)? 0 :this.last_escalation.hashCode()));
        result = ((result* 31)+((this.queue == null)? 0 :this.queue.hashCode()));
        result = ((result* 31)+((this.submitter_email == null)? 0 :this.submitter_email.hashCode()));
        result = ((result* 31)+((this.status == null)? 0 :this.status.hashCode()));
        result = ((result* 31)+((this.merged_to == null)? 0 :this.merged_to.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if (!(other instanceof Ticket)) {
            return false;
        }
        Ticket rhs = ((Ticket) other);
        return (((((((((((((((((Objects.equals(this.on_hold, rhs.on_hold))&&(Objects.equals(this.secret_key, rhs.secret_key)))&&(Objects.equals(this.created, rhs.created)))&&(Objects.equals(this.due_date, rhs.due_date)))&&(Objects.equals(this.kbitem, rhs.kbitem)))&&(Objects.equals(this.description, rhs.description)))&&(Objects.equals(this.title, rhs.title)))&&(Objects.equals(this.priority, rhs.priority)))&&(Objects.equals(this.resolution, rhs.resolution)))&&(Objects.equals(this.assigned_to, rhs.assigned_to)))&&(Objects.equals(this.modified, rhs.modified)))&&(Objects.equals(this.id, rhs.id)))&&(Objects.equals(this.last_escalation, rhs.last_escalation)))&&(Objects.equals(this.queue, rhs.queue)))&&(Objects.equals(this.submitter_email, rhs.submitter_email)))&&(Objects.equals(this.status, rhs.status)))&&(Objects.equals(this.merged_to, rhs.merged_to)));
    }

}