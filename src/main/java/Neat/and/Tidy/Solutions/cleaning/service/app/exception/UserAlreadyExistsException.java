package Neat.and.Tidy.Solutions.cleaning.service.app.exception;

import org.springframework.http.HttpStatus;

public class UserAlreadyExistsException extends NTSManagementException{
    public UserAlreadyExistsException() {
        this("User with email address already exists!");
    }

    public UserAlreadyExistsException(String message) {
        super(message, HttpStatus.BAD_REQUEST);
    }
}
