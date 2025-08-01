package com.ctw.workstation.rackasset.control;

import com.ctw.workstation.rack.boundary.RackRepository;
import com.ctw.workstation.rack.entity.Rack;
import com.ctw.workstation.rackasset.boundary.RackAssetRepository;
import com.ctw.workstation.rackasset.dto.*;
import com.ctw.workstation.rackasset.entity.RackAsset;
import com.ctw.workstation.rackasset.mapper.RackAssetMapper;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.NotFoundException;

import java.util.List;
import java.util.UUID;

@ApplicationScoped
public class RackAssetService {

    @Inject
    RackRepository rackRepo;

    @Inject
    RackAssetRepository rackAssetRepo;

    public List<RackAssetDTO> listAssets(UUID rackId) {
        return rackAssetRepo.listByRackId(rackId)
                .stream()
                .map(RackAssetMapper::toDTO)
                .toList();
    }

    public RackAssetDTO create(UUID rackId, RackAssetCreateDTO dto) {
        Rack rack = rackRepo.findById(rackId);
        if (rack == null) throw new NotFoundException("Rack not found");

        RackAsset asset = RackAssetMapper.toEntity(dto, rack);
        rackAssetRepo.persist(asset);
        return RackAssetMapper.toDTO(asset);
    }

    public RackAssetDTO update(UUID id, RackAssetUpdateDTO dto) {
        RackAsset asset = rackAssetRepo.findById(id);
        if (asset == null) throw new NotFoundException("Asset not found");

        RackAssetMapper.updateEntity(dto, asset);
        return RackAssetMapper.toDTO(asset);
    }

    public void delete(UUID id) {
        boolean deleted = rackAssetRepo.deleteById(id);
        if (!deleted) throw new NotFoundException("Asset not found");
    }
}
