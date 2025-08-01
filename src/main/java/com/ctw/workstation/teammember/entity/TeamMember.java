package com.ctw.workstation.teammember.entity;

import com.ctw.workstation.rack.entity.Rack;
import com.ctw.workstation.team.entity.Team;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.sql.Timestamp;
import java.util.Date;
import java.util.UUID;
@Entity
@Table(name="t_team_member")
public class TeamMember {

    @Id
    @Schema(hidden = true)
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name="ctw_id", length = 30)
    private String ctwId;

    @Column(name="name", length = 30)
    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "team_id", nullable = false)
    private Team team;

    @Column(name="created_at")
    @CreationTimestamp
    @Schema(hidden = true)
    private Timestamp createdAt;

    @Column(name="modified_at")
    @UpdateTimestamp
    @Schema(hidden = true)
    private Timestamp modifiedAt;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getCtwId() {
        return ctwId;
    }

    public void setCtwId(String ctwId) {
        this.ctwId = ctwId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    public Timestamp getModifiedAt() {
        return modifiedAt;
    }

    public void setModifiedAt(Timestamp modifiedAt) {
        this.modifiedAt = modifiedAt;
    }
}
