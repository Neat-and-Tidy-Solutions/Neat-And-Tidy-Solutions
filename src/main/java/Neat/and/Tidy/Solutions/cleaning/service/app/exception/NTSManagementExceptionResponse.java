package Neat.and.Tidy.Solutions.cleaning.service.app.exception;

import lombok.Builder;
import lombok.Data;
import org.springframework.http.HttpStatus;
@Data
@Builder
public class NTSManagementExceptionResponse {
    private String message;
    private HttpStatus status;
}
