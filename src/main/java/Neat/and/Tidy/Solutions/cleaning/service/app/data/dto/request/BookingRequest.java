package Neat.and.Tidy.Solutions.cleaning.service.app.data.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BookingRequest {
    private Long customerId;
    private String cleaningServiceName;
    private LocalDateTime bookingDateTime;
}
