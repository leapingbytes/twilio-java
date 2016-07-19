/**
 * This code was generated by
 * \ / _    _  _|   _  _
 *  | (_)\/(_)(_|\/| |(/_  v1.0.0
 *       /       /       
 */

package com.twilio.sdk.resource.api.v2010.account;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.base.MoreObjects;
import com.twilio.sdk.converter.DateConverter;
import com.twilio.sdk.creator.api.v2010.account.NewKeyCreator;
import com.twilio.sdk.exception.ApiConnectionException;
import com.twilio.sdk.exception.ApiException;
import com.twilio.sdk.resource.Resource;
import org.joda.time.DateTime;

import java.io.IOException;
import java.io.InputStream;
import java.util.Objects;

@JsonIgnoreProperties(ignoreUnknown = true)
public class NewKey extends Resource {
    private static final long serialVersionUID = 61650791237409L;

    /**
     * Create a NewKeyCreator to execute create.
     * 
     * @param accountSid The account_sid
     * @return NewKeyCreator capable of executing the create
     */
    public static NewKeyCreator create(final String accountSid) {
        return new NewKeyCreator(accountSid);
    }

    /**
     * Create a NewKeyCreator to execute create.
     * 
     * @return NewKeyCreator capable of executing the create
     */
    public static NewKeyCreator create() {
        return new NewKeyCreator();
    }

    /**
     * Converts a JSON String into a NewKey object using the provided ObjectMapper.
     * 
     * @param json Raw JSON String
     * @param objectMapper Jackson ObjectMapper
     * @return NewKey object represented by the provided JSON
     */
    public static NewKey fromJson(final String json, final ObjectMapper objectMapper) {
        // Convert all checked exceptions to Runtime
        try {
            return objectMapper.readValue(json, NewKey.class);
        } catch (final JsonMappingException | JsonParseException e) {
            throw new ApiException(e.getMessage(), e);
        } catch (final IOException e) {
            throw new ApiConnectionException(e.getMessage(), e);
        }
    }

    /**
     * Converts a JSON InputStream into a NewKey object using the provided
     * ObjectMapper.
     * 
     * @param json Raw JSON InputStream
     * @param objectMapper Jackson ObjectMapper
     * @return NewKey object represented by the provided JSON
     */
    public static NewKey fromJson(final InputStream json, final ObjectMapper objectMapper) {
        // Convert all checked exceptions to Runtime
        try {
            return objectMapper.readValue(json, NewKey.class);
        } catch (final JsonMappingException | JsonParseException e) {
            throw new ApiException(e.getMessage(), e);
        } catch (final IOException e) {
            throw new ApiConnectionException(e.getMessage(), e);
        }
    }

    private final String sid;
    private final String friendlyName;
    private final DateTime dateCreated;
    private final DateTime dateUpdated;
    private final String secret;

    @JsonCreator
    private NewKey(@JsonProperty("sid")
                   final String sid, 
                   @JsonProperty("friendly_name")
                   final String friendlyName, 
                   @JsonProperty("date_created")
                   final String dateCreated, 
                   @JsonProperty("date_updated")
                   final String dateUpdated, 
                   @JsonProperty("secret")
                   final String secret) {
        this.sid = sid;
        this.friendlyName = friendlyName;
        this.dateCreated = DateConverter.rfc2822DateTimeFromString(dateCreated);
        this.dateUpdated = DateConverter.rfc2822DateTimeFromString(dateUpdated);
        this.secret = secret;
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
     * Returns The The friendly_name.
     * 
     * @return The friendly_name
     */
    public final String getFriendlyName() {
        return this.friendlyName;
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
     * Returns The The date_updated.
     * 
     * @return The date_updated
     */
    public final DateTime getDateUpdated() {
        return this.dateUpdated;
    }

    /**
     * Returns The The secret.
     * 
     * @return The secret
     */
    public final String getSecret() {
        return this.secret;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        
        NewKey other = (NewKey) o;
        
        return Objects.equals(sid, other.sid) && 
               Objects.equals(friendlyName, other.friendlyName) && 
               Objects.equals(dateCreated, other.dateCreated) && 
               Objects.equals(dateUpdated, other.dateUpdated) && 
               Objects.equals(secret, other.secret);
    }

    @Override
    public int hashCode() {
        return Objects.hash(sid,
                            friendlyName,
                            dateCreated,
                            dateUpdated,
                            secret);
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                          .add("sid", sid)
                          .add("friendlyName", friendlyName)
                          .add("dateCreated", dateCreated)
                          .add("dateUpdated", dateUpdated)
                          .add("secret", secret)
                          .toString();
    }
}