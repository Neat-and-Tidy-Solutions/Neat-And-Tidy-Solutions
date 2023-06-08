package Neat.and.Tidy.Solutions.cleaning.service.app.email;


public interface MailService {
    String sendMail(EmailRequest request);

    String sendCustomerMail(EmailSendingRequest request);
}
