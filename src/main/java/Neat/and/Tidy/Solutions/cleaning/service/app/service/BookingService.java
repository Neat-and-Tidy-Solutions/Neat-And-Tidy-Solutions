package Neat.and.Tidy.Solutions.cleaning.service.app.service;

import Neat.and.Tidy.Solutions.cleaning.service.app.data.dto.request.BookingRequest;
import Neat.and.Tidy.Solutions.cleaning.service.app.data.models.Booking;

import java.util.List;
import java.util.Optional;

public interface BookingService {
    Booking createBooking(BookingRequest bookingRequest);
    List<Booking> getBookingsByCustomerId(Long customerId);
    List<Booking> getAllBookings();
    void cancelBooking(Long bookingId, Long customerId);
}
