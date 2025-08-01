package com.ctw.workstation.team.mapper;

import com.ctw.workstation.team.dto.TeamCreateDTO;
import com.ctw.workstation.team.dto.TeamDTO;
import com.ctw.workstation.team.dto.TeamUpdateDTO;
import com.ctw.workstation.team.entity.Team;

import java.util.UUID;

public class TeamMapper {

    public static Team toEntity(TeamCreateDTO dto) {
        Team team = new Team();
        team.setName(dto.name);
        team.setProduct(dto.product);
        team.setDefaultLocation(dto.defaultLocation);
        return team;
    }

    public static void updateEntity(TeamUpdateDTO dto, Team team) {
        team.setName(dto.name);
        team.setProduct(dto.product);
        team.setDefaultLocation(dto.defaultLocation);
    }

    public static TeamDTO toDTO(Team team) {
        TeamDTO dto = new TeamDTO();
        dto.id = team.getId();
        dto.name = team.getName();
        dto.product = team.getProduct();
        dto.defaultLocation = team.getDefaultLocation();
        return dto;
    }
}
