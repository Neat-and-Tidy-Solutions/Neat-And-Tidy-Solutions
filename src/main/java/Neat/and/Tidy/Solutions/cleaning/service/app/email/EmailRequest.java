package Neat.and.Tidy.Solutions.cleaning.service.app.email;

import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
public class EmailRequest {
    private final Sender sender = new Sender("Neat and Tidy", "neatidy@info.com");
    private List<Recipient> to;
    private String subject;
    private String htmlContent;
}
