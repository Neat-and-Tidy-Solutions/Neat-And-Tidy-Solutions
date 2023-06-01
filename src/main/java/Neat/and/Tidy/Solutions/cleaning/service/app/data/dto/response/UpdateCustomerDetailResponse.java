package Neat.and.Tidy.Solutions.cleaning.service.app.data.dto.response;

import Neat.and.Tidy.Solutions.cleaning.service.app.data.models.Gender;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UpdateCustomerDetailResponse {
    private Long id;
    private String message;
    private String email;
    private String firstName;
    private String secondName;
}
