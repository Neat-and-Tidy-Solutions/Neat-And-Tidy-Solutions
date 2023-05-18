package Neat.and.Tidy.Solutions.cleaning.service.app.data.dto.request;

import Neat.and.Tidy.Solutions.cleaning.service.app.data.models.Cleaner;
import Neat.and.Tidy.Solutions.cleaning.service.app.data.models.Customer;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import java.time.LocalDateTime;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AcceptOrderRequest {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String requestId;
    private Customer customer;
    private String serviceType;
    private LocalDateTime schedule;
    private Cleaner[] cleaners;
    private String additionalNotes;
}
