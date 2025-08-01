package com.ctw.workstation.booking.mapper;

import com.ctw.workstation.booking.dto.BookingCreateDTO;
import com.ctw.workstation.booking.dto.BookingDTO;
import com.ctw.workstation.booking.dto.BookingUpdateDTO;
import com.ctw.workstation.booking.entity.Booking;

public class BookingMapper {

    public static Booking toEntity(BookingCreateDTO dto) {
        Booking booking = new Booking();
        booking.setBookFrom(dto.bookFrom);
        booking.setBookTo(dto.bookTo);
        return booking;
    }

    public static void updateEntity(BookingUpdateDTO dto, Booking booking) {
        booking.setBookFrom(dto.bookFrom);
        booking.setBookTo(dto.bookTo);
    }

    public static BookingDTO toDTO(Booking booking) {
        BookingDTO dto = new BookingDTO();
        dto.id = booking.getId();
        dto.bookFrom = booking.getBookFrom();
        dto.bookTo = booking.getBookTo();
        dto.rackId = booking.getRack().getId();
        dto.requesterId = booking.getRequesterId().getId();
        return dto;
    }
}
