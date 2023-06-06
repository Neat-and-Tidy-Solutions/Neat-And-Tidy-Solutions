package Neat.and.Tidy.Solutions.cleaning.service.app.exception;

import org.springframework.http.HttpStatus;

public class BookingNotFoundException extends NTSManagementException{
    public BookingNotFoundException(){
        this("Booking not found!");
    }
    public BookingNotFoundException(String message){
        super(message, HttpStatus.NOT_FOUND);
    }
}
