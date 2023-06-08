package Neat.and.Tidy.Solutions.cleaning.service.app.email;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
public class MailConfig {
    private String apiKey;
    private String mailUrl;
}
