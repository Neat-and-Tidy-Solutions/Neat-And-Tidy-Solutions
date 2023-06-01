package Neat.and.Tidy.Solutions.cleaning.service.app.service.impl;

import Neat.and.Tidy.Solutions.cleaning.service.app.data.dto.request.BookingRequest;
import Neat.and.Tidy.Solutions.cleaning.service.app.data.models.Booking;
import Neat.and.Tidy.Solutions.cleaning.service.app.data.models.Customer;
import Neat.and.Tidy.Solutions.cleaning.service.app.data.models.Services;
import Neat.and.Tidy.Solutions.cleaning.service.app.data.repositories.BookingRepository;
import Neat.and.Tidy.Solutions.cleaning.service.app.data.repositories.CustomerRepository;
import Neat.and.Tidy.Solutions.cleaning.service.app.data.repositories.ServiceRepository;
import Neat.and.Tidy.Solutions.cleaning.service.app.exception.BookingNotFoundException;
import Neat.and.Tidy.Solutions.cleaning.service.app.exception.UnAuthorizedActionException;
import Neat.and.Tidy.Solutions.cleaning.service.app.service.BookingService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BookingServiceImpl implements BookingService {
    private final BookingRepository bookingRepository;
    private final CustomerRepository customerRepository;
    private final ServiceRepository serviceRepository;
    @Override
    public Booking createBooking(BookingRequest bookingRequest) {
        Customer customer = customerRepository.findById(bookingRequest.getCustomerId())
                .orElseThrow(()-> new IllegalArgumentException("Invalid customer ID"));
        Services services = serviceRepository.findServiceByName(bookingRequest.getCleaningServiceName())
                .orElseThrow(()-> new IllegalArgumentException("Invalid NTS cleaning service ID"));

        Booking booking = Booking.builder()
                .customerBooking(customer.getId())
                .cleaningServiceName(services.getName())
                .bookingDateTime(bookingRequest.getBookingDateTime())
                .build();
        bookingRepository.save(booking);
        return bookingRepository.save(booking);
    }
    @Override
    public Optional<Booking> getBookingsByCustomerId(Long customerId) {
        return bookingRepository.findById(customerId);
    }
    public List<Booking> getAllBookings(){
        return bookingRepository.findAll();
    }
    public void cancelBooking(Long bookingId, Long customerId){
       Booking foundBooking = bookingRepository.findById(bookingId).orElseThrow(BookingNotFoundException::new);
       if(foundBooking.getCustomerBooking().equals(customerId)){
           bookingRepository.delete(foundBooking);
       }
       else throw new UnAuthorizedActionException("You are not authorized to cancel this order / booking");
    }
}
