package Neat.and.Tidy.Solutions.cleaning.service.app.exception;

import org.springframework.http.HttpStatus;

public class TokenNotFoundException extends NTSManagementException{
    public TokenNotFoundException(){
        this("Token not found!");
    }
    public TokenNotFoundException(String message){
        super(message, HttpStatus.NOT_FOUND);
    }
}
