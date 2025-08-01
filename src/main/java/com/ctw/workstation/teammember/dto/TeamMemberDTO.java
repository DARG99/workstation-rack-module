// src/main/java/com/ctw/workstation/teammember/dto/TeamMemberDTO.java
package com.ctw.workstation.teammember.dto;

import io.quarkus.runtime.annotations.RegisterForReflection;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

import java.util.UUID;

@RegisterForReflection
@Schema(name = "TeamMember", description = "Team member read model")
public class TeamMemberDTO {

    public UUID   id;
    public String ctwId;
    public String name;
    public UUID   teamId;
}
