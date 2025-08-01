package com.ctw.workstation.booking.control;

import com.ctw.workstation.booking.boundary.BookingRepository;
import com.ctw.workstation.booking.dto.*;
import com.ctw.workstation.booking.entity.Booking;
import com.ctw.workstation.booking.mapper.BookingMapper;
import com.ctw.workstation.rack.boundary.RackRepository;
import com.ctw.workstation.rack.entity.Rack;
import com.ctw.workstation.teammember.boundary.TeamMemberRepository;
import com.ctw.workstation.teammember.entity.TeamMember;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.BadRequestException;
import jakarta.ws.rs.NotFoundException;

import java.util.List;
import java.util.UUID;

@ApplicationScoped
public class BookingService {

    @Inject
    BookingRepository bookingRepo;

    @Inject
    RackRepository rackRepo;

    @Inject
    TeamMemberRepository memberRepo;

    public BookingDTO createBooking(BookingCreateDTO body) {
        if (body == null || body.rackId == null || body.requesterId == null ||
                body.bookFrom == null || body.bookTo == null) {
            throw new BadRequestException("Missing required fields");
        }

        Rack rack = rackRepo.findById(body.rackId);
        if (rack == null) throw new NotFoundException("Rack not found");

        TeamMember requester = memberRepo.findById(body.requesterId);
        if (requester == null) throw new NotFoundException("Requester not found");

        Booking booking = BookingMapper.toEntity(body);
        booking.setRack(rack);
        booking.setRequesterId(requester);
        bookingRepo.persist(booking);

        return BookingMapper.toDTO(booking);
    }

    public List<BookingDTO> listAll() {
        return bookingRepo.listAll().stream().map(BookingMapper::toDTO).toList();
    }

    public BookingDTO get(UUID id) {
        Booking b = bookingRepo.findById(id);
        if (b == null) throw new NotFoundException();
        return BookingMapper.toDTO(b);
    }

    public BookingDTO update(UUID id, BookingUpdateDTO body) {
        Booking b = bookingRepo.findById(id);
        if (b == null) throw new NotFoundException();
        BookingMapper.updateEntity(body, b);
        return BookingMapper.toDTO(b);
    }

    public void delete(UUID id) {
        boolean deleted = bookingRepo.deleteById(id);
        if (!deleted) throw new NotFoundException();
    }
}
