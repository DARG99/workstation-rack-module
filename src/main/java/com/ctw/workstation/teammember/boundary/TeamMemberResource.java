// src/main/java/com/ctw/workstation/teammember/boundary/TeamMemberResource.java
package com.ctw.workstation.teammember.boundary;


import com.ctw.workstation.rack.dto.RackDTO;
import com.ctw.workstation.rack.dto.RackUpdateDTO;
import com.ctw.workstation.team.boundary.TeamRepository;
import com.ctw.workstation.team.entity.Team;
import com.ctw.workstation.teammember.boundary.TeamMemberRepository;
import com.ctw.workstation.teammember.control.TeamMemberService;
import com.ctw.workstation.teammember.dto.*;
import com.ctw.workstation.teammember.entity.TeamMember;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;
import java.util.UUID;

@Path("/workstation/teams/{teamId}/members")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class TeamMemberResource {
    @Inject
    TeamMemberService teamMemberService;

    @POST
    @Transactional
    public Response createTeamMember(TeamMemberCreateDTO body) {
        TeamMemberDTO teamMemberDTO = teamMemberService.createTeamMember(body);
        return Response.status(Response.Status.CREATED).entity(teamMemberDTO).build();

    }

    @GET
    public List<TeamMemberDTO> getTeamMembers(@PathParam("teamId") UUID teamId) {
        return teamMemberService.listTeamMembersByTeam(teamId);
    }

    @PUT @Path("{id}") @Transactional
    public TeamMemberDTO updateTeamMember(@PathParam("id") UUID id, TeamMemberUpdateDTO body) {
        return teamMemberService.updateTeamMember(id, body);
    }

    @DELETE @Path("{id}")
    @Transactional
    public Response deleteTeamMember(@PathParam("id") UUID id) {
        teamMemberService.deleteTeamMember(id);
        return Response.status(Response.Status.OK).build();
    }




}
