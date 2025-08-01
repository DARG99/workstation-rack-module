package com.ctw.workstation.rack.control;

import com.ctw.workstation.rack.boundary.RackRepository;
import com.ctw.workstation.rack.dto.RackCreateDTO;
import com.ctw.workstation.rack.dto.RackDTO;
import com.ctw.workstation.rack.dto.RackUpdateDTO;
import com.ctw.workstation.rack.entity.Rack;
import com.ctw.workstation.rack.mapper.RackMapper;
import com.ctw.workstation.team.boundary.TeamRepository;
import com.ctw.workstation.team.entity.Team;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.BadRequestException;
import jakarta.ws.rs.NotFoundException;

import java.util.List;
import java.util.UUID;

@ApplicationScoped
public class RackService {

    @Inject
    RackRepository rackRepo;

    @Inject
    TeamRepository teamRepo;

    public RackDTO createRack(RackCreateDTO body){
        if (body == null || body.serialNumber == null || body.status == null || body.teamId == null || body.defaultLocation == null) {
            throw new BadRequestException("Missing required fields");
        }

        Team team = teamRepo.findById(body.teamId);
        if (team == null) throw new NotFoundException("Team not found");

        Rack rack = RackMapper.toEntity(body, team);
        rackRepo.persist(rack);

        return RackMapper.toDTO(rack);
    }


    public List<RackDTO> listRacks() {
        return rackRepo.listAll()
                .stream()
                .map(rack -> RackMapper.toDTO(rack))
                .toList(); // or .collect(Collectors.toList()) for Java 8–15
    }


    public RackDTO getRackById(UUID id) {
        Rack rack = rackRepo.findById(id);
        if (rack == null) throw new NotFoundException();
        return RackMapper.toDTO(rack);
    }

    public RackDTO updateRack(RackUpdateDTO body, UUID id) {
        Rack rack = rackRepo.findById(id);
        if (rack == null) throw new NotFoundException("Rack not found");

        Team team = teamRepo.findById(body.teamId);
        if (team == null) throw new NotFoundException("Team not found");

        RackMapper.updateEntity(body, rack, team); // ✅ Correct call
        return RackMapper.toDTO(rack);
    }

    public void deleteRack(UUID id) {
        Rack rack = rackRepo.findById(id);
        if (rack == null) throw new NotFoundException("Rack not found");
        rackRepo.delete(rack);
    }



}
