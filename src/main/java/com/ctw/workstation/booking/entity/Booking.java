package com.ctw.workstation.booking.entity;


import com.ctw.workstation.rack.entity.Rack;
import com.ctw.workstation.teammember.entity.TeamMember;
import jakarta.persistence.*;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.sql.Time;
import java.sql.Timestamp;
import java.util.Date;
import java.util.UUID;
@Entity
@Table(name="t_booking")
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "rack_id", nullable = false)
    private Rack rack;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "requester_id", nullable = false)
    private TeamMember requesterId;

    @Column(name="book_from")
    private Date bookFrom;

    @Column(name="book_to")
    private Date bookTo;

    @Column(name="created_at")
    @CreationTimestamp
    @Schema(hidden = true)
    private Timestamp createdAt ;

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

    public Rack getRack() {
        return rack;
    }

    public void setRack(Rack rack) {
        this.rack = rack;
    }

    public TeamMember getRequesterId() {
        return requesterId;
    }

    public void setRequesterId(TeamMember requesterId) {
        this.requesterId = requesterId;
    }

    public Date getBookFrom() {
        return bookFrom;
    }

    public void setBookFrom(Date bookFrom) {
        this.bookFrom = bookFrom;
    }

    public Date getBookTo() {
        return bookTo;
    }

    public void setBookTo(Date bookTo) {
        this.bookTo = bookTo;
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
