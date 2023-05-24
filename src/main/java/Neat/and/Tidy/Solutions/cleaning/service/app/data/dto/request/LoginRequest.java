package Neat.and.Tidy.Solutions.cleaning.service.app.data.dto.request;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LoginRequest {

    @Column(unique = true)
    private String email;
    private String password;
}
