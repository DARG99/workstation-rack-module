package com.ctw.workstation.team.dto;

import org.eclipse.microprofile.openapi.annotations.media.Schema;

@Schema(name = "TeamUpdate", description = "Fields you can change on a team")
public class TeamUpdateDTO {
    public String name;
    public String product;
    public String defaultLocation;
}
