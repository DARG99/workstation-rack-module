package com.ctw.workstation.team.control;

import com.ctw.workstation.team.boundary.TeamRepository;
import com.ctw.workstation.team.dto.TeamCreateDTO;
import com.ctw.workstation.team.dto.TeamDTO;
import com.ctw.workstation.team.dto.TeamUpdateDTO;
import com.ctw.workstation.team.entity.Team;
import com.ctw.workstation.team.mapper.TeamMapper;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.NotFoundException;

import java.util.List;
import java.util.UUID;

@ApplicationScoped
public class TeamService {

    @Inject
    TeamRepository teamRepo;

    public List<TeamDTO> listTeams() {
        return teamRepo.listAll().stream()
                .map(TeamMapper::toDTO)
                .toList();
    }

    public TeamDTO getTeam(UUID id) {
        Team team = teamRepo.findById(id);
        if (team == null) throw new NotFoundException("Team not found");
        return TeamMapper.toDTO(team);
    }

    public TeamDTO createTeam(TeamCreateDTO dto) {
        Team team = TeamMapper.toEntity(dto);
        teamRepo.persist(team);
        return TeamMapper.toDTO(team);
    }

    public TeamDTO updateTeam(UUID id, TeamUpdateDTO dto) {
        Team team = teamRepo.findById(id);
        if (team == null) throw new NotFoundException("Team not found");

        TeamMapper.updateEntity(dto, team);
        return TeamMapper.toDTO(team);
    }

    public void deleteTeam(UUID id) {
        boolean deleted = teamRepo.deleteById(id);
        if (!deleted) throw new NotFoundException("Team not found");
    }
}
