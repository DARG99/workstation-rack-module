package com.ctw.workstation.rack.dto;

import org.eclipse.microprofile.openapi.annotations.media.Schema;

import java.util.UUID;

// RackCreateDTO.java
@Schema(name = "RackCreate", description="Fields required to create a rack")
public class    RackCreateDTO {

    @Schema(required = true)
    public String serialNumber;

    @Schema(required = true,
            enumeration = { "AVAILABLE", "BOOKED", "UNAVAILABLE" })
    public String status;

    @Schema(required = true)
    public String defaultLocation;

    @Schema(required = true)
    public UUID teamId;  // New field to associate rack to a team


    public RackCreateDTO(String serialNumber, String status, String defaultLocation, UUID teamId) {
        this.serialNumber = serialNumber;
        this.status = status;
        this.defaultLocation = defaultLocation;
        this.teamId = teamId;
    }
}
