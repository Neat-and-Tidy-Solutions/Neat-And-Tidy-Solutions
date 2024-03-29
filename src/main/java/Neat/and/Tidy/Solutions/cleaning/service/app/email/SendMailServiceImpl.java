package Neat.and.Tidy.Solutions.cleaning.service.app.email;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
//@AllArgsConstructor
@RequiredArgsConstructor
public class SendMailServiceImpl implements SendMailService {

    private final MailService mailService;

    private final JavaMailSender javaMailSender;


    @Override
    public String sendMail(EmailSendingRequest request) {
        EmailRequest emailRequest = EmailRequest.builder()
                .to(List.of(new Recipient(request.getRecipientName(), request.getRecipientEmail())))
                .subject("Invitation to be an Admin of NTJS Cleaning Company")
                .htmlContent(""" 
                        We are pleased to invite you to become an admin of the cleaning service industry.
                        As an admin, you will have the ability to manage users, create and edit cleaning jobs, and track the progress of cleaning jobs.
                        To accept this invitation, please click on the following link:
                        http://localhost:8080/admin/accept-invitation. \s
                        Thank you for your time and consideration.
                        Sincerely, The NTS Cleaning Service Industry Team.
                        """)
                .build();
        //emailRequest.getTo().add(new Recipient(request.getRecipientName(), request.getRecipientEmail()));

        return mailService.sendMail(emailRequest);
    }

    @Override
    public void send(String to) {
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setTo(to);
        mailMessage.setFrom("neatandtidyjanitorialservices");
        mailMessage.setSubject("CONGRATULATIONS OUR DEAR ESTEEMED CUSTOMER");
        mailMessage.setText("""
                We are pleased to have you on our platform.
                Please click on the following link to access your dashboard and be in AWE at the services we render:
                http://localhost:8080/customer/dashboard.\s
                Thank you for your time and consideration.
                Sincerely, The NTS Cleaning Service Industry Team
                """);

        javaMailSender.send(mailMessage);
    }


}
