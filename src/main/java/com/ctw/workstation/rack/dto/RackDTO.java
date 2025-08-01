package com.ctw.workstation.rack.dto;

import org.eclipse.microprofile.openapi.annotations.media.Schema;

import java.util.UUID;

@Schema(name = "Rack", description = "Rack read model")
public class RackDTO {

    public UUID id;
    public String serialNumber;
    public String status;
    public String defaultLocation;
}
