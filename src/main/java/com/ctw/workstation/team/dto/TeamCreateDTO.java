// src/main/java/com/ctw/workstation/team/dto/TeamCreateDTO.java
package com.ctw.workstation.team.dto;

import org.eclipse.microprofile.openapi.annotations.media.Schema;

@Schema(name = "TeamCreate", description = "Fields required to create a Team")
public class TeamCreateDTO {

    @Schema(required = true)
    public String name;

    @Schema(required = true)
    public String product;

    @Schema(required = true)
    public String defaultLocation;

    public TeamCreateDTO(String name, String product, String defaultLocation) {
        this.name = name;
        this.product = product;
        this.defaultLocation = defaultLocation;
    }
}
