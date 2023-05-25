package Neat.and.Tidy.Solutions.cleaning.service.app.data.dto.request;

import Neat.and.Tidy.Solutions.cleaning.service.app.data.models.Gender;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class RegisterCustomerRequest {
    private String firstName;
    private String secondName;
    private String email;
    private String contactNumber;
    private String address;
    private Gender gender;
    private String password;
}
