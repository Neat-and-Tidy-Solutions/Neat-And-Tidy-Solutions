package Neat.and.Tidy.Solutions.cleaning.service.app.email;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
public class Recipient {
    private String name;
    private String email;
}
