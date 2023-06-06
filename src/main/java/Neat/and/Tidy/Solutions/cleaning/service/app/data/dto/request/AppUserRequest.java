package Neat.and.Tidy.Solutions.cleaning.service.app.data.dto.request;

import Neat.and.Tidy.Solutions.cleaning.service.app.data.models.Gender;
import Neat.and.Tidy.Solutions.cleaning.service.app.email.EmailRequest;
import Neat.and.Tidy.Solutions.cleaning.service.app.email.EmailSendingRequest;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AppUserRequest {
    private String username;
    private String fullName;
//    @Column(unique = true)
    private String email;
    private String password;
    private String contactNumber;
//    @Enumerated(value = EnumType.STRING)
    private Gender gender;
}
