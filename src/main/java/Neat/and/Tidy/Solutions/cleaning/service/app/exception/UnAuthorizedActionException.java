package Neat.and.Tidy.Solutions.cleaning.service.app.exception;

import org.springframework.http.HttpStatus;

public class UnAuthorizedActionException extends NTSManagementException{
    public UnAuthorizedActionException(){
        this("You do not have access to perform this action!");
    }
    public UnAuthorizedActionException(String message){
        super(message, HttpStatus.UNAUTHORIZED);

    }
}
