package Neat.and.Tidy.Solutions.cleaning.service.app.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

public class NTSManagementExceptionHandler {
    @ExceptionHandler(NTSManagementException.class)
    public ResponseEntity<NTSManagementExceptionResponse> handleEmailApplicationException(NTSManagementException exception){
        var response = NTSManagementExceptionResponse
                .builder()
                .message(exception.getMessage())
                .status(exception.getStatus())
                .build();
        return new ResponseEntity<>(response, exception.getStatus());
    }
}
