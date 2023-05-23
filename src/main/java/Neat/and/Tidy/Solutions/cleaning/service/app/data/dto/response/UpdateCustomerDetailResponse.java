package Neat.and.Tidy.Solutions.cleaning.service.app.data.dto.response;

import Neat.and.Tidy.Solutions.cleaning.service.app.data.models.Gender;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class UpdateCustomerDetailResponse {
    private Long id;
    private String name;
    private String email;
    private String contactNumber;
    private String address;
    private Gender gender;
    private String password;
}
