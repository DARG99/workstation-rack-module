package com.ctw.workstation.rack.dto;

import org.eclipse.microprofile.openapi.annotations.media.Schema;

import java.util.UUID;

@Schema(name = "RackUpdate", description = "Fields you can change on a rack")
public class RackUpdateDTO {

    public String serialNumber;
    @Schema(enumeration = { "AVAILABLE", "BOOKED", "UNAVAILABLE" })
    public String status;
    public String defaultLocation;
    public UUID teamId;



}
