package com.noon.app.resource;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/firstApp")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Service
@Slf4j
public class MyHttp {
    @GET
    @Path("/v1/firstApp")
    public Response ingest() {
        log.info("HIT IN THE API");
        return null;
    }
}
