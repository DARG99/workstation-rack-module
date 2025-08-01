package com.ctw.workstation.team.boundary;

import com.ctw.workstation.team.control.TeamService;
import com.ctw.workstation.team.dto.*;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;
import java.util.UUID;

@Path("/workstation/teams")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class TeamResource {

    @Inject
    TeamService teamService;

    @GET
    public List<TeamDTO> list() {
        return teamService.listTeams();
    }

    @POST
    @Transactional
    @Produces(MediaType.APPLICATION_JSON)
    public Response create(TeamCreateDTO body) {
        TeamDTO created = teamService.createTeam(body);
        return Response.status(Response.Status.CREATED).entity(created).build();
    }

    @GET
    @Path("{id}")
    public TeamDTO get(@PathParam("id") UUID id) {
        return teamService.getTeam(id);
    }

    @PUT
    @Path("{id}")
    @Transactional
    public TeamDTO update(@PathParam("id") UUID id, TeamUpdateDTO body) {
        return teamService.updateTeam(id, body);
    }

    @DELETE
    @Path("{id}")
    @Transactional
    public Response delete(@PathParam("id") UUID id) {
        teamService.deleteTeam(id);
        return Response.noContent().build(); // 204
    }
}
