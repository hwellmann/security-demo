package org.ops4j.security;

import javax.enterprise.context.ApplicationScoped;
import javax.json.Json;
import javax.json.JsonObject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@ApplicationScoped
@Path("version")
@Produces(MediaType.APPLICATION_JSON)
@PermissionsAllowed("USER")
public class VersionResource {

    @GET
    public Response version() {
        JsonObject version = Json.createObjectBuilder().add("version", 1).build();
        return Response.ok().entity(version).build();
    }
}
