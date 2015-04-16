package com.patrickwilson.examples.gae.mvm.controller;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;


/**
 * Created by pwilson on 4/16/15.
 */
@Path("/")
public class IndexResource {

    @GET
    public Response showIndexPage() {
        return Response.ok("Hello World").build();
    }
}
