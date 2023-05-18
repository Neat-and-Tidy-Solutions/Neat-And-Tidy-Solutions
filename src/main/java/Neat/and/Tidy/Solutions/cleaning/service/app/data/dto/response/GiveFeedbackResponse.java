package Neat.and.Tidy.Solutions.cleaning.service.app.data.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class GiveFeedbackResponse {
    @Id
    private String requestId;
    private String customerName;
    private String cleanerName;
    private int rating;
    private String feedback;
}
