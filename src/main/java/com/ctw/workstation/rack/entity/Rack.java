package com.ctw.workstation.rack.entity;
import com.ctw.workstation.team.entity.Team;
import jakarta.persistence.*;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.Date;
import java.util.UUID;

@Entity
@Table(name="t_rack")
public class Rack {

    public enum Status {
        AVAILABLE,
        BOOKED,
        UNAVAILABLE
    }

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name="serial_number", length = 30, nullable = false)
    private String serialNumber;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Status status;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "team_id", nullable = false)
    private Team team;

    @Column(name ="default_location", length = 30)
    private String defaultLocation;

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

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    public String getDefaultLocation() {
        return defaultLocation;
    }

    public void setDefaultLocation(String defaultLocation) {
        this.defaultLocation = defaultLocation;
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
