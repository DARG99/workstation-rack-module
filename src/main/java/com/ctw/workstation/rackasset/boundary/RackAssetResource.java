package com.ctw.workstation.rackasset.boundary;

import com.ctw.workstation.rackasset.control.RackAssetService;
import com.ctw.workstation.rackasset.dto.*;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;
import java.util.UUID;

@Path("/workstation/racks/{rackId}/assets")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class RackAssetResource {

    @Inject
    RackAssetService rackAssetService;

    @GET
    public List<RackAssetDTO> list(@PathParam("rackId") UUID rackId) {
        return rackAssetService.listAssets(rackId);
    }

    @POST
    @Transactional
    public Response create(@PathParam("rackId") UUID rackId, RackAssetCreateDTO body) {
        RackAssetDTO dto = rackAssetService.create(rackId, body);
        return Response.status(Response.Status.CREATED).entity(dto).build();
    }

    @PUT
    @Path("{id}")
    @Transactional
    public RackAssetDTO update(@PathParam("id") UUID id, RackAssetUpdateDTO body) {
        return rackAssetService.update(id, body);
    }

    @DELETE
    @Path("{id}")
    @Transactional
    public Response delete(@PathParam("id") UUID id) {
        rackAssetService.delete(id);
        return Response.noContent().build();
    }
}
