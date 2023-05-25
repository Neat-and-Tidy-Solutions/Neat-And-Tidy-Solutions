package Neat.and.Tidy.Solutions.cleaning.service.app.data.dto.request;

import Neat.and.Tidy.Solutions.cleaning.service.app.data.models.Gender;
import Neat.and.Tidy.Solutions.cleaning.service.app.data.models.Guarantor;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class RegisterCleanerRequest {
    private String name;
    @Column(unique = true)
    private String email;
    private String password;
    private String contactNumber;

}
