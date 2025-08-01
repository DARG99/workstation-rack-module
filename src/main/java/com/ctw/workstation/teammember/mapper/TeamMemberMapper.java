package com.ctw.workstation.teammember.mapper;

import com.ctw.workstation.rack.dto.RackUpdateDTO;
import com.ctw.workstation.rack.entity.Rack;
import com.ctw.workstation.team.entity.Team;
import com.ctw.workstation.teammember.dto.TeamMemberCreateDTO;
import com.ctw.workstation.teammember.dto.TeamMemberDTO;
import com.ctw.workstation.teammember.dto.TeamMemberUpdateDTO;
import com.ctw.workstation.teammember.entity.TeamMember;

public class TeamMemberMapper {

    public static TeamMember toEntity(TeamMemberCreateDTO dto, Team team){
        TeamMember teamMember = new TeamMember();
        teamMember.setCtwId(dto.ctwId);
        teamMember.setName(dto.name);
        teamMember.setTeam(team);
        return teamMember;
    }

    public static void updateEntity(TeamMemberUpdateDTO dto, TeamMember teamMember, Team team) {
        teamMember.setCtwId(dto.ctwId);
        teamMember.setName(dto.name);
        teamMember.setTeam(team);
    }

    public static TeamMemberDTO toDTO(TeamMember teamMember) {
        TeamMemberDTO dto = new TeamMemberDTO();
        dto.id = teamMember.getId();
        dto.ctwId = teamMember.getCtwId();
        dto.name = teamMember.getName();
        dto.teamId = teamMember.getTeam().getId();
        return dto;
    }
}
