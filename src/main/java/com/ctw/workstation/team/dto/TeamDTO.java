// src/main/java/com/ctw/workstation/team/dto/TeamDTO.java
package com.ctw.workstation.team.dto;

import io.quarkus.runtime.annotations.RegisterForReflection;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

import java.util.UUID;


@Schema(name = "Team", description = "Team read model")
public class TeamDTO {

    public UUID   id;
    public String name;
    public String product;
    public String defaultLocation;
}
