/**
 * This code was generated by
 * \ / _    _  _|   _  _
 *  | (_)\/(_)(_|\/| |(/_  v1.0.0
 *       /       /       
 */

package com.twilio.sdk.deleter.api.v2010.account.message;

import com.twilio.sdk.http.TwilioRestClient;
import com.twilio.sdk.deleter.Deleter;
import com.twilio.sdk.exception.ApiConnectionException;
import com.twilio.sdk.exception.ApiException;
import com.twilio.sdk.http.HttpMethod;
import com.twilio.sdk.http.Request;
import com.twilio.sdk.http.Response;
import com.twilio.sdk.resource.RestException;
import com.twilio.sdk.resource.api.v2010.account.message.Media;

public class MediaDeleter extends Deleter<Media> {
    private String accountSid;
    private final String messageSid;
    private final String sid;

    /**
     * Construct a new MediaDeleter.
     * 
     * @param messageSid The message_sid
     * @param sid Delete by unique media Sid
     */
    public MediaDeleter(final String messageSid, 
                        final String sid) {
        this.messageSid = messageSid;
        this.sid = sid;
    }

    /**
     * Construct a new MediaDeleter.
     * 
     * @param accountSid The account_sid
     * @param messageSid The message_sid
     * @param sid Delete by unique media Sid
     */
    public MediaDeleter(final String accountSid, 
                        final String messageSid, 
                        final String sid) {
        this.accountSid = accountSid;
        this.messageSid = messageSid;
        this.sid = sid;
    }

    /**
     * Make the request to the Twilio API to perform the delete.
     * 
     * @param client TwilioRestClient with which to make the request
     */
    @Override
    @SuppressWarnings("checkstyle:linelength")
    public boolean execute(final TwilioRestClient client) {
        this.accountSid = this.accountSid == null ? client.getAccountSid() : this.accountSid;
        Request request = new Request(
            HttpMethod.DELETE,
            TwilioRestClient.Domains.API,
            "/2010-04-01/Accounts/" + this.accountSid + "/Messages/" + this.messageSid + "/Media/" + this.sid + ".json",
            client.getAccountSid()
        );
        
        Response response = client.request(request);
        
        if (response == null) {
            throw new ApiConnectionException("Media delete failed: Unable to connect to server");
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
        
        return response.getStatusCode() == 204;
    }
}