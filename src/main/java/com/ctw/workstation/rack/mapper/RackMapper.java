package com.ctw.workstation.rack.mapper;

import com.ctw.workstation.rack.dto.RackCreateDTO;
import com.ctw.workstation.rack.dto.RackDTO;
import com.ctw.workstation.rack.dto.RackUpdateDTO;
import com.ctw.workstation.rack.entity.Rack;
import com.ctw.workstation.team.entity.Team;

public class RackMapper {

    public static Rack toEntity(RackCreateDTO dto, Team team) {
        Rack rack = new Rack();
        rack.setSerialNumber(dto.serialNumber);
        rack.setStatus(Rack.Status.valueOf(dto.status.toUpperCase()));
        rack.setTeam(team);
        rack.setDefaultLocation(dto.defaultLocation);
        return rack;
    }


    public static void updateEntity(RackUpdateDTO dto, Rack rack, Team team) {
        rack.setSerialNumber(dto.serialNumber);
        rack.setStatus(Rack.Status.valueOf(dto.status.toUpperCase()));
        rack.setTeam(team);
        rack.setDefaultLocation(dto.defaultLocation);

    }


    public static RackDTO toDTO(Rack rack) {
        RackDTO dto = new RackDTO();
        dto.id = rack.getId();
        dto.serialNumber = rack.getSerialNumber();
        dto.status = rack.getStatus().toString();
        dto.defaultLocation = rack.getDefaultLocation();

        return dto;
    }
}
