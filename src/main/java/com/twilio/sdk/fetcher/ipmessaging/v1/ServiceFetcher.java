/**
 * This code was generated by
 * \ / _    _  _|   _  _
 *  | (_)\/(_)(_|\/| |(/_  v1.0.0
 *       /       /       
 */

package com.twilio.sdk.fetcher.ipmessaging.v1;

import com.twilio.sdk.http.TwilioRestClient;
import com.twilio.sdk.exception.ApiConnectionException;
import com.twilio.sdk.exception.ApiException;
import com.twilio.sdk.fetcher.Fetcher;
import com.twilio.sdk.http.HttpMethod;
import com.twilio.sdk.http.Request;
import com.twilio.sdk.http.Response;
import com.twilio.sdk.resource.RestException;
import com.twilio.sdk.resource.ipmessaging.v1.Service;

public class ServiceFetcher extends Fetcher<Service> {
    private final String sid;

    /**
     * Construct a new ServiceFetcher.
     * 
     * @param sid The sid
     */
    public ServiceFetcher(final String sid) {
        this.sid = sid;
    }

    /**
     * Make the request to the Twilio API to perform the fetch.
     * 
     * @param client TwilioRestClient with which to make the request
     * @return Fetched Service
     */
    @Override
    @SuppressWarnings("checkstyle:linelength")
    public Service execute(final TwilioRestClient client) {
        Request request = new Request(
            HttpMethod.GET,
            TwilioRestClient.Domains.IPMESSAGING,
            "/v1/Services/" + this.sid + "",
            client.getAccountSid()
        );
        
        Response response = client.request(request);
        
        if (response == null) {
            throw new ApiConnectionException("Service fetch failed: Unable to connect to server");
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
        
        return Service.fromJson(response.getStream(), client.getObjectMapper());
    }
}