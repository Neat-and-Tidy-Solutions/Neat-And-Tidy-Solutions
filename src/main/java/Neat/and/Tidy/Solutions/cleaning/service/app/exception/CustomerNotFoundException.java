package Neat.and.Tidy.Solutions.cleaning.service.app.exception;

import org.springframework.http.HttpStatus;

public class CustomerNotFoundException extends NTSManagementException{
    public CustomerNotFoundException(){
        this("Customer not found!");
    }
    public CustomerNotFoundException(String message){
        super(message, HttpStatus.NOT_FOUND);
    }
}
