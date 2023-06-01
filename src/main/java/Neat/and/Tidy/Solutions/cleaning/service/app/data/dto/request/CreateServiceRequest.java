package Neat.and.Tidy.Solutions.cleaning.service.app.data.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CreateServiceRequest {
    private String serviceName;
    private String serviceDescription;
}
