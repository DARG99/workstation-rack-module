// BookingCreateDTO.java
package com.ctw.workstation.booking.dto;


import org.eclipse.microprofile.openapi.annotations.media.Schema;

import java.time.Instant;
import java.util.Date;
import java.util.UUID;

@Schema(name = "BookingCreate", description = "Fields required to create a booking")
public class BookingCreateDTO {

    @Schema(required = true) public UUID rackId;
    @Schema(required = true) public UUID requesterId;

    @Schema(required = true, example = "2025-07-15T09:00:00Z")
    public Date bookFrom;

    @Schema(required = true, example = "2025-07-15T17:00:00Z")
    public Date bookTo;
}
