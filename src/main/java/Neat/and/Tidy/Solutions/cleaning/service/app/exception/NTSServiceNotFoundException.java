package Neat.and.Tidy.Solutions.cleaning.service.app.exception;

import org.springframework.http.HttpStatus;

public class NTSServiceNotFoundException extends NTSManagementException{
    public NTSServiceNotFoundException() {
        this("Service not found!");
    }

    public NTSServiceNotFoundException(String message) {
        super(message, HttpStatus.NOT_FOUND);
    }


}
