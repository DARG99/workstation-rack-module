package com.ctw.workstation.booking.dto;

import org.eclipse.microprofile.openapi.annotations.media.Schema;

import java.time.Instant;
import java.util.Date;

@Schema(name = "BookingUpdate", description = "Fields that can be changed on a booking")
public class BookingUpdateDTO {

    public Date bookFrom;
    public Date bookTo;
}
