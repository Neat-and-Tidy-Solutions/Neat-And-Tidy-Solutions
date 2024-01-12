package Neat.and.Tidy.Solutions.cleaning.service.app.controller;

import Neat.and.Tidy.Solutions.cleaning.service.app.data.dto.request.BookingRequest;
import Neat.and.Tidy.Solutions.cleaning.service.app.data.models.Booking;
import Neat.and.Tidy.Solutions.cleaning.service.app.service.BookingService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.awt.print.Book;
import java.util.List;
import java.util.Optional;
@CrossOrigin
@AllArgsConstructor
@RestController
@RequestMapping("/booking")
public class BookingController {
    private final BookingService bookingService;

@PostMapping("/book_service")
    public ResponseEntity<?> bookAService(@RequestBody BookingRequest bookingRequest){
    Booking bookedService = bookingService.createBooking(bookingRequest);
    return new ResponseEntity<>(bookedService, HttpStatus.OK);
}
@GetMapping("/get_bookings/{customerId}")
    public ResponseEntity<?> getBookingsBtCustomerId(@PathVariable Long customerId){
    List<Booking> customerBookings = bookingService.getBookingsByCustomerId(customerId);
    return new ResponseEntity<>(customerBookings, HttpStatus.OK);
}
@GetMapping("/getAllBookings")
    public ResponseEntity<?> findAllBookings(){
    List<Booking> bookingList = bookingService.getAllBookings();
    return new ResponseEntity<>(bookingList, HttpStatus.OK);
}
@DeleteMapping("/cancelBooking/{bookingId}/{customerId}")
    public ResponseEntity<?> cancelBooking(@PathVariable Long bookingId, @PathVariable Long customerId){
    bookingService.cancelBooking(bookingId, customerId);
    return ResponseEntity.ok().build();
}
}
