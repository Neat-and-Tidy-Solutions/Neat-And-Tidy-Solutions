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
public class UpdateCustomerRequest {
    private String fullName;
    private String email;
    private String contactNumber;
    private String address;
    private String userName;
}
