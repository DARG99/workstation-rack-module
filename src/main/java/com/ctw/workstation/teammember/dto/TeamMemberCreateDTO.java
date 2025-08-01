// src/main/java/com/ctw/workstation/teammember/dto/TeamMemberCreateDTO.java
package com.ctw.workstation.teammember.dto;

import org.eclipse.microprofile.openapi.annotations.media.Schema;

import java.util.UUID;

@Schema(name = "TeamMemberCreate", description = "Fields required to add a member to a team")
public class TeamMemberCreateDTO {

    @Schema(required = true)
    public String ctwId;

    @Schema(required = true)
    public String name;

    @Schema(required = true)
    public UUID teamId;
}
