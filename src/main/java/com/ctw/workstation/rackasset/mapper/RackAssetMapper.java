package com.ctw.workstation.rackasset.mapper;

import com.ctw.workstation.rack.entity.Rack;
import com.ctw.workstation.rackasset.dto.*;
import com.ctw.workstation.rackasset.entity.RackAsset;

public class RackAssetMapper {

    public static RackAsset toEntity(RackAssetCreateDTO dto, Rack rack) {
        RackAsset entity = new RackAsset();
        entity.setAssetTag(dto.assetTag);
        entity.setRack(rack);
        return entity;
    }

    public static void updateEntity(RackAssetUpdateDTO dto, RackAsset entity) {
        if (dto.assetTag != null) {
            entity.setAssetTag(dto.assetTag);
        }
    }

    public static RackAssetDTO toDTO(RackAsset entity) {
        RackAssetDTO dto = new RackAssetDTO();
        dto.id = entity.getId();
        dto.assetTag = entity.getAssetTag();
        dto.rackId = entity.getRack().getId();
        return dto;
    }
}
