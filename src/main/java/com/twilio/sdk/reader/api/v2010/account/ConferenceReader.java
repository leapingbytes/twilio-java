/**
 * This code was generated by
 * \ / _    _  _|   _  _
 *  | (_)\/(_)(_|\/| |(/_  v1.0.0
 *       /       /       
 */

package com.twilio.sdk.reader.api.v2010.account;

import com.google.common.collect.Range;
import com.twilio.sdk.http.TwilioRestClient;
import com.twilio.sdk.exception.ApiConnectionException;
import com.twilio.sdk.exception.ApiException;
import com.twilio.sdk.http.HttpMethod;
import com.twilio.sdk.http.Request;
import com.twilio.sdk.http.Response;
import com.twilio.sdk.reader.Reader;
import com.twilio.sdk.resource.Page;
import com.twilio.sdk.resource.ResourceSet;
import com.twilio.sdk.resource.RestException;
import com.twilio.sdk.resource.api.v2010.account.Conference;
import org.joda.time.DateTime;

public class ConferenceReader extends Reader<Conference> {
    private String accountSid;
    private DateTime absoluteDateCreated;
    private Range<DateTime> rangeDateCreated;
    private DateTime absoluteDateUpdated;
    private Range<DateTime> rangeDateUpdated;
    private String friendlyName;
    private Conference.Status status;

    /**
     * Construct a new ConferenceReader.
     */
    public ConferenceReader() {
    }

    /**
     * Construct a new ConferenceReader.
     * 
     * @param accountSid The account_sid
     */
    public ConferenceReader(final String accountSid) {
        this.accountSid = accountSid;
    }

    /**
     * Only show conferences that started on this date, given as YYYY-MM-DD. You can
     * also specify inequality such as DateCreated&lt;=YYYY-MM-DD.
     * 
     * @param absoluteDateCreated Filter by date created
     * @return this
     */
    public ConferenceReader byDateCreated(final DateTime absoluteDateCreated) {
        this.rangeDateCreated = null;
        this.absoluteDateCreated = absoluteDateCreated;
        return this;
    }

    /**
     * Only show conferences that started on this date, given as YYYY-MM-DD. You can
     * also specify inequality such as DateCreated&lt;=YYYY-MM-DD.
     * 
     * @param rangeDateCreated Filter by date created
     * @return this
     */
    public ConferenceReader byDateCreated(final Range<DateTime> rangeDateCreated) {
        this.absoluteDateCreated = null;
        this.rangeDateCreated = rangeDateCreated;
        return this;
    }

    /**
     * Only show conferences that were last updated on this date, given as
     * YYYY-MM-DD. You can also specify inequality such as
     * DateUpdated&gt;=YYYY-MM-DD.
     * 
     * @param absoluteDateUpdated Filter by date updated
     * @return this
     */
    public ConferenceReader byDateUpdated(final DateTime absoluteDateUpdated) {
        this.rangeDateUpdated = null;
        this.absoluteDateUpdated = absoluteDateUpdated;
        return this;
    }

    /**
     * Only show conferences that were last updated on this date, given as
     * YYYY-MM-DD. You can also specify inequality such as
     * DateUpdated&gt;=YYYY-MM-DD.
     * 
     * @param rangeDateUpdated Filter by date updated
     * @return this
     */
    public ConferenceReader byDateUpdated(final Range<DateTime> rangeDateUpdated) {
        this.absoluteDateUpdated = null;
        this.rangeDateUpdated = rangeDateUpdated;
        return this;
    }

    /**
     * Only show results who's friendly name exactly matches the string.
     * 
     * @param friendlyName Filter by friendly name
     * @return this
     */
    public ConferenceReader byFriendlyName(final String friendlyName) {
        this.friendlyName = friendlyName;
        return this;
    }

    /**
     * A string representing the status of the conference. May be `init`,
     * `in-progress`, or `completed`..
     * 
     * @param status The status of the conference
     * @return this
     */
    public ConferenceReader byStatus(final Conference.Status status) {
        this.status = status;
        return this;
    }

    /**
     * Make the request to the Twilio API to perform the read.
     * 
     * @param client TwilioRestClient with which to make the request
     * @return Conference ResourceSet
     */
    @Override
    public ResourceSet<Conference> execute(final TwilioRestClient client) {
        return new ResourceSet<>(this, client, firstPage());
    }

    /**
     * Make the request to the Twilio API to perform the read.
     * 
     * @param client TwilioRestClient with which to make the request
     * @return Conference ResourceSet
     */
    @Override
    @SuppressWarnings("checkstyle:linelength")
    public Page<Conference> firstPage(final TwilioRestClient client) {
        this.accountSid = this.accountSid == null ? client.getAccountSid() : this.accountSid;
        Request request = new Request(
            HttpMethod.GET,
            TwilioRestClient.Domains.API,
            "/2010-04-01/Accounts/" + this.accountSid + "/Conferences.json",
            client.getAccountSid()
        );
        
        addQueryParams(request);
        return pageForRequest(client, request);
    }

    /**
     * Retrieve the next page from the Twilio API.
     * 
     * @param page current page
     * @param client TwilioRestClient with which to make the request
     * @return Next Page
     */
    @Override
    public Page<Conference> nextPage(final Page<Conference> page, 
                                     final TwilioRestClient client) {
        Request request = new Request(
            HttpMethod.GET,
            page.getNextPageUri(),
            client.getAccountSid()
        );
        return pageForRequest(client, request);
    }

    /**
     * Generate a Page of Conference Resources for a given request.
     * 
     * @param client TwilioRestClient with which to make the request
     * @param request Request to generate a page for
     * @return Page for the Request
     */
    private Page<Conference> pageForRequest(final TwilioRestClient client, final Request request) {
        Response response = client.request(request);
        
        if (response == null) {
            throw new ApiConnectionException("Conference read failed: Unable to connect to server");
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
        
        return Page.fromJson(
            "conferences",
            response.getContent(),
            Conference.class,
            client.getObjectMapper()
        );
    }

    /**
     * Add the requested query string arguments to the Request.
     * 
     * @param request Request to add query string arguments to
     */
    private void addQueryParams(final Request request) {
        if (absoluteDateCreated != null) {
            request.addQueryParam("DateCreated", absoluteDateCreated.toString(Request.QUERY_STRING_DATE_FORMAT));
        } else if (rangeDateCreated != null) {
            request.addQueryDateRange("DateCreated", rangeDateCreated);
        }
        
        if (absoluteDateUpdated != null) {
            request.addQueryParam("DateUpdated", absoluteDateUpdated.toString(Request.QUERY_STRING_DATE_FORMAT));
        } else if (rangeDateUpdated != null) {
            request.addQueryDateRange("DateUpdated", rangeDateUpdated);
        }
        
        if (friendlyName != null) {
            request.addQueryParam("FriendlyName", friendlyName);
        }
        
        if (status != null) {
            request.addQueryParam("Status", status.toString());
        }
        
        request.addQueryParam("PageSize", Integer.toString(getPageSize()));
    }
}