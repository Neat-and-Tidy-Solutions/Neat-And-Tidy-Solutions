package Neat.and.Tidy.Solutions.cleaning.service.app.email;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class SendMailServiceImpl implements SendMailService {

    private final MailService mailService;

    @Override
    public String sendMail(EmailSendingRequest request) {
        EmailRequest emailRequest = EmailRequest.builder()
                .to(List.of(new Recipient(request.getRecipientName(), request.getRecipientEmail())))
                .subject("Invitation to be an Admin of NTJS Cleaning Company")
                .htmlContent(" We are pleased to invite you to become an admin of the cleaning service industry." +
                        " As an admin, you will have the ability to manage users, create and edit cleaning jobs, and track the progress of cleaning jobs." +
                        " To accept this invitation, please click on the following link: " +
                        "http://localhost:8080/admin/accept-invitation. Thank you for your time and consideration." +
                        "Sincerely, The NTSJ Cleaning Service Industry Team")
                .build();
        //emailRequest.getTo().add(new Recipient(request.getRecipientName(), request.getRecipientEmail()));

        return mailService.sendMail(emailRequest);
    }
}
