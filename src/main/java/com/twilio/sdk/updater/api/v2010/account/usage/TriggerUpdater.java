/**
 * This code was generated by
 * \ / _    _  _|   _  _
 *  | (_)\/(_)(_|\/| |(/_  v1.0.0
 *       /       /       
 */

package com.twilio.sdk.updater.api.v2010.account.usage;

import com.twilio.sdk.http.TwilioRestClient;
import com.twilio.sdk.converter.Promoter;
import com.twilio.sdk.exception.ApiConnectionException;
import com.twilio.sdk.exception.ApiException;
import com.twilio.sdk.http.HttpMethod;
import com.twilio.sdk.http.Request;
import com.twilio.sdk.http.Response;
import com.twilio.sdk.resource.RestException;
import com.twilio.sdk.resource.api.v2010.account.usage.Trigger;
import com.twilio.sdk.updater.Updater;

import java.net.URI;

public class TriggerUpdater extends Updater<Trigger> {
    private String accountSid;
    private final String sid;
    private HttpMethod callbackMethod;
    private URI callbackUrl;
    private String friendlyName;

    /**
     * Construct a new TriggerUpdater.
     * 
     * @param sid The sid
     */
    public TriggerUpdater(final String sid) {
        this.sid = sid;
    }

    /**
     * Construct a new TriggerUpdater.
     * 
     * @param accountSid The account_sid
     * @param sid The sid
     */
    public TriggerUpdater(final String accountSid, 
                          final String sid) {
        this.accountSid = accountSid;
        this.sid = sid;
    }

    /**
     * The HTTP method Twilio will use when making a request to the CallbackUrl. 
     * GET or POST..
     * 
     * @param callbackMethod HTTP method to use with callback_url
     * @return this
     */
    public TriggerUpdater setCallbackMethod(final HttpMethod callbackMethod) {
        this.callbackMethod = callbackMethod;
        return this;
    }

    /**
     * Twilio will make a request to this url when the trigger fires..
     * 
     * @param callbackUrl URL Twilio will request when the trigger fires
     * @return this
     */
    public TriggerUpdater setCallbackUrl(final URI callbackUrl) {
        this.callbackUrl = callbackUrl;
        return this;
    }

    /**
     * Twilio will make a request to this url when the trigger fires..
     * 
     * @param callbackUrl URL Twilio will request when the trigger fires
     * @return this
     */
    public TriggerUpdater setCallbackUrl(final String callbackUrl) {
        return setCallbackUrl(Promoter.uriFromString(callbackUrl));
    }

    /**
     * A user-specified, human-readable name for the trigger..
     * 
     * @param friendlyName A user-specified, human-readable name for the trigger.
     * @return this
     */
    public TriggerUpdater setFriendlyName(final String friendlyName) {
        this.friendlyName = friendlyName;
        return this;
    }

    /**
     * Make the request to the Twilio API to perform the update.
     * 
     * @param client TwilioRestClient with which to make the request
     * @return Updated Trigger
     */
    @Override
    @SuppressWarnings("checkstyle:linelength")
    public Trigger execute(final TwilioRestClient client) {
        this.accountSid = this.accountSid == null ? client.getAccountSid() : this.accountSid;
        Request request = new Request(
            HttpMethod.POST,
            TwilioRestClient.Domains.API,
            "/2010-04-01/Accounts/" + this.accountSid + "/Usage/Triggers/" + this.sid + ".json",
            client.getAccountSid()
        );
        
        addPostParams(request);
        Response response = client.request(request);
        
        if (response == null) {
            throw new ApiConnectionException("Trigger update failed: Unable to connect to server");
        } else if (!TwilioRestClient.SUCCESS.apply(response.getStatusCode())) {
            RestException restException = RestException.fromJson(response.getStream(), client.getObjectMapper());
            if (restException == null) {
                throw new ApiException("Server Error, no content");
            }
        
            throw new ApiException(
                restException.getMessage(),
                restException.getCode(),
                restException.getMoreInfo(),
                restException.getStatus(),
                null
            );
        }
        
        return Trigger.fromJson(response.getStream(), client.getObjectMapper());
    }

    /**
     * Add the requested post parameters to the Request.
     * 
     * @param request Request to add post params to
     */
    private void addPostParams(final Request request) {
        if (callbackMethod != null) {
            request.addPostParam("CallbackMethod", callbackMethod.toString());
        }
        
        if (callbackUrl != null) {
            request.addPostParam("CallbackUrl", callbackUrl.toString());
        }
        
        if (friendlyName != null) {
            request.addPostParam("FriendlyName", friendlyName);
        }
    }
}