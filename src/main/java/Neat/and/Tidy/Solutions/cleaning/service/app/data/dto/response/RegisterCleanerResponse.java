package Neat.and.Tidy.Solutions.cleaning.service.app.data.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class RegisterCleanerResponse {
    private String message;
    private String name;
}
