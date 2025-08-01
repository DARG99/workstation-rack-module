// src/main/java/com/ctw/workstation/rack/boundary/RackResource.java
package com.ctw.workstation.rack.boundary;


import com.ctw.workstation.rack.control.RackService;
import com.ctw.workstation.rack.dto.*;
import com.ctw.workstation.rack.entity.Rack;
import com.ctw.workstation.team.boundary.TeamRepository;
import com.ctw.workstation.team.entity.Team;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;
import java.util.UUID;

@Path("/workstation/racks")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class RackResource {

    @Inject
    RackService rackService;

    @POST
    @Transactional
    @Produces(MediaType.APPLICATION_JSON)
    public Response createRack(RackCreateDTO body) {
        RackDTO dto = rackService.createRack(body);
        return Response.status(Response.Status.CREATED).entity(dto).build();
    }

    @GET
    public List<RackDTO> listAllRacks() {
        return rackService.listRacks();
    }

    @GET @Path("{id}")
    public RackDTO getById(@PathParam("id") UUID id) {
        return rackService.getRackById(id);
    }

    @PUT
    @Path("{id}")
    @Transactional
    public RackDTO updateRack(@PathParam("id") UUID id, RackUpdateDTO body) {
        return rackService.updateRack(body, id);
    }

    @DELETE @Path("{id}")
    @Transactional
    public Response deleteRack(@PathParam("id") UUID id) {
        rackService.deleteRack(id);
        return Response.status(Response.Status.OK).build();
    }

}
