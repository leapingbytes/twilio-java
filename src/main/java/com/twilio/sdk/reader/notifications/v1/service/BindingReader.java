/**
 * This code was generated by
 * \ / _    _  _|   _  _
 *  | (_)\/(_)(_|\/| |(/_  v1.0.0
 *       /       /       
 */

package com.twilio.sdk.reader.notifications.v1.service;

import com.google.common.collect.Range;
import com.twilio.sdk.http.TwilioRestClient;
import com.twilio.sdk.converter.Promoter;
import com.twilio.sdk.exception.ApiConnectionException;
import com.twilio.sdk.exception.ApiException;
import com.twilio.sdk.http.HttpMethod;
import com.twilio.sdk.http.Request;
import com.twilio.sdk.http.Response;
import com.twilio.sdk.reader.Reader;
import com.twilio.sdk.resource.Page;
import com.twilio.sdk.resource.ResourceSet;
import com.twilio.sdk.resource.RestException;
import com.twilio.sdk.resource.notifications.v1.service.Binding;
import org.joda.time.DateTime;

import java.util.List;

public class BindingReader extends Reader<Binding> {
    private final String serviceSid;
    private DateTime absoluteStartDate;
    private Range<DateTime> rangeStartDate;
    private DateTime absoluteEndDate;
    private Range<DateTime> rangeEndDate;
    private List<String> identity;
    private List<String> tag;

    /**
     * Construct a new BindingReader.
     * 
     * @param serviceSid The service_sid
     */
    public BindingReader(final String serviceSid) {
        this.serviceSid = serviceSid;
    }

    /**
     * The absolute_start_date.
     * 
     * @param absoluteStartDate The absolute_start_date
     * @return this
     */
    public BindingReader byStartDate(final DateTime absoluteStartDate) {
        this.rangeStartDate = null;
        this.absoluteStartDate = absoluteStartDate;
        return this;
    }

    /**
     * The range_start_date.
     * 
     * @param rangeStartDate The range_start_date
     * @return this
     */
    public BindingReader byStartDate(final Range<DateTime> rangeStartDate) {
        this.absoluteStartDate = null;
        this.rangeStartDate = rangeStartDate;
        return this;
    }

    /**
     * The absolute_end_date.
     * 
     * @param absoluteEndDate The absolute_end_date
     * @return this
     */
    public BindingReader byEndDate(final DateTime absoluteEndDate) {
        this.rangeEndDate = null;
        this.absoluteEndDate = absoluteEndDate;
        return this;
    }

    /**
     * The range_end_date.
     * 
     * @param rangeEndDate The range_end_date
     * @return this
     */
    public BindingReader byEndDate(final Range<DateTime> rangeEndDate) {
        this.absoluteEndDate = null;
        this.rangeEndDate = rangeEndDate;
        return this;
    }

    /**
     * The identity.
     * 
     * @param identity The identity
     * @return this
     */
    public BindingReader byIdentity(final List<String> identity) {
        this.identity = identity;
        return this;
    }

    /**
     * The identity.
     * 
     * @param identity The identity
     * @return this
     */
    public BindingReader byIdentity(final String identity) {
        return byIdentity(Promoter.listOfOne(identity));
    }

    /**
     * The tag.
     * 
     * @param tag The tag
     * @return this
     */
    public BindingReader byTag(final List<String> tag) {
        this.tag = tag;
        return this;
    }

    /**
     * The tag.
     * 
     * @param tag The tag
     * @return this
     */
    public BindingReader byTag(final String tag) {
        return byTag(Promoter.listOfOne(tag));
    }

    /**
     * Make the request to the Twilio API to perform the read.
     * 
     * @param client TwilioRestClient with which to make the request
     * @return Binding ResourceSet
     */
    @Override
    public ResourceSet<Binding> execute(final TwilioRestClient client) {
        return new ResourceSet<>(this, client, firstPage());
    }

    /**
     * Make the request to the Twilio API to perform the read.
     * 
     * @param client TwilioRestClient with which to make the request
     * @return Binding ResourceSet
     */
    @Override
    @SuppressWarnings("checkstyle:linelength")
    public Page<Binding> firstPage(final TwilioRestClient client) {
        Request request = new Request(
            HttpMethod.GET,
            TwilioRestClient.Domains.NOTIFICATIONS,
            "/v1/Services/" + this.serviceSid + "/Bindings",
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
    public Page<Binding> nextPage(final Page<Binding> page, 
                                  final TwilioRestClient client) {
        Request request = new Request(
            HttpMethod.GET,
            page.getNextPageUri(),
            client.getAccountSid()
        );
        return pageForRequest(client, request);
    }

    /**
     * Generate a Page of Binding Resources for a given request.
     * 
     * @param client TwilioRestClient with which to make the request
     * @param request Request to generate a page for
     * @return Page for the Request
     */
    private Page<Binding> pageForRequest(final TwilioRestClient client, final Request request) {
        Response response = client.request(request);
        
        if (response == null) {
            throw new ApiConnectionException("Binding read failed: Unable to connect to server");
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
            "bindings",
            response.getContent(),
            Binding.class,
            client.getObjectMapper()
        );
    }

    /**
     * Add the requested query string arguments to the Request.
     * 
     * @param request Request to add query string arguments to
     */
    private void addQueryParams(final Request request) {
        if (absoluteStartDate != null) {
            request.addQueryParam("StartDate", absoluteStartDate.toString(Request.QUERY_STRING_DATE_FORMAT));
        } else if (rangeStartDate != null) {
            request.addQueryDateRange("StartDate", rangeStartDate);
        }
        
        if (absoluteEndDate != null) {
            request.addQueryParam("EndDate", absoluteEndDate.toString(Request.QUERY_STRING_DATE_FORMAT));
        } else if (rangeEndDate != null) {
            request.addQueryDateRange("EndDate", rangeEndDate);
        }
        
        if (identity != null) {
            request.addQueryParam("Identity", identity.toString());
        }
        
        if (tag != null) {
            request.addQueryParam("Tag", tag.toString());
        }
        
        request.addQueryParam("PageSize", Integer.toString(getPageSize()));
    }
}