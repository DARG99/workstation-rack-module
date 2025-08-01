package com.ctw.workstation.teammember.dto;

import org.eclipse.microprofile.openapi.annotations.media.Schema;

import java.util.UUID;

@Schema(name = "TeamMemberUpdate", description = "Fields that can be changed on a team member")
public class TeamMemberUpdateDTO {


    public String ctwId;
    public String name;
    public UUID teamId;
}
