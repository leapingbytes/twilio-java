package com.twilio.sdk.fetcher;

import com.google.common.util.concurrent.ListenableFuture;
import com.twilio.sdk.Twilio;
import com.twilio.sdk.http.TwilioRestClient;
import com.twilio.sdk.resource.Resource;

import java.util.concurrent.Callable;

/**
 * Executor for fetches of a resource.
 *
 * @param <T> type of the resource
 */
public abstract class Fetcher<T extends Resource> {

    /**
     * Execute an async request using default client.
     *
     * @return future that resolves to requested object
     */
    public ListenableFuture<T> async() {
        return async(Twilio.getRestClient());
    }

    /**
     * Execute an async request using specified client.
     *
     * @param client client used to make request
     * @return future that resolves to requested object
     */
    public ListenableFuture<T> async(final TwilioRestClient client) {
        return Twilio.getExecutorService().submit(new Callable<T>() {
            public T call() {
                return execute(client);
            }
        });
    }

    /**
     * Execute a request using default client.
     *
     * @return Requested object
     */
    public T execute() {
        return execute(Twilio.getRestClient());
    }

    /**
     * Execute a request using specified client.
     *
     * @param client client used to make request
     * @return Requested object
     */
    public abstract T execute(final TwilioRestClient client);
}
