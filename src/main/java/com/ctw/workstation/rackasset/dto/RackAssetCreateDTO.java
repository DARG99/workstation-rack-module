package com.ctw.workstation.rackasset.dto;

import org.eclipse.microprofile.openapi.annotations.media.Schema;

@Schema(name = "RackAssetCreate", description = "Fields required to create a rack‑asset entry")
public class RackAssetCreateDTO {

    @Schema(required = true, example = "ASSET‑12345")
    public String assetTag;
}
