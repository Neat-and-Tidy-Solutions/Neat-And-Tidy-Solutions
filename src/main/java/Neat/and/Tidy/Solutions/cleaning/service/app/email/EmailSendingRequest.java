package Neat.and.Tidy.Solutions.cleaning.service.app.email;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class EmailSendingRequest {
    private String recipientName;
    private String recipientEmail;
}
