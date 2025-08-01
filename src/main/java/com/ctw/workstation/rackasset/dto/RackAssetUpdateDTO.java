package com.ctw.workstation.rackasset.dto;

import org.eclipse.microprofile.openapi.annotations.media.Schema;

@Schema(name = "RackAssetUpdate", description = "Fields you can change on a rack‑asset")
public class RackAssetUpdateDTO {
    public String assetTag;   // optional → PATCH‑like behaviour
}
