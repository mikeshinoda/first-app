package com.noon.app.resource;

import com.google.gson.JsonObject;
import com.noon.app.models.CreateTokenRequest;
import com.noon.app.models.SecondRoute;
import com.noon.app.utils.JwtHandler;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Map;

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

    @GET
    @Path("/v1/secondRoute2/{abc}")
    public Response ingest2(@NotEmpty @PathParam("abc") String abc) {
        log.info("HIT IN THE API-3");
        log.info(abc);
        SecondRoute res = new SecondRoute();
        res.setId(1);
        res.setMessage("hi");
        return Response.status(Response.Status.OK).entity(res).build();
    }

    @POST
    @Path("/v1/secondRoute2/{abc}")
    public Response ingest3(@NotEmpty @PathParam("abc") String abc, @NotEmpty Map<String, Object> payload) {
        log.info("HIT IN THE API-4");
        log.info(abc);
        SecondRoute res = new SecondRoute();
        res.setId(1);
        res.setMessage("hi");
        return Response.status(Response.Status.OK).entity(res).build();
    }

    @POST
    @Path("/v1/createToken")
    public Response ingest4(@Valid CreateTokenRequest payload) {
        SecondRoute res = new SecondRoute();
        res.setId(1);
        JwtHandler jwtHandler = new JwtHandler();
        String token = jwtHandler.createToken("akshit@noon.sa", "7988289150", "1234", "web", 0);
        log.info(token);
        res.setMessage(token);
        return Response.status(Response.Status.OK).entity(res).build();
    }
}
