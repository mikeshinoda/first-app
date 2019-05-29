package com.noon.app.resource;

import com.fasterxml.jackson.databind.util.JSONPObject;
import com.google.common.collect.Maps;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.noon.app.models.SecondRoute;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
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
        JsonObject object = new JsonObject();
        object.addProperty("title", "value");
        return Response.status(Response.Status.OK).entity(object.toString()).build();
    }

    @GET
    @Path("/v1/secondRoute1")
    public Response ingest1() {
        log.info("HIT IN THE API-2");
        SecondRoute res = new SecondRoute();
        res.setId(1);
        res.setMessage("hello");
        return Response.status(Response.Status.OK).entity(res).build();
    }
}
