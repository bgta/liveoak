/*
 * Copyright 2013 Red Hat, Inc. and/or its affiliates.
 *
 * Licensed under the Eclipse Public License version 1.0, available at http://www.eclipse.org/legal/epl-v10.html
 */
package io.liveoak.common;

import java.util.UUID;

import io.liveoak.spi.MediaTypeMatcher;
import io.liveoak.spi.ResourceRequest;
import io.liveoak.spi.ResourceResponse;
import io.liveoak.spi.resource.async.Resource;
import io.liveoak.spi.state.ResourceState;

/**
 * @author Bob McWhirter
 */
public class DefaultResourceResponse implements ResourceResponse {


    public DefaultResourceResponse(ResourceRequest inReplyTo, ResponseType responseType) {
        this.inReplyTo = inReplyTo;
        this.responseType = responseType;
    }

    public DefaultResourceResponse(ResourceRequest inReplyTo, ResponseType responseType, Resource resource) {
        this.inReplyTo = inReplyTo;
        this.responseType = responseType;
        this.resource = resource;
    }

    @Override
    public UUID requestId() {
        return this.inReplyTo.requestId();
    }

    public MediaTypeMatcher mediaTypeMatcher() {
        return this.inReplyTo.mediaTypeMatcher();
    }

    @Override
    public ResourceRequest inReplyTo() {
        return this.inReplyTo;
    }

    @Override
    public ResponseType responseType() {
        return this.responseType;
    }

    @Override
    public ResourceState state() {
        return this.state;
    }

    @Override
    public void setState(ResourceState state) {
        this.state = state;
    }


    @Override
    public Resource resource() {
        return this.resource;
    }

    public String toString() {
        return "[DefaultResourceResponse: type=" + this.responseType + "; object=" + this.resource + "]";
    }

    private ResourceRequest inReplyTo;
    private ResponseType responseType;
    private ResourceState state;
    private Resource resource;
}
