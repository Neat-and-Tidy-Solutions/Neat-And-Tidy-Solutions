package Neat.and.Tidy.Solutions.cleaning.service.app.data.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UpdateCustomerResponse {
    private Long id;
    private String message;
}