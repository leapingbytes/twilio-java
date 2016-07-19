/**
 * This code was generated by
 * \ / _    _  _|   _  _
 *  | (_)\/(_)(_|\/| |(/_  v1.0.0
 *       /       /       
 */

package com.twilio.sdk.resource.api.v2010.account.usage;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.base.MoreObjects;
import com.twilio.sdk.converter.DateConverter;
import com.twilio.sdk.creator.api.v2010.account.usage.TriggerCreator;
import com.twilio.sdk.deleter.api.v2010.account.usage.TriggerDeleter;
import com.twilio.sdk.exception.ApiConnectionException;
import com.twilio.sdk.exception.ApiException;
import com.twilio.sdk.fetcher.api.v2010.account.usage.TriggerFetcher;
import com.twilio.sdk.http.HttpMethod;
import com.twilio.sdk.reader.api.v2010.account.usage.TriggerReader;
import com.twilio.sdk.resource.SidResource;
import com.twilio.sdk.updater.api.v2010.account.usage.TriggerUpdater;
import org.joda.time.DateTime;

import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.util.Objects;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Trigger extends SidResource {
    private static final long serialVersionUID = 265472878252662L;

    public enum UsageCategory {
        AUTHY_AUTHENTICATIONS("authy-authentications"),
        AUTHY_CALLS_OUTBOUND("authy-calls-outbound"),
        AUTHY_MONTHLY_FEES("authy-monthly-fees"),
        AUTHY_PHONE_INTELLIGENCE("authy-phone-intelligence"),
        AUTHY_PHONE_VERIFICATIONS("authy-phone-verifications"),
        AUTHY_SMS_OUTBOUND("authy-sms-outbound"),
        CALL_PROGESS_EVENTS("call-progess-events"),
        CALLERIDLOOKUPS("calleridlookups"),
        CALLS("calls"),
        CALLS_CLIENT("calls-client"),
        CALLS_GLOBALCONFERENCE("calls-globalconference"),
        CALLS_INBOUND("calls-inbound"),
        CALLS_INBOUND_LOCAL("calls-inbound-local"),
        CALLS_INBOUND_MOBILE("calls-inbound-mobile"),
        CALLS_INBOUND_TOLLFREE("calls-inbound-tollfree"),
        CALLS_OUTBOUND("calls-outbound"),
        CALLS_RECORDINGS("calls-recordings"),
        CALLS_SIP("calls-sip"),
        CALLS_SIP_INBOUND("calls-sip-inbound"),
        CALLS_SIP_OUTBOUND("calls-sip-outbound"),
        CARRIER_LOOKUPS("carrier-lookups"),
        CONVERSATIONS("conversations"),
        CONVERSATIONS_API_REQUESTS("conversations-api-requests"),
        CONVERSATIONS_CONVERSATION_EVENTS("conversations-conversation-events"),
        CONVERSATIONS_ENDPOINT_CONNECTIVITY("conversations-endpoint-connectivity"),
        CONVERSATIONS_EVENTS("conversations-events"),
        CONVERSATIONS_PARTICIPANT_EVENTS("conversations-participant-events"),
        CONVERSATIONS_PARTICIPANTS("conversations-participants"),
        IP_MESSAGING("ip-messaging"),
        IP_MESSAGING_COMMANDS("ip-messaging-commands"),
        IP_MESSAGING_DATA_STORAGE("ip-messaging-data-storage"),
        IP_MESSAGING_DATA_TRANSFER("ip-messaging-data-transfer"),
        IP_MESSAGING_ENDPOINT_CONNECTIVITY("ip-messaging-endpoint-connectivity"),
        LOOKUPS("lookups"),
        MEDIASTORAGE("mediastorage"),
        MMS("mms"),
        MMS_INBOUND("mms-inbound"),
        MMS_INBOUND_LONGCODE("mms-inbound-longcode"),
        MMS_INBOUND_SHORTCODE("mms-inbound-shortcode"),
        MMS_OUTBOUND("mms-outbound"),
        MMS_OUTBOUND_LONGCODE("mms-outbound-longcode"),
        MMS_OUTBOUND_SHORTCODE("mms-outbound-shortcode"),
        MONITOR_READS("monitor-reads"),
        MONITOR_STORAGE("monitor-storage"),
        MONITOR_WRITES("monitor-writes"),
        NUMBER_FORMAT_LOOKUPS("number-format-lookups"),
        PHONENUMBERS("phonenumbers"),
        PHONENUMBERS_CPS("phonenumbers-cps"),
        PHONENUMBERS_EMERGENCY("phonenumbers-emergency"),
        PHONENUMBERS_LOCAL("phonenumbers-local"),
        PHONENUMBERS_MOBILE("phonenumbers-mobile"),
        PHONENUMBERS_SETUPS("phonenumbers-setups"),
        PHONENUMBERS_TOLLFREE("phonenumbers-tollfree"),
        PREMIUMSUPPORT("premiumsupport"),
        RECORDINGS("recordings"),
        RECORDINGSTORAGE("recordingstorage"),
        SHORTCODES("shortcodes"),
        SHORTCODES_CUSTOMEROWNED("shortcodes-customerowned"),
        SHORTCODES_MMS_ENABLEMENT("shortcodes-mms-enablement"),
        SHORTCODES_MPS("shortcodes-mps"),
        SHORTCODES_RANDOM("shortcodes-random"),
        SHORTCODES_UK("shortcodes-uk"),
        SHORTCODES_VANITY("shortcodes-vanity"),
        SMS("sms"),
        SMS_INBOUND("sms-inbound"),
        SMS_INBOUND_LONGCODE("sms-inbound-longcode"),
        SMS_INBOUND_SHORTCODE("sms-inbound-shortcode"),
        SMS_OUTBOUND("sms-outbound"),
        SMS_OUTBOUND_LONGCODE("sms-outbound-longcode"),
        SMS_OUTBOUND_SHORTCODE("sms-outbound-shortcode"),
        TASKROUTER_TASKS("taskrouter-tasks"),
        TOTALPRICE("totalprice"),
        TRANSCRIPTIONS("transcriptions"),
        TRUNKING_CPS("trunking-cps"),
        TRUNKING_EMERGENCY_CALLS("trunking-emergency-calls"),
        TRUNKING_ORIGINATION("trunking-origination"),
        TRUNKING_ORIGINATION_LOCAL("trunking-origination-local"),
        TRUNKING_ORIGINATION_MOBILE("trunking-origination-mobile"),
        TRUNKING_ORIGINATION_TOLLFREE("trunking-origination-tollfree"),
        TRUNKING_RECORDINGS("trunking-recordings"),
        TRUNKING_SECURE("trunking-secure"),
        TRUNKING_TERMINATION("trunking-termination"),
        TURNMEGABYTES("turnmegabytes"),
        TURNMEGABYTES_AUSTRALIA("turnmegabytes-australia"),
        TURNMEGABYTES_BRASIL("turnmegabytes-brasil"),
        TURNMEGABYTES_IRELAND("turnmegabytes-ireland"),
        TURNMEGABYTES_JAPAN("turnmegabytes-japan"),
        TURNMEGABYTES_SINGAPORE("turnmegabytes-singapore"),
        TURNMEGABYTES_USEAST("turnmegabytes-useast"),
        TURNMEGABYTES_USWEST("turnmegabytes-uswest");
    
        private final String value;
        
        private UsageCategory(final String value) {
            this.value = value;
        }
        
        public String toString() {
            return value;
        }
        
        /**
         * Generate a UsageCategory from a string.
         * @param value string value
         * @return generated UsageCategory
         */
        @JsonCreator
        public static UsageCategory forValue(final String value) {
            String normalized = value.replace("-", "_").toUpperCase();
            try {
                return UsageCategory.valueOf(normalized);
            } catch (RuntimeException e) {
        
                // Don't blow up of value does not exist
                return null;
            }
        }
    }

    public enum Recurring {
        DAILY("daily"),
        MONTHLY("monthly"),
        YEARLY("yearly"),
        ALLTIME("alltime");
    
        private final String value;
        
        private Recurring(final String value) {
            this.value = value;
        }
        
        public String toString() {
            return value;
        }
        
        /**
         * Generate a Recurring from a string.
         * @param value string value
         * @return generated Recurring
         */
        @JsonCreator
        public static Recurring forValue(final String value) {
            String normalized = value.replace("-", "_").toUpperCase();
            try {
                return Recurring.valueOf(normalized);
            } catch (RuntimeException e) {
        
                // Don't blow up of value does not exist
                return null;
            }
        }
    }

    public enum TriggerField {
        COUNT("count"),
        USAGE("usage"),
        PRICE("price");
    
        private final String value;
        
        private TriggerField(final String value) {
            this.value = value;
        }
        
        public String toString() {
            return value;
        }
        
        /**
         * Generate a TriggerField from a string.
         * @param value string value
         * @return generated TriggerField
         */
        @JsonCreator
        public static TriggerField forValue(final String value) {
            String normalized = value.replace("-", "_").toUpperCase();
            try {
                return TriggerField.valueOf(normalized);
            } catch (RuntimeException e) {
        
                // Don't blow up of value does not exist
                return null;
            }
        }
    }

    /**
     * Create a TriggerFetcher to execute fetch.
     * 
     * @param accountSid The account_sid
     * @param sid Fetch by unique usage-trigger Sid
     * @return TriggerFetcher capable of executing the fetch
     */
    public static TriggerFetcher fetch(final String accountSid, 
                                       final String sid) {
        return new TriggerFetcher(accountSid, sid);
    }

    /**
     * Create a TriggerFetcher to execute fetch.
     * 
     * @param sid Fetch by unique usage-trigger Sid
     * @return TriggerFetcher capable of executing the fetch
     */
    public static TriggerFetcher fetch(final String sid) {
        return new TriggerFetcher(sid);
    }

    /**
     * Create a TriggerUpdater to execute update.
     * 
     * @param accountSid The account_sid
     * @param sid The sid
     * @return TriggerUpdater capable of executing the update
     */
    public static TriggerUpdater update(final String accountSid, 
                                        final String sid) {
        return new TriggerUpdater(accountSid, sid);
    }

    /**
     * Create a TriggerUpdater to execute update.
     * 
     * @param sid The sid
     * @return TriggerUpdater capable of executing the update
     */
    public static TriggerUpdater update(final String sid) {
        return new TriggerUpdater(sid);
    }

    /**
     * Create a TriggerDeleter to execute delete.
     * 
     * @param accountSid The account_sid
     * @param sid The sid
     * @return TriggerDeleter capable of executing the delete
     */
    public static TriggerDeleter delete(final String accountSid, 
                                        final String sid) {
        return new TriggerDeleter(accountSid, sid);
    }

    /**
     * Create a TriggerDeleter to execute delete.
     * 
     * @param sid The sid
     * @return TriggerDeleter capable of executing the delete
     */
    public static TriggerDeleter delete(final String sid) {
        return new TriggerDeleter(sid);
    }

    /**
     * Create a TriggerCreator to execute create.
     * 
     * @param accountSid The account_sid
     * @param callbackUrl URL Twilio will request when the trigger fires
     * @param triggerValue the value at which the trigger will fire
     * @param usageCategory The usage category the trigger watches
     * @return TriggerCreator capable of executing the create
     */
    public static TriggerCreator create(final String accountSid, 
                                        final URI callbackUrl, 
                                        final String triggerValue, 
                                        final Trigger.UsageCategory usageCategory) {
        return new TriggerCreator(accountSid, callbackUrl, triggerValue, usageCategory);
    }

    /**
     * Create a TriggerCreator to execute create.
     * 
     * @param callbackUrl URL Twilio will request when the trigger fires
     * @param triggerValue the value at which the trigger will fire
     * @param usageCategory The usage category the trigger watches
     * @return TriggerCreator capable of executing the create
     */
    public static TriggerCreator create(final URI callbackUrl, 
                                        final String triggerValue, 
                                        final Trigger.UsageCategory usageCategory) {
        return new TriggerCreator(callbackUrl, triggerValue, usageCategory);
    }

    /**
     * Create a TriggerReader to execute read.
     * 
     * @param accountSid The account_sid
     * @return TriggerReader capable of executing the read
     */
    public static TriggerReader read(final String accountSid) {
        return new TriggerReader(accountSid);
    }

    /**
     * Create a TriggerReader to execute read.
     * 
     * @return TriggerReader capable of executing the read
     */
    public static TriggerReader read() {
        return new TriggerReader();
    }

    /**
     * Converts a JSON String into a Trigger object using the provided ObjectMapper.
     * 
     * @param json Raw JSON String
     * @param objectMapper Jackson ObjectMapper
     * @return Trigger object represented by the provided JSON
     */
    public static Trigger fromJson(final String json, final ObjectMapper objectMapper) {
        // Convert all checked exceptions to Runtime
        try {
            return objectMapper.readValue(json, Trigger.class);
        } catch (final JsonMappingException | JsonParseException e) {
            throw new ApiException(e.getMessage(), e);
        } catch (final IOException e) {
            throw new ApiConnectionException(e.getMessage(), e);
        }
    }

    /**
     * Converts a JSON InputStream into a Trigger object using the provided
     * ObjectMapper.
     * 
     * @param json Raw JSON InputStream
     * @param objectMapper Jackson ObjectMapper
     * @return Trigger object represented by the provided JSON
     */
    public static Trigger fromJson(final InputStream json, final ObjectMapper objectMapper) {
        // Convert all checked exceptions to Runtime
        try {
            return objectMapper.readValue(json, Trigger.class);
        } catch (final JsonMappingException | JsonParseException e) {
            throw new ApiException(e.getMessage(), e);
        } catch (final IOException e) {
            throw new ApiConnectionException(e.getMessage(), e);
        }
    }

    private final String accountSid;
    private final String apiVersion;
    private final HttpMethod callbackMethod;
    private final URI callbackUrl;
    private final String currentValue;
    private final DateTime dateCreated;
    private final DateTime dateFired;
    private final DateTime dateUpdated;
    private final String friendlyName;
    private final Trigger.Recurring recurring;
    private final String sid;
    private final Trigger.TriggerField triggerBy;
    private final String triggerValue;
    private final String uri;
    private final Trigger.UsageCategory usageCategory;
    private final String usageRecordUri;

    @JsonCreator
    private Trigger(@JsonProperty("account_sid")
                    final String accountSid, 
                    @JsonProperty("api_version")
                    final String apiVersion, 
                    @JsonProperty("callback_method")
                    final HttpMethod callbackMethod, 
                    @JsonProperty("callback_url")
                    final URI callbackUrl, 
                    @JsonProperty("current_value")
                    final String currentValue, 
                    @JsonProperty("date_created")
                    final String dateCreated, 
                    @JsonProperty("date_fired")
                    final String dateFired, 
                    @JsonProperty("date_updated")
                    final String dateUpdated, 
                    @JsonProperty("friendly_name")
                    final String friendlyName, 
                    @JsonProperty("recurring")
                    final Trigger.Recurring recurring, 
                    @JsonProperty("sid")
                    final String sid, 
                    @JsonProperty("trigger_by")
                    final Trigger.TriggerField triggerBy, 
                    @JsonProperty("trigger_value")
                    final String triggerValue, 
                    @JsonProperty("uri")
                    final String uri, 
                    @JsonProperty("usage_category")
                    final Trigger.UsageCategory usageCategory, 
                    @JsonProperty("usage_record_uri")
                    final String usageRecordUri) {
        this.accountSid = accountSid;
        this.apiVersion = apiVersion;
        this.callbackMethod = callbackMethod;
        this.callbackUrl = callbackUrl;
        this.currentValue = currentValue;
        this.dateCreated = DateConverter.rfc2822DateTimeFromString(dateCreated);
        this.dateFired = DateConverter.rfc2822DateTimeFromString(dateFired);
        this.dateUpdated = DateConverter.rfc2822DateTimeFromString(dateUpdated);
        this.friendlyName = friendlyName;
        this.recurring = recurring;
        this.sid = sid;
        this.triggerBy = triggerBy;
        this.triggerValue = triggerValue;
        this.uri = uri;
        this.usageCategory = usageCategory;
        this.usageRecordUri = usageRecordUri;
    }

    /**
     * Returns The The account this trigger monitors..
     * 
     * @return The account this trigger monitors.
     */
    public final String getAccountSid() {
        return this.accountSid;
    }

    /**
     * Returns The The api_version.
     * 
     * @return The api_version
     */
    public final String getApiVersion() {
        return this.apiVersion;
    }

    /**
     * Returns The HTTP method to use with callback_url.
     * 
     * @return HTTP method to use with callback_url
     */
    public final HttpMethod getCallbackMethod() {
        return this.callbackMethod;
    }

    /**
     * Returns The URL Twilio will request when the trigger fires.
     * 
     * @return URL Twilio will request when the trigger fires
     */
    public final URI getCallbackUrl() {
        return this.callbackUrl;
    }

    /**
     * Returns The The current value of the field the trigger is watching..
     * 
     * @return The current value of the field the trigger is watching.
     */
    public final String getCurrentValue() {
        return this.currentValue;
    }

    /**
     * Returns The The date this resource was created.
     * 
     * @return The date this resource was created
     */
    public final DateTime getDateCreated() {
        return this.dateCreated;
    }

    /**
     * Returns The The date the trigger was last fired.
     * 
     * @return The date the trigger was last fired
     */
    public final DateTime getDateFired() {
        return this.dateFired;
    }

    /**
     * Returns The The date this resource was last updated.
     * 
     * @return The date this resource was last updated
     */
    public final DateTime getDateUpdated() {
        return this.dateUpdated;
    }

    /**
     * Returns The A user-specified, human-readable name for the trigger..
     * 
     * @return A user-specified, human-readable name for the trigger.
     */
    public final String getFriendlyName() {
        return this.friendlyName;
    }

    /**
     * Returns The How this trigger recurs.
     * 
     * @return How this trigger recurs
     */
    public final Trigger.Recurring getRecurring() {
        return this.recurring;
    }

    /**
     * Returns The The trigger's unique Sid.
     * 
     * @return The trigger's unique Sid
     */
    public final String getSid() {
        return this.sid;
    }

    /**
     * Returns The The field in the UsageRecord that fires the trigger.
     * 
     * @return The field in the UsageRecord that fires the trigger
     */
    public final Trigger.TriggerField getTriggerBy() {
        return this.triggerBy;
    }

    /**
     * Returns The the value at which the trigger will fire.
     * 
     * @return the value at which the trigger will fire
     */
    public final String getTriggerValue() {
        return this.triggerValue;
    }

    /**
     * Returns The The URI for this resource.
     * 
     * @return The URI for this resource
     */
    public final String getUri() {
        return this.uri;
    }

    /**
     * Returns The The usage category the trigger watches.
     * 
     * @return The usage category the trigger watches
     */
    public final Trigger.UsageCategory getUsageCategory() {
        return this.usageCategory;
    }

    /**
     * Returns The The URI of the UsageRecord this trigger is watching.
     * 
     * @return The URI of the UsageRecord this trigger is watching
     */
    public final String getUsageRecordUri() {
        return this.usageRecordUri;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        
        Trigger other = (Trigger) o;
        
        return Objects.equals(accountSid, other.accountSid) && 
               Objects.equals(apiVersion, other.apiVersion) && 
               Objects.equals(callbackMethod, other.callbackMethod) && 
               Objects.equals(callbackUrl, other.callbackUrl) && 
               Objects.equals(currentValue, other.currentValue) && 
               Objects.equals(dateCreated, other.dateCreated) && 
               Objects.equals(dateFired, other.dateFired) && 
               Objects.equals(dateUpdated, other.dateUpdated) && 
               Objects.equals(friendlyName, other.friendlyName) && 
               Objects.equals(recurring, other.recurring) && 
               Objects.equals(sid, other.sid) && 
               Objects.equals(triggerBy, other.triggerBy) && 
               Objects.equals(triggerValue, other.triggerValue) && 
               Objects.equals(uri, other.uri) && 
               Objects.equals(usageCategory, other.usageCategory) && 
               Objects.equals(usageRecordUri, other.usageRecordUri);
    }

    @Override
    public int hashCode() {
        return Objects.hash(accountSid,
                            apiVersion,
                            callbackMethod,
                            callbackUrl,
                            currentValue,
                            dateCreated,
                            dateFired,
                            dateUpdated,
                            friendlyName,
                            recurring,
                            sid,
                            triggerBy,
                            triggerValue,
                            uri,
                            usageCategory,
                            usageRecordUri);
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                          .add("accountSid", accountSid)
                          .add("apiVersion", apiVersion)
                          .add("callbackMethod", callbackMethod)
                          .add("callbackUrl", callbackUrl)
                          .add("currentValue", currentValue)
                          .add("dateCreated", dateCreated)
                          .add("dateFired", dateFired)
                          .add("dateUpdated", dateUpdated)
                          .add("friendlyName", friendlyName)
                          .add("recurring", recurring)
                          .add("sid", sid)
                          .add("triggerBy", triggerBy)
                          .add("triggerValue", triggerValue)
                          .add("uri", uri)
                          .add("usageCategory", usageCategory)
                          .add("usageRecordUri", usageRecordUri)
                          .toString();
    }
}