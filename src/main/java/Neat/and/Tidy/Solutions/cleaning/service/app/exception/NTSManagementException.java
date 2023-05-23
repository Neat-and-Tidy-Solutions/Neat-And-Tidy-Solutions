package Neat.and.Tidy.Solutions.cleaning.service.app.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

public class NTSManagementException extends RuntimeException{
    @Getter
    private HttpStatus status = HttpStatus.BAD_REQUEST;

    public NTSManagementException(){
        this("An error occurred");
    }
    public NTSManagementException(String message){
        super(message);
    }
    public NTSManagementException(String message, HttpStatus status){
        this(message);
        this.status = status;
    }
}
