package Neat.and.Tidy.Solutions.cleaning.service.app.data.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CreateServiceResponse {
    private Long id;
    private String message;
}
