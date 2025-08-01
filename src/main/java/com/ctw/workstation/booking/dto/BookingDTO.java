package com.ctw.workstation.booking.dto;

import org.eclipse.microprofile.openapi.annotations.media.Schema;

import java.time.Instant;
import java.util.Date;
import java.util.UUID;

@Schema(name = "Booking", description = "Booking read model")
public class BookingDTO {
    public UUID id;
    public UUID rackId;
    public UUID requesterId;
    public Date bookFrom;
    public Date bookTo;
    public Date createdAt;
    public Date modifiedAt;
}
