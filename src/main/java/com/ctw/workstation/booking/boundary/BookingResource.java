package com.ctw.workstation.booking.boundary;

import com.ctw.workstation.booking.control.BookingService;
import com.ctw.workstation.booking.dto.*;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;
import java.util.UUID;

@Path("/workstation/bookings")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class BookingResource {

    @Inject BookingService bookingService;

    @POST @Transactional
    public Response create(BookingCreateDTO body) {
        BookingDTO dto = bookingService.createBooking(body);
        return Response.status(Response.Status.CREATED).entity(dto).build();
    }

    @GET
    public List<BookingDTO> list() {
        return bookingService.listAll();
    }

    @GET @Path("{id}")
    public BookingDTO get(@PathParam("id") UUID id) {
        return bookingService.get(id);
    }

    @PUT @Path("{id}") @Transactional
    public BookingDTO update(@PathParam("id") UUID id, BookingUpdateDTO body) {
        return bookingService.update(id, body);
    }

    @DELETE @Path("{id}") @Transactional
    public Response delete(@PathParam("id") UUID id) {
        bookingService.delete(id);
        return Response.noContent().build();
    }
}
