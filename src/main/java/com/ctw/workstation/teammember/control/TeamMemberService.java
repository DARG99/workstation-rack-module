package com.ctw.workstation.teammember.control;

import com.ctw.workstation.team.boundary.TeamRepository;
import com.ctw.workstation.team.entity.Team;
import com.ctw.workstation.teammember.boundary.TeamMemberRepository;
import com.ctw.workstation.teammember.dto.TeamMemberCreateDTO;
import com.ctw.workstation.teammember.dto.TeamMemberDTO;
import com.ctw.workstation.teammember.dto.TeamMemberUpdateDTO;
import com.ctw.workstation.teammember.entity.TeamMember;
import com.ctw.workstation.teammember.mapper.TeamMemberMapper;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.BadRequestException;
import jakarta.ws.rs.NotFoundException;

import java.util.List;
import java.util.UUID;

@ApplicationScoped
public class TeamMemberService {

    @Inject
    TeamRepository teamRepo;

    @Inject
    TeamMemberRepository teamMemberRepo;

    public TeamMemberDTO createTeamMember(TeamMemberCreateDTO body) {
        if (body == null || body.ctwId == null || body.name == null || body.teamId == null) {
            throw new BadRequestException("Missing required fields");
        }

        Team team = teamRepo.findById(body.teamId);
        if (team == null) throw new NotFoundException("Team not found");

        TeamMember teamMember = TeamMemberMapper.toEntity(body, team);
        teamMemberRepo.persist(teamMember);

        return TeamMemberMapper.toDTO(teamMember);
    }

    public List<TeamMemberDTO> listTeamMembersByTeam(UUID teamId) {
        return teamMemberRepo.listByTeamId(teamId)
                .stream()
                .map(TeamMemberMapper::toDTO)
                .toList();
    }

public TeamMemberDTO getTeamMemberById(UUID id) {
        TeamMember teamMember = teamMemberRepo.findById(id);
        if (teamMember == null) throw new NotFoundException("Team member not found");
        return TeamMemberMapper.toDTO(teamMember);
}

public TeamMemberDTO updateTeamMember(UUID id, TeamMemberUpdateDTO body) {
        TeamMember teamMember = teamMemberRepo.findById(id);
        if (teamMember == null) throw new NotFoundException("Team member not found");
        Team team = teamRepo.findById(body.teamId);
        if (team == null) throw new NotFoundException("Team not found");
        TeamMemberMapper.updateEntity(body, teamMember,team);
        return  TeamMemberMapper.toDTO(teamMember);
}


public void deleteTeamMember(UUID id) {
        TeamMember teamMember = teamMemberRepo.findById(id);
        if (teamMember == null) throw new NotFoundException("Team member not found");

}
}


