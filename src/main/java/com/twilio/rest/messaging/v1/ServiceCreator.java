/**
 * This code was generated by
 * \ / _    _  _|   _  _
 *  | (_)\/(_)(_|\/| |(/_  v1.0.0
 *       /       /
 */

package com.twilio.rest.messaging.v1;

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
    private final String friendlyName;
    private URI inboundRequestUrl;
    private HttpMethod inboundMethod;
    private URI fallbackUrl;
    private HttpMethod fallbackMethod;
    private URI statusCallback;
    private Boolean stickySender;
    private Boolean mmsConverter;
    private Boolean smartEncoding;
    private Service.ScanMessageContent scanMessageContent;
    private Boolean fallbackToLongCode;
    private Boolean areaCodeGeomatch;
    private Integer validityPeriod;
    private Boolean synchronousValidation;

    /**
     * Construct a new ServiceCreator.
     * 
     * @param friendlyName A human readable descriptive text for this resource, up
     *                     to 64 characters.
     */
    public ServiceCreator(final String friendlyName) {
        this.friendlyName = friendlyName;
    }

    /**
     * A [webhook request](https://www.twilio.com/docs/api/twiml/sms/twilio_request)
     * is made to the Inbound Request URL when a message is received by any phone
     * number or shortcode associated to your Messaging Service. Set to `null` to
     * disable inbound messaging..
     * 
     * @param inboundRequestUrl A webhook request is made to the Inbound Request
     *                          URL when a message is received by any phone number
     *                          or shortcode associated to your Messaging Service.
     * @return this
     */
    public ServiceCreator setInboundRequestUrl(final URI inboundRequestUrl) {
        this.inboundRequestUrl = inboundRequestUrl;
        return this;
    }

    /**
     * A [webhook request](https://www.twilio.com/docs/api/twiml/sms/twilio_request)
     * is made to the Inbound Request URL when a message is received by any phone
     * number or shortcode associated to your Messaging Service. Set to `null` to
     * disable inbound messaging..
     * 
     * @param inboundRequestUrl A webhook request is made to the Inbound Request
     *                          URL when a message is received by any phone number
     *                          or shortcode associated to your Messaging Service.
     * @return this
     */
    public ServiceCreator setInboundRequestUrl(final String inboundRequestUrl) {
        return setInboundRequestUrl(Promoter.uriFromString(inboundRequestUrl));
    }

    /**
     * The HTTP method used when making requests to the Inbound Request URL. Either
     * `GET` or `POST`. Default value is `POST`..
     * 
     * @param inboundMethod The HTTP method used when making requests to the
     *                      Inbound Request URL.
     * @return this
     */
    public ServiceCreator setInboundMethod(final HttpMethod inboundMethod) {
        this.inboundMethod = inboundMethod;
        return this;
    }

    /**
     * A request is made to the Fallback URL if an error occurs with retrieving or
     * executing the TwiML from you Inbound Request URL..
     * 
     * @param fallbackUrl A request is made to the Fallback URL if an error occurs
     *                    with retrieving or executing the TwiML from you Inbound
     *                    Request URL.
     * @return this
     */
    public ServiceCreator setFallbackUrl(final URI fallbackUrl) {
        this.fallbackUrl = fallbackUrl;
        return this;
    }

    /**
     * A request is made to the Fallback URL if an error occurs with retrieving or
     * executing the TwiML from you Inbound Request URL..
     * 
     * @param fallbackUrl A request is made to the Fallback URL if an error occurs
     *                    with retrieving or executing the TwiML from you Inbound
     *                    Request URL.
     * @return this
     */
    public ServiceCreator setFallbackUrl(final String fallbackUrl) {
        return setFallbackUrl(Promoter.uriFromString(fallbackUrl));
    }

    /**
     * The HTTP method used when requesting the Fallback URL. Either `GET` or
     * `POST`. Default value is `POST`..
     * 
     * @param fallbackMethod The HTTP method used when requesting the Fallback URL.
     * @return this
     */
    public ServiceCreator setFallbackMethod(final HttpMethod fallbackMethod) {
        this.fallbackMethod = fallbackMethod;
        return this;
    }

    /**
     * A webhook request is made to the Status Callback to pass [status
     * updates](https://www.twilio.com/docs/api/rest/message#sms-status-values)
     * about your messages. These status updates let you know if your accepted
     * message were successfully sent and delivered or if a [delivery related
     * error](https://www.twilio.com/docs/api/rest/message#error-values) may have
     * occurred..
     * 
     * @param statusCallback A webhook request is made to the Status Callback to
     *                       pass status updates about your messages.
     * @return this
     */
    public ServiceCreator setStatusCallback(final URI statusCallback) {
        this.statusCallback = statusCallback;
        return this;
    }

    /**
     * A webhook request is made to the Status Callback to pass [status
     * updates](https://www.twilio.com/docs/api/rest/message#sms-status-values)
     * about your messages. These status updates let you know if your accepted
     * message were successfully sent and delivered or if a [delivery related
     * error](https://www.twilio.com/docs/api/rest/message#error-values) may have
     * occurred..
     * 
     * @param statusCallback A webhook request is made to the Status Callback to
     *                       pass status updates about your messages.
     * @return this
     */
    public ServiceCreator setStatusCallback(final String statusCallback) {
        return setStatusCallback(Promoter.uriFromString(statusCallback));
    }

    /**
     * Configuration to enable or disable Sticky Sender on your Service Instance.
     * Possible values are `true` and `false`. Default value is `true`..
     * 
     * @param stickySender Configuration to enable or disable Sticky Sender on your
     *                     Service Instance.
     * @return this
     */
    public ServiceCreator setStickySender(final Boolean stickySender) {
        this.stickySender = stickySender;
        return this;
    }

    /**
     * Configuration to enable or disable MMS Converter on your Service Instance.
     * Possible values are `true` and `false`. Default value is `true`..
     * 
     * @param mmsConverter Configuration to enable or disable MMS Converter on your
     *                     Service Instance.
     * @return this
     */
    public ServiceCreator setMmsConverter(final Boolean mmsConverter) {
        this.mmsConverter = mmsConverter;
        return this;
    }

    /**
     * Configuration to enable or disable [Smart
     * Encoding](https://www.twilio.com/docs/api/messaging/services-and-copilot#smart-encoding). Possible values are `true` and `false`. Default value is `true`..
     * 
     * @param smartEncoding Configuration to enable or disable Smart Encoding.
     * @return this
     */
    public ServiceCreator setSmartEncoding(final Boolean smartEncoding) {
        this.smartEncoding = smartEncoding;
        return this;
    }

    /**
     * The scan_message_content.
     * 
     * @param scanMessageContent The scan_message_content
     * @return this
     */
    public ServiceCreator setScanMessageContent(final Service.ScanMessageContent scanMessageContent) {
        this.scanMessageContent = scanMessageContent;
        return this;
    }

    /**
     * Configuration to enable or disable [Fallback to Long
     * Code](https://www.twilio.com/docs/api/messaging/services-and-copilot#fallback-to-long-code). Possible values are `true` and `false`. Default value is `false`..
     * 
     * @param fallbackToLongCode Configuration to enable or disable Fallback to
     *                           Long Code.
     * @return this
     */
    public ServiceCreator setFallbackToLongCode(final Boolean fallbackToLongCode) {
        this.fallbackToLongCode = fallbackToLongCode;
        return this;
    }

    /**
     * Configuration to enable or disable [Area Code
     * Geomatch](https://www.twilio.com/docs/api/messaging/services-and-copilot#area-code-geomatch). Possible values are `true` and `false`. Default value is `false`..
     * 
     * @param areaCodeGeomatch Configuration to enable or disable Area Code
     *                         Geomatch.
     * @return this
     */
    public ServiceCreator setAreaCodeGeomatch(final Boolean areaCodeGeomatch) {
        this.areaCodeGeomatch = areaCodeGeomatch;
        return this;
    }

    /**
     * Configuration to set the [validity
     * period](https://www.twilio.com/docs/api/messaging/services-and-copilot#validity-period) of all messages sent from your Service, in seconds. Acceptable integers range from `1` to `14,400`.  Default value is `14,400`..
     * 
     * @param validityPeriod Configuration to set the validity period of all
     *                       messages sent from your Service, in seconds.
     * @return this
     */
    public ServiceCreator setValidityPeriod(final Integer validityPeriod) {
        this.validityPeriod = validityPeriod;
        return this;
    }

    /**
     * The synchronous_validation.
     * 
     * @param synchronousValidation The synchronous_validation
     * @return this
     */
    public ServiceCreator setSynchronousValidation(final Boolean synchronousValidation) {
        this.synchronousValidation = synchronousValidation;
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
            Domains.MESSAGING.toString(),
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
        if (friendlyName != null) {
            request.addPostParam("FriendlyName", friendlyName);
        }

        if (inboundRequestUrl != null) {
            request.addPostParam("InboundRequestUrl", inboundRequestUrl.toString());
        }

        if (inboundMethod != null) {
            request.addPostParam("InboundMethod", inboundMethod.toString());
        }

        if (fallbackUrl != null) {
            request.addPostParam("FallbackUrl", fallbackUrl.toString());
        }

        if (fallbackMethod != null) {
            request.addPostParam("FallbackMethod", fallbackMethod.toString());
        }

        if (statusCallback != null) {
            request.addPostParam("StatusCallback", statusCallback.toString());
        }

        if (stickySender != null) {
            request.addPostParam("StickySender", stickySender.toString());
        }

        if (mmsConverter != null) {
            request.addPostParam("MmsConverter", mmsConverter.toString());
        }

        if (smartEncoding != null) {
            request.addPostParam("SmartEncoding", smartEncoding.toString());
        }

        if (scanMessageContent != null) {
            request.addPostParam("ScanMessageContent", scanMessageContent.toString());
        }

        if (fallbackToLongCode != null) {
            request.addPostParam("FallbackToLongCode", fallbackToLongCode.toString());
        }

        if (areaCodeGeomatch != null) {
            request.addPostParam("AreaCodeGeomatch", areaCodeGeomatch.toString());
        }

        if (validityPeriod != null) {
            request.addPostParam("ValidityPeriod", validityPeriod.toString());
        }

        if (synchronousValidation != null) {
            request.addPostParam("SynchronousValidation", synchronousValidation.toString());
        }
    }
}