package Neat.and.Tidy.Solutions.cleaning.service.app.data.dto.request;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class GiveFeedbackRequest {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String requestId;
    private String customerName;
    private String cleanerName;
    private int rating;
    private String feedback;
}
