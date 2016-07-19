/**
 * This code was generated by
 * \ / _    _  _|   _  _
 *  | (_)\/(_)(_|\/| |(/_  v1.0.0
 *       /       /       
 */

package com.twilio.sdk.resource.taskrouter.v1.workspace;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.base.MoreObjects;
import com.twilio.sdk.converter.DateConverter;
import com.twilio.sdk.creator.taskrouter.v1.workspace.WorkerCreator;
import com.twilio.sdk.deleter.taskrouter.v1.workspace.WorkerDeleter;
import com.twilio.sdk.exception.ApiConnectionException;
import com.twilio.sdk.exception.ApiException;
import com.twilio.sdk.fetcher.taskrouter.v1.workspace.WorkerFetcher;
import com.twilio.sdk.reader.taskrouter.v1.workspace.WorkerReader;
import com.twilio.sdk.resource.SidResource;
import com.twilio.sdk.updater.taskrouter.v1.workspace.WorkerUpdater;
import org.joda.time.DateTime;

import java.io.IOException;
import java.io.InputStream;
import java.util.Objects;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Worker extends SidResource {
    private static final long serialVersionUID = 267403389002552L;

    /**
     * Create a WorkerReader to execute read.
     * 
     * @param workspaceSid The workspace_sid
     * @return WorkerReader capable of executing the read
     */
    public static WorkerReader read(final String workspaceSid) {
        return new WorkerReader(workspaceSid);
    }

    /**
     * Create a WorkerCreator to execute create.
     * 
     * @param workspaceSid The workspace_sid
     * @param friendlyName The friendly_name
     * @return WorkerCreator capable of executing the create
     */
    public static WorkerCreator create(final String workspaceSid, 
                                       final String friendlyName) {
        return new WorkerCreator(workspaceSid, friendlyName);
    }

    /**
     * Create a WorkerFetcher to execute fetch.
     * 
     * @param workspaceSid The workspace_sid
     * @param sid The sid
     * @return WorkerFetcher capable of executing the fetch
     */
    public static WorkerFetcher fetch(final String workspaceSid, 
                                      final String sid) {
        return new WorkerFetcher(workspaceSid, sid);
    }

    /**
     * Create a WorkerUpdater to execute update.
     * 
     * @param workspaceSid The workspace_sid
     * @param sid The sid
     * @return WorkerUpdater capable of executing the update
     */
    public static WorkerUpdater update(final String workspaceSid, 
                                       final String sid) {
        return new WorkerUpdater(workspaceSid, sid);
    }

    /**
     * Create a WorkerDeleter to execute delete.
     * 
     * @param workspaceSid The workspace_sid
     * @param sid The sid
     * @return WorkerDeleter capable of executing the delete
     */
    public static WorkerDeleter delete(final String workspaceSid, 
                                       final String sid) {
        return new WorkerDeleter(workspaceSid, sid);
    }

    /**
     * Converts a JSON String into a Worker object using the provided ObjectMapper.
     * 
     * @param json Raw JSON String
     * @param objectMapper Jackson ObjectMapper
     * @return Worker object represented by the provided JSON
     */
    public static Worker fromJson(final String json, final ObjectMapper objectMapper) {
        // Convert all checked exceptions to Runtime
        try {
            return objectMapper.readValue(json, Worker.class);
        } catch (final JsonMappingException | JsonParseException e) {
            throw new ApiException(e.getMessage(), e);
        } catch (final IOException e) {
            throw new ApiConnectionException(e.getMessage(), e);
        }
    }

    /**
     * Converts a JSON InputStream into a Worker object using the provided
     * ObjectMapper.
     * 
     * @param json Raw JSON InputStream
     * @param objectMapper Jackson ObjectMapper
     * @return Worker object represented by the provided JSON
     */
    public static Worker fromJson(final InputStream json, final ObjectMapper objectMapper) {
        // Convert all checked exceptions to Runtime
        try {
            return objectMapper.readValue(json, Worker.class);
        } catch (final JsonMappingException | JsonParseException e) {
            throw new ApiException(e.getMessage(), e);
        } catch (final IOException e) {
            throw new ApiConnectionException(e.getMessage(), e);
        }
    }

    private final String accountSid;
    private final String activityName;
    private final String activitySid;
    private final String attributes;
    private final Boolean available;
    private final DateTime dateCreated;
    private final DateTime dateStatusChanged;
    private final DateTime dateUpdated;
    private final String friendlyName;
    private final String sid;
    private final String workspaceSid;

    @JsonCreator
    private Worker(@JsonProperty("account_sid")
                   final String accountSid, 
                   @JsonProperty("activity_name")
                   final String activityName, 
                   @JsonProperty("activity_sid")
                   final String activitySid, 
                   @JsonProperty("attributes")
                   final String attributes, 
                   @JsonProperty("available")
                   final Boolean available, 
                   @JsonProperty("date_created")
                   final String dateCreated, 
                   @JsonProperty("date_status_changed")
                   final String dateStatusChanged, 
                   @JsonProperty("date_updated")
                   final String dateUpdated, 
                   @JsonProperty("friendly_name")
                   final String friendlyName, 
                   @JsonProperty("sid")
                   final String sid, 
                   @JsonProperty("workspace_sid")
                   final String workspaceSid) {
        this.accountSid = accountSid;
        this.activityName = activityName;
        this.activitySid = activitySid;
        this.attributes = attributes;
        this.available = available;
        this.dateCreated = DateConverter.iso8601DateTimeFromString(dateCreated);
        this.dateStatusChanged = DateConverter.iso8601DateTimeFromString(dateStatusChanged);
        this.dateUpdated = DateConverter.iso8601DateTimeFromString(dateUpdated);
        this.friendlyName = friendlyName;
        this.sid = sid;
        this.workspaceSid = workspaceSid;
    }

    /**
     * Returns The The account_sid.
     * 
     * @return The account_sid
     */
    public final String getAccountSid() {
        return this.accountSid;
    }

    /**
     * Returns The The activity_name.
     * 
     * @return The activity_name
     */
    public final String getActivityName() {
        return this.activityName;
    }

    /**
     * Returns The The activity_sid.
     * 
     * @return The activity_sid
     */
    public final String getActivitySid() {
        return this.activitySid;
    }

    /**
     * Returns The The attributes.
     * 
     * @return The attributes
     */
    public final String getAttributes() {
        return this.attributes;
    }

    /**
     * Returns The The available.
     * 
     * @return The available
     */
    public final Boolean getAvailable() {
        return this.available;
    }

    /**
     * Returns The The date_created.
     * 
     * @return The date_created
     */
    public final DateTime getDateCreated() {
        return this.dateCreated;
    }

    /**
     * Returns The The date_status_changed.
     * 
     * @return The date_status_changed
     */
    public final DateTime getDateStatusChanged() {
        return this.dateStatusChanged;
    }

    /**
     * Returns The The date_updated.
     * 
     * @return The date_updated
     */
    public final DateTime getDateUpdated() {
        return this.dateUpdated;
    }

    /**
     * Returns The The friendly_name.
     * 
     * @return The friendly_name
     */
    public final String getFriendlyName() {
        return this.friendlyName;
    }

    /**
     * Returns The The sid.
     * 
     * @return The sid
     */
    public final String getSid() {
        return this.sid;
    }

    /**
     * Returns The The workspace_sid.
     * 
     * @return The workspace_sid
     */
    public final String getWorkspaceSid() {
        return this.workspaceSid;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        
        Worker other = (Worker) o;
        
        return Objects.equals(accountSid, other.accountSid) && 
               Objects.equals(activityName, other.activityName) && 
               Objects.equals(activitySid, other.activitySid) && 
               Objects.equals(attributes, other.attributes) && 
               Objects.equals(available, other.available) && 
               Objects.equals(dateCreated, other.dateCreated) && 
               Objects.equals(dateStatusChanged, other.dateStatusChanged) && 
               Objects.equals(dateUpdated, other.dateUpdated) && 
               Objects.equals(friendlyName, other.friendlyName) && 
               Objects.equals(sid, other.sid) && 
               Objects.equals(workspaceSid, other.workspaceSid);
    }

    @Override
    public int hashCode() {
        return Objects.hash(accountSid,
                            activityName,
                            activitySid,
                            attributes,
                            available,
                            dateCreated,
                            dateStatusChanged,
                            dateUpdated,
                            friendlyName,
                            sid,
                            workspaceSid);
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                          .add("accountSid", accountSid)
                          .add("activityName", activityName)
                          .add("activitySid", activitySid)
                          .add("attributes", attributes)
                          .add("available", available)
                          .add("dateCreated", dateCreated)
                          .add("dateStatusChanged", dateStatusChanged)
                          .add("dateUpdated", dateUpdated)
                          .add("friendlyName", friendlyName)
                          .add("sid", sid)
                          .add("workspaceSid", workspaceSid)
                          .toString();
    }
}