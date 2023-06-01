package Neat.and.Tidy.Solutions.cleaning.service.app.email;

public interface MailService {
//    void sendEmail(String toEmail, String subject, String body) throws MessagingException;
    String sendMail(EmailRequest request);
    String sendCustomerMail(EmailSendingRequest request);
}

