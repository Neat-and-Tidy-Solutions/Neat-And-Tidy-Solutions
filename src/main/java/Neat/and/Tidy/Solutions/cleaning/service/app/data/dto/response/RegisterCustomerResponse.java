package Neat.and.Tidy.Solutions.cleaning.service.app.data.dto.response;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RegisterCustomerResponse {
    private Long id;
    private String message;
    private String email;
    private String firstName;
    private String secondName;
}
