package com.ctw.workstation.rackasset.dto;

import org.eclipse.microprofile.openapi.annotations.media.Schema;

import java.util.UUID;

@Schema(name = "RackAsset", description = "Rack‑asset read model")
public class RackAssetDTO {
    public UUID   id;
    public String assetTag;
    public UUID rackId;
}
