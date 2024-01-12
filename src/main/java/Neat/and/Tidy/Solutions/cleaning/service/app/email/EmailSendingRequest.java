package Neat.and.Tidy.Solutions.cleaning.service.app.email;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
public class EmailSendingRequest {
    //    private String senderName;
//    private String senderEmail;
    private String recipientName;
    private String recipientEmail;
//    private String subject;
//    private String content;
}
