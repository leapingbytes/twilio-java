/**
 * This code was generated by
 * \ / _    _  _|   _  _
 *  | (_)\/(_)(_|\/| |(/_  v1.0.0
 *       /       /       
 */

package com.twilio.sdk.reader.taskrouter.v1.workspace;

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
import com.twilio.sdk.resource.taskrouter.v1.workspace.Worker;

public class WorkerReader extends Reader<Worker> {
    private final String workspaceSid;
    private String activityName;
    private String activitySid;
    private String available;
    private String friendlyName;
    private String targetWorkersExpression;
    private String taskQueueName;
    private String taskQueueSid;

    /**
     * Construct a new WorkerReader.
     * 
     * @param workspaceSid The workspace_sid
     */
    public WorkerReader(final String workspaceSid) {
        this.workspaceSid = workspaceSid;
    }

    /**
     * The activity_name.
     * 
     * @param activityName The activity_name
     * @return this
     */
    public WorkerReader byActivityName(final String activityName) {
        this.activityName = activityName;
        return this;
    }

    /**
     * The activity_sid.
     * 
     * @param activitySid The activity_sid
     * @return this
     */
    public WorkerReader byActivitySid(final String activitySid) {
        this.activitySid = activitySid;
        return this;
    }

    /**
     * The available.
     * 
     * @param available The available
     * @return this
     */
    public WorkerReader byAvailable(final String available) {
        this.available = available;
        return this;
    }

    /**
     * The friendly_name.
     * 
     * @param friendlyName The friendly_name
     * @return this
     */
    public WorkerReader byFriendlyName(final String friendlyName) {
        this.friendlyName = friendlyName;
        return this;
    }

    /**
     * The target_workers_expression.
     * 
     * @param targetWorkersExpression The target_workers_expression
     * @return this
     */
    public WorkerReader byTargetWorkersExpression(final String targetWorkersExpression) {
        this.targetWorkersExpression = targetWorkersExpression;
        return this;
    }

    /**
     * The task_queue_name.
     * 
     * @param taskQueueName The task_queue_name
     * @return this
     */
    public WorkerReader byTaskQueueName(final String taskQueueName) {
        this.taskQueueName = taskQueueName;
        return this;
    }

    /**
     * The task_queue_sid.
     * 
     * @param taskQueueSid The task_queue_sid
     * @return this
     */
    public WorkerReader byTaskQueueSid(final String taskQueueSid) {
        this.taskQueueSid = taskQueueSid;
        return this;
    }

    /**
     * Make the request to the Twilio API to perform the read.
     * 
     * @param client TwilioRestClient with which to make the request
     * @return Worker ResourceSet
     */
    @Override
    public ResourceSet<Worker> execute(final TwilioRestClient client) {
        return new ResourceSet<>(this, client, firstPage());
    }

    /**
     * Make the request to the Twilio API to perform the read.
     * 
     * @param client TwilioRestClient with which to make the request
     * @return Worker ResourceSet
     */
    @Override
    @SuppressWarnings("checkstyle:linelength")
    public Page<Worker> firstPage(final TwilioRestClient client) {
        Request request = new Request(
            HttpMethod.GET,
            TwilioRestClient.Domains.TASKROUTER,
            "/v1/Workspaces/" + this.workspaceSid + "/Workers",
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
    public Page<Worker> nextPage(final Page<Worker> page, 
                                 final TwilioRestClient client) {
        Request request = new Request(
            HttpMethod.GET,
            page.getNextPageUri(),
            client.getAccountSid()
        );
        return pageForRequest(client, request);
    }

    /**
     * Generate a Page of Worker Resources for a given request.
     * 
     * @param client TwilioRestClient with which to make the request
     * @param request Request to generate a page for
     * @return Page for the Request
     */
    private Page<Worker> pageForRequest(final TwilioRestClient client, final Request request) {
        Response response = client.request(request);
        
        if (response == null) {
            throw new ApiConnectionException("Worker read failed: Unable to connect to server");
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
            "workers",
            response.getContent(),
            Worker.class,
            client.getObjectMapper()
        );
    }

    /**
     * Add the requested query string arguments to the Request.
     * 
     * @param request Request to add query string arguments to
     */
    private void addQueryParams(final Request request) {
        if (activityName != null) {
            request.addQueryParam("ActivityName", activityName);
        }
        
        if (activitySid != null) {
            request.addQueryParam("ActivitySid", activitySid);
        }
        
        if (available != null) {
            request.addQueryParam("Available", available);
        }
        
        if (friendlyName != null) {
            request.addQueryParam("FriendlyName", friendlyName);
        }
        
        if (targetWorkersExpression != null) {
            request.addQueryParam("TargetWorkersExpression", targetWorkersExpression);
        }
        
        if (taskQueueName != null) {
            request.addQueryParam("TaskQueueName", taskQueueName);
        }
        
        if (taskQueueSid != null) {
            request.addQueryParam("TaskQueueSid", taskQueueSid);
        }
        
        request.addQueryParam("PageSize", Integer.toString(getPageSize()));
    }
}