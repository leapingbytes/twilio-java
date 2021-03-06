/**
 * This code was generated by
 * \ / _    _  _|   _  _
 *  | (_)\/(_)(_|\/| |(/_  v1.0.0
 *       /       /
 */

package com.twilio.rest.proxy.v1;

import com.twilio.base.Creator;
import com.twilio.converter.Promoter;
import com.twilio.exception.ApiConnectionException;
import com.twilio.exception.ApiException;
import com.twilio.exception.RestException;
import com.twilio.http.HttpMethod;
import com.twilio.http.Request;
import com.twilio.http.Response;
import com.twilio.http.TwilioRestClient;
import com.twilio.rest.Domains;

import java.net.URI;

/**
 * PLEASE NOTE that this class contains beta products that are subject to
 * change. Use them with caution.
 */
public class ServiceCreator extends Creator<Service> {
    private final String uniqueName;
    private Integer defaultTtl;
    private URI callbackUrl;
    private Service.GeoMatchLevel geoMatchLevel;
    private Service.NumberSelectionBehavior numberSelectionBehavior;
    private URI interceptCallbackUrl;
    private URI outOfSessionCallbackUrl;
    private String chatInstanceSid;

    /**
     * Construct a new ServiceCreator.
     * 
     * @param uniqueName An application-defined string that uniquely identifies the
     *                   resource
     */
    public ServiceCreator(final String uniqueName) {
        this.uniqueName = uniqueName;
    }

    /**
     * The default `ttl` value to set for Sessions created in the Service. The TTL
     * (time to live) is measured in seconds after the Session's last create or last
     * Interaction. The default value of `0` indicates an unlimited Session length.
     * You can override a Session's default TTL value by setting its `ttl` value..
     * 
     * @param defaultTtl Default TTL for a Session, in seconds
     * @return this
     */
    public ServiceCreator setDefaultTtl(final Integer defaultTtl) {
        this.defaultTtl = defaultTtl;
        return this;
    }

    /**
     * The URL we should call when the interaction status changes..
     * 
     * @param callbackUrl The URL we should call when the interaction status changes
     * @return this
     */
    public ServiceCreator setCallbackUrl(final URI callbackUrl) {
        this.callbackUrl = callbackUrl;
        return this;
    }

    /**
     * The URL we should call when the interaction status changes..
     * 
     * @param callbackUrl The URL we should call when the interaction status changes
     * @return this
     */
    public ServiceCreator setCallbackUrl(final String callbackUrl) {
        return setCallbackUrl(Promoter.uriFromString(callbackUrl));
    }

    /**
     * Where a proxy number must be located relative to the participant identifier.
     * Can be: `country`, `area-code`, or `extended-area-code`. The default value is
     * `country` and more specific areas than `country` are only available in North
     * America..
     * 
     * @param geoMatchLevel Where a proxy number must be located relative to the
     *                      participant identifier
     * @return this
     */
    public ServiceCreator setGeoMatchLevel(final Service.GeoMatchLevel geoMatchLevel) {
        this.geoMatchLevel = geoMatchLevel;
        return this;
    }

    /**
     * The preference for Proxy Number selection in the Service instance. Can be:
     * `prefer-sticky` or `avoid-sticky` and the default is `prefer-sticky`.
     * `prefer-sticky` means that we will try and select the same Proxy Number for a
     * given participant if they have previous
     * [Sessions](https://www.twilio.com/docs/proxy/api/session), but we will not
     * fail if that Proxy Number cannot be used.  `avoid-sticky` means that we will
     * try to use different Proxy Numbers as long as that is possible within a given
     * pool rather than try and use a previously assigned number..
     * 
     * @param numberSelectionBehavior The preference for Proxy Number selection for
     *                                the Service instance
     * @return this
     */
    public ServiceCreator setNumberSelectionBehavior(final Service.NumberSelectionBehavior numberSelectionBehavior) {
        this.numberSelectionBehavior = numberSelectionBehavior;
        return this;
    }

    /**
     * The URL we call on each interaction. If we receive a 403 status, we block the
     * interaction; otherwise the interaction continues..
     * 
     * @param interceptCallbackUrl The URL we call on each interaction
     * @return this
     */
    public ServiceCreator setInterceptCallbackUrl(final URI interceptCallbackUrl) {
        this.interceptCallbackUrl = interceptCallbackUrl;
        return this;
    }

    /**
     * The URL we call on each interaction. If we receive a 403 status, we block the
     * interaction; otherwise the interaction continues..
     * 
     * @param interceptCallbackUrl The URL we call on each interaction
     * @return this
     */
    public ServiceCreator setInterceptCallbackUrl(final String interceptCallbackUrl) {
        return setInterceptCallbackUrl(Promoter.uriFromString(interceptCallbackUrl));
    }

    /**
     * The URL we should call when an inbound call or SMS action occurs on a closed
     * or non-existent Session. If your server (or a Twilio
     * [function](https://www.twilio.com/functions)) responds with valid
     * [TwiML](https://www.twilio.com/docs/voice/twiml), we will process it. This
     * means it is possible, for example, to play a message for a call, send an
     * automated text message response, or redirect a call to another Phone Number.
     * See [Out-of-Session Callback Response
     * Guide](https://www.twilio.com/docs/proxy/out-session-callback-response-guide)
     * for more information..
     * 
     * @param outOfSessionCallbackUrl The URL we call when an inbound call or SMS
     *                                action occurs on a closed or non-existent
     *                                Session
     * @return this
     */
    public ServiceCreator setOutOfSessionCallbackUrl(final URI outOfSessionCallbackUrl) {
        this.outOfSessionCallbackUrl = outOfSessionCallbackUrl;
        return this;
    }

    /**
     * The URL we should call when an inbound call or SMS action occurs on a closed
     * or non-existent Session. If your server (or a Twilio
     * [function](https://www.twilio.com/functions)) responds with valid
     * [TwiML](https://www.twilio.com/docs/voice/twiml), we will process it. This
     * means it is possible, for example, to play a message for a call, send an
     * automated text message response, or redirect a call to another Phone Number.
     * See [Out-of-Session Callback Response
     * Guide](https://www.twilio.com/docs/proxy/out-session-callback-response-guide)
     * for more information..
     * 
     * @param outOfSessionCallbackUrl The URL we call when an inbound call or SMS
     *                                action occurs on a closed or non-existent
     *                                Session
     * @return this
     */
    public ServiceCreator setOutOfSessionCallbackUrl(final String outOfSessionCallbackUrl) {
        return setOutOfSessionCallbackUrl(Promoter.uriFromString(outOfSessionCallbackUrl));
    }

    /**
     * The SID of the Chat Service Instance managed by Proxy Service. The Chat
     * Service enables Proxy to forward SMS and channel messages to this chat
     * instance. This is a one-to-one relationship..
     * 
     * @param chatInstanceSid The SID of the Chat Service Instance
     * @return this
     */
    public ServiceCreator setChatInstanceSid(final String chatInstanceSid) {
        this.chatInstanceSid = chatInstanceSid;
        return this;
    }

    /**
     * Make the request to the Twilio API to perform the create.
     * 
     * @param client TwilioRestClient with which to make the request
     * @return Created Service
     */
    @Override
    @SuppressWarnings("checkstyle:linelength")
    public Service create(final TwilioRestClient client) {
        Request request = new Request(
            HttpMethod.POST,
            Domains.PROXY.toString(),
            "/v1/Services",
            client.getRegion()
        );

        addPostParams(request);
        Response response = client.request(request);

        if (response == null) {
            throw new ApiConnectionException("Service creation failed: Unable to connect to server");
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

    /**
     * Add the requested post parameters to the Request.
     * 
     * @param request Request to add post params to
     */
    private void addPostParams(final Request request) {
        if (uniqueName != null) {
            request.addPostParam("UniqueName", uniqueName);
        }

        if (defaultTtl != null) {
            request.addPostParam("DefaultTtl", defaultTtl.toString());
        }

        if (callbackUrl != null) {
            request.addPostParam("CallbackUrl", callbackUrl.toString());
        }

        if (geoMatchLevel != null) {
            request.addPostParam("GeoMatchLevel", geoMatchLevel.toString());
        }

        if (numberSelectionBehavior != null) {
            request.addPostParam("NumberSelectionBehavior", numberSelectionBehavior.toString());
        }

        if (interceptCallbackUrl != null) {
            request.addPostParam("InterceptCallbackUrl", interceptCallbackUrl.toString());
        }

        if (outOfSessionCallbackUrl != null) {
            request.addPostParam("OutOfSessionCallbackUrl", outOfSessionCallbackUrl.toString());
        }

        if (chatInstanceSid != null) {
            request.addPostParam("ChatInstanceSid", chatInstanceSid);
        }
    }
}